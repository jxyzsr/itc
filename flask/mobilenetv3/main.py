import sys
from PyQt5 import QtWidgets,QtGui
from PyQt5.QtWidgets import *
import inference

class picture(QWidget):
    def __init__(self):
        super(picture, self).__init__()

        self.name = ""

        self.resize(1600, 1000)
        self.setWindowTitle("垃圾分类")

        self.label = QLabel(self)
        self.label.setText("        选择图片")
        self.label.setFixedSize(700, 700)
        self.label.move(160, 100)
        self.label.setStyleSheet("QLabel{background:white;}"
                                 "QLabel{color:rgb(300,300,300,120);font-size:50px;font-weight:bold;font-family:等线;}"
                                 )

        self.label2 = QLabel(self)
        self.label2.setText("无结果")
        self.label2.setFixedSize(600, 50)
        self.label2.move(900, 400)
        self.label2.setStyleSheet("QLabel{background:white;}"
                                 "QLabel{color:rgb(300,300,300,120);font-size:35px;font-weight:bold;font-family:等线;}"
                                 )
        btn = QPushButton(self)
        btn.setText("打开图片")
        btn.move(50,50)
        btn.clicked.connect(self.openimage)
        btn2 = QPushButton(self)
        btn2.setText("开始预测")
        btn2.move(500,900)
        btn2.clicked.connect(self.forecast)
    def openimage(self):
        imgName, imgType = QFileDialog.getOpenFileName(self, "打开图片", "", "*.jpg;;*.png;;All Files(*)")
        jpg = QtGui.QPixmap(imgName).scaled(self.label.width(), self.label.height())
        self.name = imgName
        self.label.setPixmap(jpg)
    def forecast(self):
        prosess = '正在预测，请稍后'
        self.label2.setText(prosess)
        detector = inference.Detector('large', num_classes=12)
        num = str(detector.detect('./weights/best.pkl',self.name))
        if num == "0":
            result = "电池，其为有害垃圾"
        elif num == "1":
            result = "食物，其为厨余垃圾"
        elif num == "2":
            result = "棕色玻璃，其为可回收垃圾"
        elif num == "3":
            result = "纸箱，其为可回收垃圾"
        elif num == "4":
            result = "衣物，其为可回收垃圾"
        elif num == "5":
            result = "绿玻璃，其为可回收垃圾"
        elif num == "6":
            result = "金属，其为可回收垃圾"
        elif num == "7":
            result = "纸张，其为可回收垃圾"
        elif num == "8":
            result = "塑料，其为可回收垃圾"
        elif num == "9":
            result = "鞋子，其为可回收垃圾"
        elif num == "10":
            result = "口罩，其为其他垃圾"
        elif num == "11":
            result = "透明玻璃，其为可回收垃圾"
        self.label2.setText("检测为" + result)

if __name__ == "__main__":
    app = QtWidgets.QApplication(sys.argv)
    my = picture()
    my.show()
    sys.exit(app.exec_())