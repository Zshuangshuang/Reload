from selenium import webdriver
import time
browser = webdriver.Chrome()
browser.get("http://www.baidu.com/")
browser.maximize_window()
# 调用sleep方法，后面括号中的参数是等待时间，这是一个固定等待,设置多久就等待多久
# time.sleep(3)
# 智能等待 等待时间为[0,6]
# browser.implicitly_wait(6)
browser.implicitly_wait(3)
browser.find_element_by_id("kw").send_keys(u"邓伦 - 百度百科")
browser.find_element_by_id("su").click()
browser.implicitly_wait(10)
browser.find_element_by_link_text(u"邓伦").click()
time.sleep(2)
browser.quit()