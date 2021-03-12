from selenium import webdriver
import time
# 引入keys包
from selenium.webdriver.common.keys import Keys
browser = webdriver.Chrome()
browser.get("http://127.0.0.1:88/zentao/user-login.html")
browser.maximize_window()
time.sleep(2)
# 输入用户名
browser.find_element_by_name("account").send_keys("admin")
# 用tab键将光标移动到密码输入框
browser.find_element_by_name("account").send_keys(Keys.TAB)
time.sleep(8)
# 输入密码
browser.find_element_by_name("password").send_keys("261919Zss")
# 用enter键登录
browser.find_element_by_name("password").send_keys(Keys.ENTER)
time.sleep(3)
browser.quit()

