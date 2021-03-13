# 引入unittest框架
import unittest


# class定义了一个TestMethod类继承自unittest.TestCase
class TestMethod(unittest.TestCase):
    # setUp方法是用于测试类执行前的初始化操作
    def setUp(self):
        print("test start")

    def test_upper(self):
        # assertEqual是TestCase中的断言方法，就是判断后面括号中的两个参数是否相同，不同则返回false
        self.assertEqual('foo'.upper(), 'FOO')

    def test_isUpper(self):
        self.assertFalse('foo'.isupper())
        self.assertTrue('FOO'.isupper())

    # tearDown方法是用于测试类执行结束后的方法
    def tearDown(self):
        print("test end")
    # __main__测试脚本的入口，相当于java中的main方法
    if __name__ == "__main__":
        unittest.main()
