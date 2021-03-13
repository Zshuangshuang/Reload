# 单元测试模块
import unittest
# 用来生成报告的模块
from HTMLTestRunner import HTMLTestRunner
import sys
import time
import os

if __name__ == "__main__":
    test_dir = './'
    discover = unittest.defaultTestLoader.discover(test_dir, pattern='test*.py')
    # 取当前路径
    curPath = sys.path[0]
    # 取当前时间
    now = time.strftime("%Y-%m-%d-%H %M %S", time.localtime(time.time()))
    # 判断这个路径是不是已经生成过测试报告
    if not os.path.exists(curPath + '/report'):
        os.makedirs(curPath + '/report')
    filename = curPath + '/report' + now + 'report.html'
    with open(filename, 'wb')as resultReport:
        runner = HTMLTestRunner.HTMLTestRunner(stream=resultReport, title=u"测试报告", description=u"用例执行情况", verbosity=2)
        runner.run()
