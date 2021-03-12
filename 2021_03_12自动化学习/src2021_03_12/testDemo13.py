from selenium import webdriver
import os
import time
browser = webdriver.Chrome()
# 找到本地文件的绝对路径
file_path = 'file:///'+os.path.abspath("E:/JavaWebCode/checkbox.html")
browser.get(file_path)
# 放大浏览器
browser.maximize_window()
# 让页面休眠
time.sleep(2)
# 定位所有同一组元素
inputs = browser.find_elements_by_tag_name('input')
for input in inputs:
    if input.get_attribute('type') == "checkbox":
        input.click()

time.sleep(2)
browser.quit()