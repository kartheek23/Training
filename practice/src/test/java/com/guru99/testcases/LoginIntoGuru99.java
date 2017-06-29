package com.guru99.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.guru99.common.GenericDataProvider;
import com.guru99.pages.LoginPageGuru99;

public class LoginIntoGuru99 {
		WebDriver driver;
		@BeforeTest
		public void setup() {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("http://www.demo.guru99.com/V4/");
		}
		@Test(dataProvider = "LoginIntoGuru99",dataProviderClass=GenericDataProvider.class)
		@Parameters({"username","password"})
		public void loginIntoGuru99(String username,String password) throws InterruptedException {
			LoginPageGuru99 pageLogin = new LoginPageGuru99(driver);
			pageLogin.setUserName(username);
			pageLogin.setPassword(password);
			pageLogin.clickLogin();Thread.sleep(5000);
		}
		@AfterTest
		public void close() {
			driver.quit();
		}
}
