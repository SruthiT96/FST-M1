from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/")
    print(f"Title of the page is : {driver.title}")
    about_us_button=driver.find_element(By.LINK_TEXT, "About Us")
    about_us_button.click()
    print(f"Title of the next page is : {driver.title}")

