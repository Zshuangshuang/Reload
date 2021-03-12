from selenium import webdriver
import time
browser = webdriver.Chrome()
first_url = "http://www.baidu.com/"
browser.get(first_url)
time.sleep(2)
browser.find_element_by_id("kw").send_keys("哈哈")
browser.find_element_by_id("su").click()
time.sleep(2)
# 返回上一次浏览的页面
browser.back()
time.sleep(3)
# 前进到下一个页面
browser.forward()
time.sleep(2)
browser.quit()
