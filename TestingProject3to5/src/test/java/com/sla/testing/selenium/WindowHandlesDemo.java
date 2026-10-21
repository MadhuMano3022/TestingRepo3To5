package com.sla.testing.selenium;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlesDemo {

	public static void main(String[] args)throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/window.xhtml");
		driver.manage().window().maximize();
		
		String oldWindow = driver.getWindowHandle();//Id => String
		System.out.println(oldWindow);
		
		
		driver.findElement(By.id("j_idt88:new")).click();
		
		Set<String> multipleWindows = driver.getWindowHandles();
		
		for(String newWindow : multipleWindows) {
			if(!oldWindow.equals(newWindow)) {
				System.out.println("The New Window has been opened Successfully " + newWindow);
				driver.switchTo().window(newWindow);
				driver.close();
				break;
			}
		}
		
		driver.switchTo().window(oldWindow);
		
		WebElement mutipleWindowsClick = driver.findElement(By.id("j_idt88:j_idt91"));
		mutipleWindowsClick.click();
		
		Set<String> multipleWindowsCount = driver.getWindowHandles();
		
		System.out.println("How many windows totally: " + multipleWindowsCount.size());
		
		for(String newWindow : multipleWindowsCount) {
			if(!oldWindow.equals(newWindow)) {
				driver.switchTo().window(newWindow);
				driver.close();
			}
		}
		
		driver.switchTo().window(oldWindow);
		
		WebElement mutipleWindowsClose = driver.findElement(By.id("j_idt88:j_idt93"));
		mutipleWindowsClose.click();
		
		Set<String> multipleWindowsClose = driver.getWindowHandles();
		for(String newWindow : multipleWindowsClose) {
			if(!oldWindow.equals(newWindow)) {
				driver.switchTo().window(newWindow);
				driver.close();
			}
		}
		driver.switchTo().window(oldWindow);
		WebElement windowOpenDelay = driver.findElement(By.id("j_idt88:j_idt95"));
		windowOpenDelay.click();
		
		
		
		
		Thread.sleep(5000);//15000ms = 15s
		driver.quit();
	}

}
