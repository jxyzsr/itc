#不能更换位置，让服务器变为非阻塞的，多线程的
from gevent import monkey
monkey.patch_all()

from Webapp import app
from gevent.pywsgi import WSGIServer


if __name__ == '__main__':
     #启动服务
     print('The server was created successfully!!!')
     server = WSGIServer(('0.0.0.0', 5000), app)
     server.serve_forever()