from selenium import webdriver
import os
import time
browser = webdriver.Chrome()
file_path = 'file:///'+os.path.abspath("E:/JavaWebCode/checkbox.html")
browser.get(file_path)
browser.maximize_window()
time.sleep(3)

inputs = browser.find_elements_by_tag_name('input')
for input in inputs:
    if input.get_attribute('type') == "radio":
        input.click()

time.sleep(3)
browser.quit()