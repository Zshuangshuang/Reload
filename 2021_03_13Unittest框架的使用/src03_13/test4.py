import unittest



class TestDemo1(unittest.TestCase):

    def test_isUpper(self):
        self.assertTrue("FOO".isupper())
        self.assertFalse("foo".isupper())

    def test_upper(self):
        self.assertEqual("foo".upper(), "FOO")


class TestDemo2(unittest.TestCase):
    def test_isUpper(self):
        self.assertFalse("foo".isupper())
        self.assertTrue("FOO".isupper())

    def test_upper(self):
        self.assertEqual("foo".upper(), "FOO")


if __name__ == "__main__":
    # 这种方法可以同时测试多个类
    suite1 = unittest.TestLoader().loadTestsFromTestCase(TestDemo1)
    suite2 = unittest.TestLoader.loadTestsFromTestCase(TestDemo2)
    suite = unittest.TestSuite([suite1, suite2])
    unittest.TextTestRunner(suite)
