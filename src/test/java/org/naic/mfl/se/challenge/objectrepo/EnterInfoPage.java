package org.naic.mfl.se.challenge.objectrepo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EnterInfoPage {
	public static void selectGender(WebDriver driver, WebDriverWait wait) {
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_gender2"))).click();
		
	}
	
	public static void enterFirstName(WebDriver driver, String firstName) {
		driver.findElement(By.id("customer_firstname")).sendKeys(firstName);
		
	}
	
	public static void enterLastName(WebDriver driver, String lastName) {
		driver.findElement(By.id("customer_lastname")).sendKeys(lastName);
		
	}
	
	public static void createPassword(WebDriver driver, String password) {
		driver.findElement(By.id("passwd")).sendKeys("Qwerty");
		
	}
	
	public static void enterDate(WebDriver driver, String days, String months, String years) {
		 Select select = new Select(driver.findElement(By.id("days")));
	        select.selectByValue(days);
	        select = new Select(driver.findElement(By.id("months")));
	        select.selectByValue(months);
	        select = new Select(driver.findElement(By.id("years")));
	        select.selectByValue(years);
		
	}
	
	public static void enterCompany(WebDriver driver, String string) {
		driver.findElement(By.id("company")).sendKeys("Company");
		
	}
	
	public static void enterAddress(WebDriver driver, String address1, String address2, String city, String state,
			String postcode) {
		    Select select = new Select(driver.findElement(By.id("days")));
		    driver.findElement(By.id("address1")).sendKeys(address1);
	        driver.findElement(By.id("address2")).sendKeys(address2);
	        driver.findElement(By.id("city")).sendKeys(city);
	        select = new Select(driver.findElement(By.id("id_state")));
	        select.selectByVisibleText(state);
	        driver.findElement(By.id("postcode")).sendKeys(postcode);
		
	}
	
	public static void enterOther(WebDriver driver, String other) {
		 driver.findElement(By.id("other")).sendKeys("Qwerty");
		
	}
	
	public static void enterPhones(WebDriver driver, String phone, String mobilePhone) {
		 driver.findElement(By.id("phone")).sendKeys(phone);
		 driver.findElement(By.id("phone_mobile")).sendKeys(mobilePhone);
		
	}
	
	public static void enterAlias(WebDriver driver, String alias) {
		driver.findElement(By.id("alias")).sendKeys(alias);
		
	}
	

	public static void clickSubmitAccount(WebDriver driver) {
		driver.findElement(By.id("submitAccount")).click();
		
	}
	
	

}
