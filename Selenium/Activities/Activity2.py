from selenium import webdriver
from selenium.webdriver.common.by import By
import time

with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/webelements/login-form")
    print(f"Title of the page is : {driver.title}")
    username=driver.find_element(By.ID,"username")
    username.send_keys("admin")
    password=driver.find_element(By.ID,"password")
    password.send_keys("password")
    driver.find_element(By.XPATH,"/html/body/div/main/div/div/div/div/div[2]/form/button").click()
    time.sleep(2)
    driver.quit()
