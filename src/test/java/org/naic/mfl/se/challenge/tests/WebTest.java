package org.naic.mfl.se.challenge.tests;

//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Date;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

import org.naic.mfl.se.challenge.objectrepo.*;

public class WebTest {
	WebDriver driver;
	WebDriverWait wait;

	String existingUserEmail = "jessearcherdobson@gmail.com";
	String existingUserPassword = "whiskey9";

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 10, 50);
		driver.get("http://automationpractice.com/index.php");
	}

	@Test
	public void signUpTest() {

		StartingPage.clickLogin(driver, wait);
		StartingPage.clickLogin(driver, wait);

		String timestamp = String.valueOf(new Date().getTime());
		String email = "hf_challenge_" + timestamp + "@hf" + timestamp.substring(7) + ".com";
		String name = "Firstname";
		String surname = "Lastname";

		SignupPage.emailCreate(driver, email);

		SignupPage.createSubmit(driver);

		EnterInfoPage.selectGender(driver, wait);

		EnterInfoPage.enterFirstName(driver, name);

		EnterInfoPage.enterLastName(driver, surname);

		EnterInfoPage.createPassword(driver, "Qwerty");

		EnterInfoPage.enterDate(driver, "1", "1", "2000");

		EnterInfoPage.enterCompany(driver, "Company");

		EnterInfoPage.enterAddress(driver, "Qwerty, 123", "zxcvb", "Qwerty", "Colorado", "12345");

		EnterInfoPage.enterOther(driver, "Qwerty");
		EnterInfoPage.enterPhones(driver, "12345123123", "12345123123");
		EnterInfoPage.enterAlias(driver, "hf");
		EnterInfoPage.clickSubmitAccount(driver);

		WebElement heading = LandingPage.returnHeading(driver, wait);

		Assert.assertEquals(heading.getText(), "MY ACCOUNT");

		Assert.assertEquals(driver.findElement(By.className("account")).getText(), name + " " + surname);

		Assert.assertTrue(
				driver.findElement(By.className("info-account")).getText().contains("Welcome to your account."));

		Assert.assertTrue(driver.findElement(By.className("logout")).isDisplayed());

		Assert.assertTrue(driver.getCurrentUrl().contains("controller=my-account"));

		String headingText = LandingPage.getHeadingText(driver);

		Assert.assertEquals(headingText, "MY ACCOUNT");
		
		Header.clickLogout(driver, wait);
	}

	@Test
	public void logInTest() {
		String fullName = "jesse dobson";

		StartingPage.clickLogin(driver, wait);
		StartingPage.clickLogin(driver, wait);

		LoginPage.enterEmail(driver, existingUserEmail);

		LoginPage.enterPassword(driver, existingUserPassword);

		LoginPage.clickLogin(driver);
		System.out.println("getting past clickLogin()");

		// below will wait for 'My account' to present where 'Authentication'
		// was before
		LandingPage.waitForVisibilityofHeaderThenClick(driver, wait);

		Assert.assertEquals("MY ACCOUNT", LandingPage.getHeadingText(driver));

		Assert.assertEquals(fullName, LandingPage.getFullName(driver));

		Assert.assertTrue(LandingPage.getAccountWelcome(driver));

		Assert.assertTrue(LandingPage.verifyLogoutButton(driver));

		Assert.assertTrue(LandingPage.verifyUrlContainsController(driver));
		
		Header.clickLogout(driver, wait);
	}

	@Test
	public void checkoutTest() {

		StartingPage.clickLogin(driver, wait);

		StartingPage.clickLogin(driver, wait);

		LoginPage.enterEmail(driver, existingUserEmail);

		LoginPage.enterPassword(driver, existingUserPassword);

		LoginPage.clickLogin(driver);

		LandingPage.clickLink(driver, wait, "Women");

		WomenPanel.openFirstItemDetail(driver);

		ItemDetailPanel.addToCart(driver, wait);

		CartUpdatePopup.proceedToCheckout(driver, wait);

		ShoppingCartSummary.proceedToCheckout(driver, wait);

		AddressConfirmationPage.proceed(driver, wait);

		ShippingOptionsPage.agree(driver, wait);

		ShippingOptionsPage.proceed(driver, wait);

		PaymentDetailsPage.selectPaymentType(driver, wait, "bankwire");

		OrderConfirmationPage.confirm(driver, wait);

		CompletedOrderPage.waitOrderConfirmationHeader(driver, wait);

		Assert.assertEquals("ORDER CONFIRMATION", CompletedOrderPage.getHeading(driver, wait));

		Assert.assertTrue(CompletedOrderPage.verifyShipping4thStep(driver, wait));

		Assert.assertTrue(CompletedOrderPage.verifyPayment5thStep(driver, wait));

		Assert.assertTrue(CompletedOrderPage.verifyOrderCompleteMessage(driver, "Your order on My Store is complete."));

		Assert.assertTrue(CompletedOrderPage.verifyOrderCompleteController(driver));
		
		Header.clickLogout(driver, wait);
	}
	
	@AfterTest
	public void tearDown(){
		driver.close();
		driver.quit();
	}

}
