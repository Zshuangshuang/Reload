
from selenium import webdriver
import os
import time

browser = webdriver.Chrome()
file_path = 'file:///'+os.path.abspath("E:/JavaWebCode/drop_down.html")
browser.get(file_path)
browser.maximize_window()
time.sleep(2)

lists = browser.find_elements_by_tag_name('option')
time.sleep(3)
lists[3].click()
time.sleep(3)
browser.quit()