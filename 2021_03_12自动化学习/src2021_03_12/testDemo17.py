from selenium import webdriver
import os
import time
from selenium.webdriver.common.action_chains import ActionChains
browser = webdriver.Chrome()
file_path ='file:///'+os.path.abspath("E:/JavaWebCode/frame.html")
browser.get(file_path)
browser.maximize_window()
time.sleep(3)

# 定位大框框
browser.switch_to.frame("f1")
# 定位小框框
browser.switch_to.frame("f2")
browser.find_element_by_id("kw").send_keys("蔡文姬")
browser.find_element_by_id("su").click()
browser.switch_to.default_content()
browser.switch_to.frame("f1")
browser.find_element_by_link_text("click").click()

time.sleep(2)
browser.quit()