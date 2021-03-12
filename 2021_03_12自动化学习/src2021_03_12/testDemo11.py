from selenium import webdriver
import time
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.action_chains import ActionChains
browser = webdriver.Chrome()
browser.get("http://www.baidu.com/")
browser.maximize_window()

browser.find_element_by_id("kw").send_keys(u"邓伦")
browser.find_element_by_id("su").click()
browser.implicitly_wait(10)
# 复制
browser.find_element_by_id("kw").send_keys(Keys.CONTROL,'a')
time.sleep(3)
# 粘贴
browser.find_element_by_id("kw").send_keys(Keys.CONTROL,'v')
time.sleep(3)
text = browser.title
browser.find_element_by_id("kw").send_keys(text)
browser.find_element_by_id("su").click()
time.sleep(4)
browser.quit()

