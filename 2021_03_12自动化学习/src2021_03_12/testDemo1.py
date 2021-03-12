from selenium import webdriver
import time
browser = webdriver.Chrome()
browser.get("http://www.baidu.com/")
# 浏览器最大化
browser.maximize_window()
time.sleep(2)
# send_keys模拟用户在输入框输入要搜索的文字
browser.find_element_by_id("kw").send_keys("西安工业大学")
# click模拟用户用鼠标点击搜索一下
browser.find_element_by_id("su").click()
time.sleep(3)
# 当向在输入框中输入其他内容搜索时，需要先用clear清除内容，再重新输入搜索内容
browser.find_element_by_id("kw").clear()
browser.find_element_by_id("kw").send_keys("Ipad")
browser.find_element_by_id("su").click()
time.sleep(3)
browser.quit()
