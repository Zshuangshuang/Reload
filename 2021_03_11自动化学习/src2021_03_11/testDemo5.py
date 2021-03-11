from selenium import webdriver
import time
browser = webdriver.Firefox()
browser.get("http://www.baidu.com/")
browser.maximize_window()
time.sleep(2)
# 通过部分链接来定位
browser.find_element_by_partial_link_text(u"视").click()
time.sleep(2)
browser.quit()