package com.sla.testing.selenium;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Sortable {

	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.tutorialspoint.com/selenium/practice/sortable.php");
		

		Thread.sleep(2000);
		List<WebElement> rows = driver.findElements(By.xpath("/html[1]/body[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr"));
		System.out.println(rows.size());
		
		WebElement element1 = rows.get(0).findElements(By.tagName("td")).get(0).findElement(By.tagName("span"));
		WebElement element2 = rows.get(1).findElements(By.tagName("td")).get(0).findElement(By.tagName("span"));
		WebElement element3 = rows.get(2).findElements(By.tagName("td")).get(0).findElement(By.tagName("span"));
		Actions action = new Actions(driver);
				action.clickAndHold(element1).moveToElement(element3).release().build().perform();
				Thread.sleep(2000);
				action.clickAndHold(element1).moveToElement(element2).release().build().perform();
				Thread.sleep(2000);
				action.clickAndHold(element1).moveToElement(element3).release().build().perform();
				
		Thread.sleep(15000);
		driver.quit();
	}

}
