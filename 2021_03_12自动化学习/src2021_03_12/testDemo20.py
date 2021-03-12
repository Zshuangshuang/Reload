
from selenium import webdriver
import os
import time
from selenium.webdriver.common.action_chains import ActionChains
browser = webdriver.Chrome()
file_path = 'file:///'+os.path.abspath("E:/JavaWebCode/level_locate.html")
browser.get(file_path)
browser.maximize_window()
time.sleep(3)

browser.find_element_by_link_text("Link1").click()
pos = browser.find_element_by_link_text("Another action")
ActionChains(browser).move_to_element(pos).perform()
time.sleep(3)
browser.quit()