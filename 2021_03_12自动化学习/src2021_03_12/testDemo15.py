from selenium import webdriver
import time
import os
browser = webdriver.Chrome()
file_path = 'file:///'+os.path.abspath("E:/JavaWebCode/checkbox.html")
browser.get(file_path)
time.sleep(3)

inputs = browser.find_elements_by_tag_name('input')
for i in range(0,5):
    if inputs[i].get_attribute('type') == "checkbox":
        inputs[i].click()

time.sleep(3)
browser.quit()