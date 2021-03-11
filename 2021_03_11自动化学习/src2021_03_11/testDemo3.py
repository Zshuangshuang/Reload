from selenium import webdriver
import time
browser = webdriver.Firefox()
browser.get("http://www.baidu.com/")
browser.maximize_window()
time.sleep(2)
# class定位
browser.find_element_by_class_name("s_ipt").send_keys("你好李焕英")
browser.find_element_by_id("su").click()
time.sleep(2)
browser.quit()