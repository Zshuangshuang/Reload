from selenium import webdriver
import time
browser = webdriver.Chrome()
browser.get("http:///www.baidu.com/")
browser.minimize_window()
time.sleep(2)
browser.maximize_window()
# 设置浏览器页面的大小
# browser.set_window_size(900,1000)
time.sleep(2)
browser.find_element_by_id("kw").send_keys(u"哈哈")
browser.find_element_by_id("su").click()
time.sleep(3)
# 将滚动条滑到页面的最底端
js1 = "var q=document.documentElement.scrollTop=10000"
browser.execute_script(js1)
time.sleep(4)
# 将滚动条滑到页面的最顶端
js2 = "var q=document.documentElement.scrollTop=0"
browser.execute_script(js2)
