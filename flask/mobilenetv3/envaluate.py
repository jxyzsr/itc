import os
from torch.utils.data import DataLoader
from torchvision.transforms import transforms
import inference
from data.dataset import rubbishDataset


split_dir=os.path.join(".","data","splitData")#./data/splitData/
valid_dir=os.path.join(split_dir,"valid")#./data/splitData/valid
#对验证集所需要做的预处理
valid_transform=transforms.Compose([
    transforms.Resize((224,224)),
    transforms.ToTensor(),
])
# 构建MyDataset实例
valid_data=rubbishDataset(data_dir=valid_dir,transform=valid_transform)
valid_loader=DataLoader(dataset=valid_data,batch_size=64)
detector = inference.Detector('large', num_classes=12)
detector.envaluate('./weights/last.pkl',valid_loader)