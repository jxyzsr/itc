import prettytable
import torch
import torchvision.transforms as transforms
from thenetmodel import MobileNetV3_large
from PIL import Image
import numpy as np
import torch.nn.functional as F

# 创建一个检测器类，包含了图片的读取，检测等方法
class Detector(object):
    # netkind为'large'或'small'可以选择加载MobileNetV3_large或MobileNetV3_small
    # 需要事先训练好对应网络的权重
    def __init__(self,net_kind,num_classes):
        super(Detector, self).__init__()
        kind=net_kind.lower()
        if kind=='large':
            self.net = MobileNetV3_large(num_classes=num_classes)
        elif kind=='small':
            self.net = MobileNetV3_large(num_classes=num_classes)
        self.net.eval()

    def load_weights(self,weight_path):
        device = torch.device("cuda:0" if torch.cuda.is_available() else "cpu")
        self.net.load_state_dict(torch.load(weight_path,map_location=device))

    # 检测器主体
    def detect(self,weight_path,pic_path):
        # 先加载权重
        self.load_weights(weight_path=weight_path)
        # 读取图片
        img=Image.open(pic_path).convert('RGB')
        transform = transforms.Compose([
            transforms.Resize((224, 224)),
            transforms.ToTensor(),
        ])
        img_tensor = transform(img).unsqueeze(0)
        net_output = self.net(img_tensor)
        print(net_output)
        _, predicted = torch.max(net_output.data, 1)
        result = predicted[0].item()
        print("预测的结果为：",result)
        return result

    #进行模型评估
    def envaluate(self,weight_path,test_loader):
        # 先加载权重
        self.load_weights(weight_path=weight_path)
        test_losses = []
        test_counter = []
        for epoch in range(1,2):
            # 在测试集上评估模型
            test_loss = 0
            correct = 0
            batch_size_test = 64
            # 输出每个类别的精确率和召回率
            train_result = np.zeros((12, 12), dtype=int)
            with torch.no_grad():
                for batch_idx, (data, target) in enumerate(test_loader):
                    output = self.net(data)
                    for i in range(len(data)):
                        train_result[target[i]][np.argmax(output[i])] += 1
                    test_loss += F.nll_loss(output, target, reduction='sum').item()
                    pred = output.data.max(1, keepdim=True)[1]
                    correct += pred.eq(target.data.view_as(pred)).sum()
                    test_counter.append((batch_idx * batch_size_test))
                    test_losses.append(test_loss)
            test_loss /= len(test_loader.dataset)

            print('\nTest set: Avg. loss: {:.4f}, Accuracy: {}/{} ({:.0f}%)\n'.format(test_loss, correct,
                                                                                      len(test_loader.dataset),
                                                                                      100. * correct / len(
                                                                                          test_loader.dataset)))
            result_table = prettytable.PrettyTable()
            result_table.field_names = ['Type', 'Accuracy(精确率)', 'Recall(召回率)', 'F1_Score']
            class_names = ['battery', 'biological', 'cardboard', 'clothes', 'green-glass', 'metal', 'paper', 'plastic', 'shoes', 'trash', 'white-glass', 'white-glass']
            for i in range(12):
                accuracy = train_result[i][i] / train_result.sum(axis=0)[i]
                recall = train_result[i][i] / train_result.sum(axis=1)[i]
                result_table.add_row([class_names[i],
                                      np.round(accuracy, 3),
                                      np.round(recall, 3),
                                      np.round(accuracy * recall * 2 / (accuracy + recall), 3)])
            print(result_table)

