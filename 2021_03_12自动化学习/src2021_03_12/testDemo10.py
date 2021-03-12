from selenium import webdriver
import time
# 引入Keys包
from selenium.webdriver.common.keys import Keys
browser = webdriver.Chrome()
browser.get("https://mail.qq.com/")
browser.maximize_window()
time.sleep(2)
# 定位输入框
browser.switch_to.frame("login_frame")
# 输入QQ号
browser.find_element_by_id("u").send_keys("1434278632")
# 将光标移动到密码框
browser.find_element_by_id("u").send_keys(Keys.TAB)
time.sleep(5)
# 输入密码
browser.find_element_by_id("p").send_keys("19990306Zsss")
# 用enter键登录
browser.find_element_by_id("p").send_keys(Keys.ENTER)
time.sleep(3)
browser.quit()


