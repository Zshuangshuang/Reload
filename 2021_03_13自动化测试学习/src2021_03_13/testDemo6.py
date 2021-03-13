import unittest
from selenium import webdriver
from selenium.webdriver.common.by import By

from selenium.webdriver.common.keys import Keys


class TestRec(unittest.TestCase):
    def setup_method(self):
        self.driver = webdriver.Firefox()
        self.vars = {}

    def teardown_method(self):
        self.driver.quit()

    def test_rec(self):
        self.driver.get("https://www.sogou.com/")
        self.driver.set_window_size(550, 680)
        self.driver.find_element(By.ID, "query").send_keys("Hello")
        self.driver.find_element(By.ID, "query").send_keys(Keys.ENTER)
