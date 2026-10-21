package com.sla.testing.selenium;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/window.xhtml");
		
		String oldwindow = driver.getWindowHandle();
		System.out.println(oldwindow);
		
		WebElement button = driver.findElement(By.id("j_idt88:new"));
		button.click();
		
		Set<String> multiplewindows = driver.getWindowHandles();
		System.out.println(multiplewindows.size());//2
		
		for(String newwindow:multiplewindows) {
			if(!oldwindow.equals(newwindow)) {
				System.out.println("the new window has been opened" + newwindow);
				driver.switchTo().window(newwindow);
				driver.close();
			}else {
				System.out.println("same window remain");
			}
		}
		
		driver.switchTo().window(oldwindow);
		
		multiplewindows = driver.getWindowHandles();
		System.out.println(multiplewindows.size());//1
		
		WebElement button2 = driver.findElement(By.id("j_idt88:j_idt91"));
		button2.click();
		Set<String>windows = driver.getWindowHandles();
		System.out.println(windows.size());
		for(String window : windows) {
			if(!oldwindow.equals(window)) {
				driver.switchTo().window(window);
				driver.close();
			}
		}
		driver.switchTo().window(oldwindow);
		
		WebElement button3 = driver.findElement(By.id("j_idt88:j_idt93"));
		button3.click();
		Set<String> manywindow = driver.getWindowHandles();
		System.out.println(manywindow);
		for(String window : manywindow ) {
			if(!oldwindow.equals(window)) {
				driver.switchTo().window(window);
				driver.close();
			}
		}
		
		driver.switchTo().window(oldwindow);
		WebElement button4 = driver.findElement(By.id("j_idt88:j_idt95"));
		button4.click();
}
}