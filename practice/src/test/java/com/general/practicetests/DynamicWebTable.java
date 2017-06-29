package com.general.practicetests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DynamicWebTable {
	WebDriver driver = null;
	@BeforeTest
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://only-testing-blog.blogspot.in/2014/05/form.html");		
	}
	
	 @AfterTest
	 public void tearDown() throws Exception {
	  driver.quit();
	 }
	 
	 @Test
	 public void handle_dynamic_webtable(){
		 WebElement mytable = driver.findElement(By.xpath(".//*[@id='post-body-8228718889842861683']/div[1]/table/tbody"));
		 List<WebElement> rows_table = mytable.findElements(By.tagName("tr"));
		 int rows_count = rows_table.size();
		 for(int row =0;row<rows_count;row++){
			 List<WebElement> columns_table = rows_table.get(row).findElements(By.tagName("td"));
			 int columnCount = columns_table.size();
			 for(int column =0;column<columnCount;column++){
				 String celText= columns_table.get(column).getText();
				 System.out.println(celText);
				 
			 }
		 }
		 
		 
	 }
	

}
