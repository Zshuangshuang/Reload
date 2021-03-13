import unittest


class TestDemo(unittest.TestCase):

    def test_isUpper(self):
        self.assertTrue("FOO".isupper())
        self.assertFalse("foo".isupper())

    def test_upper(self):
        self.assertEqual("foo".upper(), "FOO")


if __name__=="__main__":
    # 构建测试集合
    suit = unittest.TestSuite
    suit.addTest(TestDemo('test_isUpper'))
    # 执行测试
    runner = unittest.TextTestRunner()
    runner.run(suit)