package com.guru99.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageGuru99 {
		
	WebDriver driver;
	By username = By.name("uid");
	By password = By.name("password");
	By title = By.className("barrone");
	By login = By.name("btnLogin");
		public LoginPageGuru99(WebDriver driver) {
			this.driver = driver;
		}
		public void setUserName(String strUserName) {
			driver.findElement(username).clear();
			driver.findElement(username).sendKeys(strUserName);
		}
		public void setPassword(String strPassword) {
			driver.findElement(password).clear();
			driver.findElement(password).sendKeys(strPassword);
		}
		public void clickLogin() {
			driver.findElement(login).click();
		}
		public String getLoginTitle() {
			return driver.findElement(title).getText();
			
		}
}
