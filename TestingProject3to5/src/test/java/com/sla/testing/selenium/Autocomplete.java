package com.sla.testing.selenium;

import java.awt.AWTException;
import java.time.Duration;
import java.util.List;

import org.jspecify.annotations.NonNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Autocomplete {

	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		driver.get("https://www.tutorialspoint.com/selenium/practice/auto-complete.php");
		
		driver.findElement(By.id("tags")).sendKeys("s");
		
//		Thread.sleep(2000);
		//Explicit Wait
		List<WebElement> listElements = driver.findElements(By.xpath("/html[1]/body[1]/ul[1]/li"));

		wait.until(ExpectedConditions.visibilityOfAllElements(listElements));
		
		for(WebElement li : listElements) {
			String lang = li.findElement(By.tagName("div")).getText();
			if(lang.equals("BASIC")) {
				li.click();
				break;
			}
		}
		Thread.sleep(15000);
		driver.quit();
	}

}
