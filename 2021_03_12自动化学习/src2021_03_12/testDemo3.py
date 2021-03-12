
from selenium import webdriver
import time
browser = webdriver.Chrome()
browser.get("http://www.baidu.com/")
browser.maximize_window()
time.sleep(2)
# 获取文本信息
text = browser.find_element_by_xpath("//*[@id='bottom_layer']/div/p[8]/a").text
# python中的输出语句
print(text)
browser.quit()