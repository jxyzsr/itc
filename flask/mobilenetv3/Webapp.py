import pymysql
from flask import Flask, request, render_template, abort
from flask_cors import CORS
from flask_sqlalchemy import SQLAlchemy
import inference
"""-------------------------------------------------config-----------------------------------------------------------------"""
app = Flask(__name__,template_folder='../templates',static_folder='../static')
CORS(app, resources=r'/*')	# 注册CORS, "/*" 允许访问所有api
#解决跨域
CORS(app, supports_credentials=True)
#配置数据库地址
app.config['SQLALCHEMY_DATABASE_URI'] ='mysql://root:hbn@127.0.0.1:3306/itc'
#设置第二个数据库
SQLALCHEMY_BINDS = {
    'sqlserve': 'mssql://dsjxy:dsjxy@47.104.89.208:14333/GYDX_HBN_DSJXY?driver=SQL Server',
}
app.config['SQLALCHEMY_BINDS'] = SQLALCHEMY_BINDS
# 跟踪数据库的修改，不建议开启
app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False
db = SQLAlchemy(app)
"""-------------------------------------------------DATABASES-----------------------------------------------------------------"""
class Trash(db.Model):
    #定义表名
    __tablename__ = 'trash'
    #定义字段
    name = db.Column(db.String(255),primary_key=True)
    type = db.Column(db.String(255),primary_key=True)
    frequency = db.Column(db.Integer)
    #init赋予类实体属性值
    def __init__(self,name,type,frequency):
        self.name = name
        self.type = name
        self.frequency = frequency
    #repr()方法显示一个可读字符串
    def __repr__(self):
        return '%s,%s,%d' % (self.name,self.type,self.frequency)
"""-------------------------------------------------URL-----------------------------------------------------------------"""
@app.route('/trashclassficion',methods=['POST'])
def trashclassficion():
    img = request.files.get('photo')
    path = "../static/photo/"
    file_path = path + img.filename
    img.save(file_path)
    detector = inference.Detector('large', num_classes=12)
    num = str(detector.detect('./weights/best.pkl',file_path))
    result = ""
    if num == "0":
        result = "电池:有害垃圾"
    elif num == "1":
        result = "食物:厨余垃圾"
    elif num == "2":
        result = "棕色玻璃:可回收垃圾"
    elif num == "3":
        result = "纸箱:可回收垃圾"
    elif num == "4":
        result = "衣物:可回收垃圾"
    elif num == "5":
        result = "绿玻璃:可回收垃圾"
    elif num == "6":
        result = "金属:可回收垃圾"
    elif num == "7":
        result = "纸张:可回收垃圾"
    elif num == "8":
        result = "塑料:可回收垃圾"
    elif num == "9":
        result = "鞋子:可回收垃圾"
    elif num == "10":
        result = "口罩:其他垃圾"
    elif num == "11":
        result = "透明玻璃:可回收垃圾"
    tehstr = ":"
    name = result[:result.index(tehstr)][:]
    thetype = result[result.index(tehstr):][1:]
    thedb = pymysql.connect(host="localhost", user="root",
                            password="hbn", db="itc", port=3306, charset='utf8')
    cur = thedb.cursor()
    sql1 = "select * from trash where name = %s and type = %s"
    if cur.execute(sql1, [name, thetype]) == 0:
        sql2 = "insert into trash(name,type,frequency) values(%s,%s,1)"
        cur.execute(sql2, [name, thetype])
        thedb.commit()
        thedb.close()
    else:
        sql3 = "update trash set frequency = frequency+1 where name = %s and type = %s"
        cur.execute(sql3, [name, thetype])
        thedb.commit()
        thedb.close()
    return render_template("trashclassficion.html",result = result,file_path = file_path)

