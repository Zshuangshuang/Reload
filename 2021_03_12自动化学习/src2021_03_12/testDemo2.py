from selenium import webdriver
import time
browser = webdriver.Chrome()
browser.get("http://www.baidu.com/")
browser.maximize_window()
time.sleep(2)
browser.find_element_by_id("kw").send_keys("李白")
browser.find_element_by_id("su").submit()
time.sleep(3)
browser.quit()