
from selenium import webdriver
import os
import time
from selenium.webdriver.common.action_chains import ActionChains
browser = webdriver.Chrome()
file_path = 'file:///'+os.path.abspath("E:/JavaWebCode/alert.html")
browser.get(file_path)
browser.maximize_window()
time.sleep(3)

# 定位alert
alert = browser.find_element_by_id("tooltip").click()
browser.implicitly_wait(10)
alert = browser.switch_to.alert
# 输出弹出框的内容
text = alert.text
print(text)
time.sleep(4)
alert.accept()
time.sleep(3)
browser.quit()