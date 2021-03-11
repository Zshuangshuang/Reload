from selenium import webdriver
import time
browser = webdriver.Firefox()
browser.get("http://www.baidu.com/")
browser.maximize_window()
time.sleep(2)
# css定位
browser.find_element_by_css_selector("#kw").send_keys("Java")
browser.find_element_by_css_selector("#su").click()
time.sleep(2)
browser.quit()