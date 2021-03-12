
from selenium import webdriver
import os
import time
browser = webdriver.Chrome()
file_path = 'file:///'+os.path.abspath("E:/JavaWebCode/frame.html")
browser.get(file_path)
browser.maximize_window()
time.sleep(3)

# 找到大框框
browser.switch_to.frame("f1")
# 找到小框框
browser.switch_to.frame("f2")
browser.find_element_by_id("kw").send_keys("嘻哈")
browser.find_element_by_id("su").click()
time.sleep(3)
# 返回默认页面
browser.switch_to.default_content()
browser.switch_to.frame("f1")
browser.find_element_by_link_text("click").click()
time.sleep(3)
browser.quit()