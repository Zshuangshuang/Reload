from selenium import webdriver
import time
browser = webdriver.Chrome()
browser.get("http://www.baidu.com/")
browser.maximize_window()
time.sleep(3)
browser.find_element_by_id("kw").send_keys(u"邓伦")
browser.find_element_by_id("su").click()
browser.implicitly_wait(6)
browser.find_element_by_partial_link_text(u"邓伦").click()
browser.implicitly_wait(10)
# 获取标题
title = browser.title
# 打印标题
print("title:"+title)
# 获取url
url = browser.current_url
# 打印url
print("url="+url)
time.sleep(2)
browser.quit()
