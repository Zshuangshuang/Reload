from selenium import webdriver
import time
browser = webdriver.Chrome()
browser.get("http://www.baidu.com/")
browser.maximize_window()
time.sleep(2)
browser.find_element_by_id("kw").send_keys("哈哈")
browser.find_element_by_id("su").click()
time.sleep(4)
browser.execute_script("window.scrollTo(1000, 400);")
time.sleep(3)
browser.quit()