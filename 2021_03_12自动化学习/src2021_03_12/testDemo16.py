from selenium import webdriver
import os
import time
browser = webdriver.Chrome()
file_path = 'file:///'+os.path.abspath("E:/JavaWebCode/frame.html")
browser.get(file_path)
browser.maximize_window()
browser.implicitly_wait(20)
# 先定位找到外面的大框框f1
browser.switch_to.frame("f1")
# 定位找到里面的小框框f2
browser.switch_to.frame("f2")
browser.find_element_by_id("kw").send_keys("李白")
browser.find_element_by_id("su").click()
# 返回默认窗口
browser.switch_to.default_content()
browser.switch_to.frame("f1")
browser.find_element_by_link_text("click").click()
time.sleep(3)
browser.quit()



