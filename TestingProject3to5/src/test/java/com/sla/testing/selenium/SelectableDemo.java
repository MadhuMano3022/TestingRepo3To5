package com.sla.testing.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SelectableDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.globalsqa.com/demoSite/practice/selectable/serialize.html");
		driver.manage().window().maximize();
		
		
		List<WebElement> lists = driver.findElements(By.xpath("/html[1]/body[1]/ol[1]/li"));
		
		Actions action = new Actions(driver);
		Thread.sleep(1000);
		action.clickAndHold(lists.get(0)).
		moveToElement(lists.get(4)).
		release(lists.get(4)).
		build().perform();
		
		driver.navigate().refresh();
		lists = driver.findElements(By.xpath("/html[1]/body[1]/ol[1]/li"));
		Thread.sleep(1000);
		action.keyDown(Keys.CONTROL).
		click(lists.get(0)).
		click(lists.get(3)).
		click(lists.get(5)).build().perform();

		
		Thread.sleep(15000);
		driver.quit();
	}

}
