# 导入驱动包
from selenium import webdriver
import time
# 选择操控的浏览器
browser = webdriver.Firefox()
browser.get("https://www.baidu.com/")
time.sleep(3)
# 根据id定位
browser.find_element_by_id("kw").send_keys("你好李焕英")
# 点击跳转按钮
browser.find_element_by_id("su").click()
time.sleep(2)
browser.quit()
