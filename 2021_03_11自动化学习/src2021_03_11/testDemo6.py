from selenium import webdriver
import time
browser = webdriver.Firefox()
browser.get("http://www.baidu.com/")
browser.maximize_window()
time.sleep(2)
# 定位xpath
browser.find_element_by_xpath("//*[@id='kw']").send_keys("邓庄庄")
browser.find_element_by_xpath("//*[@id='su']").click()
time.sleep(2)
browser.quit()