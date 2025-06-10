import pytest
import json
from playwright.sync_api import sync_playwright
from pages.login_page import LoginPage
from utils.logger import setup_logger

# Load config and test data
with open("config/config.json", "r") as config_file:
    config = json.load(config_file)
with open("data/test_data.json", "r") as data_file:
    test_data = json.load(data_file)

logger = setup_logger()

@pytest.mark.login
def test_valid_login():
    with sync_playwright() as p:
        browser = p[config["browser"]].launch(headless=config["headless"])
        page = browser.new_page()
        login_page = LoginPage(page, config["base_url"])
        
        logger.info("Starting valid login test")
        login_page.navigate()
        login_page.login(test_data["valid_user"]["username"], test_data["valid_user"]["password"])
        
        success_message = login_page.get_success_message()
        assert "You logged into a secure area!" in success_message, "Login failed"
        logger.info("Valid login test passed")
        
        browser.close()

@pytest.mark.login
def test_invalid_login():
    with sync_playwright() as p:
        browser = p[config["browser"]].launch(headless=config["headless"])
        page = browser.new_page()
        login_page = LoginPage(page, config["base_url"])
        
        logger.info("Starting invalid login test")
        login_page.navigate()
        login_page.login(test_data["invalid_user"]["username"], test_data["invalid_user"]["password"])
        
        error_message = login_page.get_error_message()
        assert "Your username is invalid!" in error_message, "Invalid login error not displayed"
        logger.info("Invalid login test passed")
        
        browser.close()