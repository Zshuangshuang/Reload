from selenium import webdriver
import time
from selenium.webdriver.common.action_chains import ActionChains
browser = webdriver.Chrome()
browser.get("http://www.baidu.com/")
browser.maximize_window()
time.sleep(3)
browser.find_element_by_id("kw").send_keys("哈哈")
# 定位百度一下按钮
name = browser.find_element_by_id("su")
# 右击
# ActionChains(browser).context_click(name).perform()
# 双击
ActionChains(browser).double_click(name).perform()

time.sleep(3)
