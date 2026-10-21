package com.sla.testing.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.leafground.com/frame.xhtml");
		
		driver.switchTo().frame(0);
		
		driver.findElement(By.id("Click")).click();
		String clickMessage = driver.findElement(By.id("Click")).getText();
		System.out.println(clickMessage);
		
		driver.switchTo().defaultContent();
		
		List<WebElement> elements = driver.findElements(By.tagName("iframe"));
		System.out.println(elements.size());
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(2);
		driver.switchTo().frame("frame2");
		
		WebElement elementButton = driver.findElement(By.id("Click"));
		
		elementButton.click();
		String text = elementButton.getText();
		System.out.println(text);
		Thread.sleep(10000);
		driver.quit();	
	}

}
