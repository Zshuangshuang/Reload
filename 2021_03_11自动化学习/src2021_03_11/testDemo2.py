from selenium import  webdriver
import time
browser = webdriver.Firefox()
browser.get("http://www.baidu.com/")
# 放大浏览器窗口
browser.maximize_window()
time.sleep(2)
# 根据name定位百度搜索框并输入你好李焕英
browser.find_element_by_name("wd").send_keys("你好李焕英")
# 由于百度搜索框旁边的百度一下没有name属性，因此就继续使用id来定位并点击
browser.find_element_by_id("su").click()
time.sleep(2)
browser.quit()