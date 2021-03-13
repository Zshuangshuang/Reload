import unittest


class TestMethod(unittest.TestCase):

    @classmethod
    # 一个类方法在单个类测试之前运行。setUpClass作为唯一的参数被调用时,必须使用classmethod()作为装饰器
    def setUpClass(self):
        print("测试开始")

    def test_upper(self):
        self.assertEqual("foo".upper(), "FOO")

    def test_isUpper(self):
        self.assertTrue("FOO".isupper())
        self.assertFalse("foo".isupper())

    @classmethod
    # 一个类方法在单个类测试之后运行。setUpClass作为唯一的参数被调用时,必须使用classmethod()作为装饰器
    def tearDownClass(self):
        print("测试结束")
