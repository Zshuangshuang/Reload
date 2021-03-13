
from selenium import webdriver
import os
import time
from selenium.webdriver.common.action_chains import ActionChains

browser = webdriver.Chrome()
file_path = 'file:///'+os.path.abspath("E:/JavaWebCode/modal.html")
browser.get(file_path)
browser.maximize_window()
time.sleep(3)

# 定位click并点击
div1 = browser.find_element_by_id("show_modal")
ActionChains(browser).click(div1).perform()
time.sleep(3)
# 定位click me 并点击
browser.find_element_by_class_name("modal-body")
div2 = browser.find_element_by_link_text("click me")
ActionChains(browser).click(div2).perform()
time.sleep(3)

# 定位close并点击
browser.find_element_by_class_name("modal-footer")
buttons = browser.find_elements_by_tag_name("button")
ActionChains(browser).click(buttons[0]).perform()
time.sleep(3)
browser.quit()
