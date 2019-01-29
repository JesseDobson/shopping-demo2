package org.naic.mfl.se.challenge.objectrepo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage {
	public static void emailCreate(WebDriver driver, String email) {
		driver.findElement(By.id("email_create")).sendKeys(email);
		
	}
	
	public static void createSubmit(WebDriver driver) {
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
		driver.findElement(By.id("SubmitCreate")).click();
		
	}
}
