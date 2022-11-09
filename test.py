
from selenium import webdriver

driver = "/usr/bin/chromedriver"
binary = "/usr/bin/google-chrome"

option = webdriver.ChromeOptions()
option.binary_location = binary

driver = webdriver.Chrome(executable_path = driver, chrome_options = option)
driver.get("https://www.youtube.com/watch?v=67h3IT2lm40")
driver.quit()
