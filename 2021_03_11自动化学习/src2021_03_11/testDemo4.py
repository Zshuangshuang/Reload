from selenium import webdriver
import time
browser = webdriver.Firefox()
browser.get("http://www.baidu.com/")
browser.maximize_window()
time.sleep(2)
# 通过link text（链接对应html里面的a标签）定位
# u是因为后面有中文，防止乱码
browser.find_element_by_link_text(u"视频").click()
time.sleep(3)
browser.quit()
