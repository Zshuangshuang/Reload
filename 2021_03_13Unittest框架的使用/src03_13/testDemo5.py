import unittest


class TestStringMethods(unittest.TestCase):

    @unittest.skip("not wht")
    def test_upper(self):
        self.assertEqual('foo'.upper(), 'FOO')
