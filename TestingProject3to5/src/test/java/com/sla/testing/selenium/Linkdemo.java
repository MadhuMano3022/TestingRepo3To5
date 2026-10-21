package com.sla.testing.selenium;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Linkdemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/link.xhtml");
		driver.manage().window().maximize();

		
		driver.findElement(By.xpath("//div[@class='grid ui-fluid']//div[1]//div[1]//div[1]//div[1]//a[1]")).click();
		
		@Nullable
		String title = driver.getTitle();
		System.out.println(title);
		
		driver.navigate().back();
		
		@Nullable
		String href = driver.findElement(By.xpath("//a[normalize-space()='Find the URL without clicking me.']")).getAttribute("href");
		System.out.println(href);
		
		
		
		driver.findElement(By.xpath("//a[normalize-space()='Broken?']")).click();
		
		@Nullable
		String broken = driver.getTitle();
		if(broken.contains("404")) {
			System.out.println("It is a broken link");
		}else {
			System.out.println("It is not a broken link");
		}
		
		driver.navigate().back();
		
		List<WebElement> countAnchor = driver.findElements(By.tagName("a"));
		
		System.out.println(countAnchor.size());
		
		
		List<WebElement> elements = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[5]/div[2]/form[1]/div[1]/div[2]/div[3]")).findElements(By.tagName("a"));
		System.out.println(elements.size());
		Thread.sleep(5000);
		driver.quit();

	}

}
