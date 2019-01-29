package org.naic.mfl.se.challenge.objectrepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WomenPanel {

	public static void openFirstItemDetail(WebDriver driver) {
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img")).click();
	}

}
