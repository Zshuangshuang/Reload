
from selenium import webdriver
import os
import time
# 引入鼠标驱动包
from selenium.webdriver.common.action_chains import ActionChains
browser = webdriver.Chrome()
# 定位文件的绝对路径
file_path = 'file:///'+os.path.abspath("E:/JavaWebCode/level_locate.html")
browser.get(file_path)
browser.maximize_window()
time.sleep(3)
# 定义Link1
browser.find_element_by_link_text("Link1").click()
# 定位Another action的位置
pos = browser.find_element_by_link_text("Another action")
# 用鼠标移动到pos位置
ActionChains(browser).move_to_element(pos).perform()

time.sleep(2)
browser.quit()