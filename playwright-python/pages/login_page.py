from playwright.sync_api import Page

class LoginPage:
    def __init__(self, page: Page, base_url: str):
        self.page = page
        self.base_url = base_url
        self.username_input = "input#username"
        self.password_input = "input#password"
        self.login_button = "button[type='submit']"
        self.success_message = "div#flash.success"
        self.error_message = "div#flash.error"

    def navigate(self):
        self.page.goto(f"{self.base_url}/login")
    
    def login(self, username: str, password: str):
        self.page.fill(self.username_input, username)
        self.page.fill(self.password_input, password)
        self.page.click(self.login_button)
    
    def get_success_message(self):
        return self.page.text_content(self.success_message)
    
    def get_error_message(self):
        return self.page.text_content(self.error_message)