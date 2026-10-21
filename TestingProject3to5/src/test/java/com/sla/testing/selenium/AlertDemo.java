package com.sla.testing.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/alert.xhtml");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("j_idt88:j_idt91")).click();
		
		driver.switchTo().alert().accept();
		
		driver.switchTo().defaultContent();
		
		driver.findElement(By.id("j_idt88:j_idt93")).click();
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		
		driver.findElement(By.id("j_idt88:j_idt93")).click();
		driver.switchTo().alert().dismiss();
		driver.switchTo().defaultContent();
		
		driver.findElement(By.id("j_idt88:j_idt95")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("j_idt88:j_idt98")).click();
		driver.switchTo().defaultContent();
		
		driver.findElement(By.id("j_idt88:j_idt100")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[5]/div[2]/form[1]/div[1]/div[1]/div[4]/div[1]/div[1]/a[1]")).click();
		driver.switchTo().defaultContent();
		
		driver.findElement(By.id("j_idt88:j_idt104")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().sendKeys("Chandrika"+Keys.ENTER);
		driver.switchTo().alert().accept();
		
		driver.switchTo().defaultContent();
		
		
		
		Thread.sleep(5000);//15000ms = 15s
		driver.quit();
	}

}
