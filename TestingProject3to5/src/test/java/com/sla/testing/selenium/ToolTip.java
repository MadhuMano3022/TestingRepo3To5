package com.sla.testing.selenium;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToolTip {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.globalsqa.com/demoSite/practice/tooltip/forms.html");
		driver.manage().window().maximize();
		
		@Nullable
		String tooltipTitle = driver.findElement(By.id("firstname")).getAttribute("title");
		String lastName = driver.findElement(By.id("lastname")).getAttribute("title");
		String address = driver.findElement(By.id("address")).getAttribute("title");
		
		System.out.println(tooltipTitle + "\n" + lastName + "\n" + address );
		
		Thread.sleep(15000);
		driver.quit();

	}

}
