package com.sla.testing.selenium;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ButtonDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/button.xhtml");
		driver.manage().window().maximize();

		
		WebElement firstButton = driver.findElement(By.id("j_idt88:j_idt90"));
		firstButton.click();
		
		@Nullable
		String title = driver.getTitle();
		System.out.println(title);
		
		driver.navigate().back();
		
		WebElement thirdButton = driver.findElement(By.id("j_idt88:j_idt94"));
		Point location = thirdButton.getLocation();
		System.out.println(location.getX());
		System.out.println(location.getY());
		
		WebElement heightWidth = driver.findElement(By.id("j_idt88:j_idt98"));
		String height = heightWidth.getCssValue("height");
		String width = heightWidth.getCssValue("width");
		System.out.println(height);
		System.out.println(width);
		
		WebElement backGroundColor = driver.findElement(By.id("j_idt88:j_idt100"));

		@Nullable
		String color = backGroundColor.getCssValue("background-color");
		System.out.println("Before Hover: " + color);
		
		
		
		Actions actions = new Actions(driver);
		actions.moveToElement(backGroundColor).build().perform();
		
		Thread.sleep(2000);
		
		WebElement afterHover = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[5]/div[2]/form[1]/div[1]/div[2]/div[2]/button[1]/span[1]"));


		color = afterHover.getCssValue("background-color");
		System.out.println("After Hover: " + color);
		
		WebElement imageButon = driver.findElement(By.id("j_idt88:j_idt102:imageBtn"));
		imageButon.click();
		
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[5]/div[2]/form[1]/div[1]/div[2]/div[3]/h5[1]")).click();
		
		List<WebElement> buttons = driver.findElements(By.xpath("/html[1]/body[1]/div[1]/div[5]/div[2]/form[1]/div[1]/div[2]/div[4]/button"));
		System.out.println("There are " + buttons.size() + " buttons");
		Thread.sleep(5000);//15000ms = 15s
		driver.quit();
	}

}
