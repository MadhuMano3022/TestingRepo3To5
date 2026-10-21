package com.sla.testing.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/drag.xhtml");
		driver.manage().window().maximize();
		
		WebElement dragAndDrop = driver.findElement(By.id("form:conpnl"));
		Actions actions = new Actions(driver);
		actions.dragAndDropBy(dragAndDrop, 200, 0).perform();
		
		WebElement drag = driver.findElement(By.id("form:drag"));
		WebElement drop = driver.findElement(By.id("form:drop"));

//		actions.dragAndDrop(drag, drop).build().perform();
		
		actions.clickAndHold(drag).moveToElement(drop).build().perform();
		
		
		WebElement draggable = driver.findElement(By.id("form:j_idt94:j_idt97"));
		WebElement dropable = driver.findElement(By.id("form:j_idt94:j_idt95"));
		
		actions.dragAndDrop(draggable, dropable).build().perform();
		
		WebElement start = driver.findElement(By.id("form:j_idt119"));
		start.click();
		
		Thread.sleep(8000);
		
		String text = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[5]/div[2]/form[1]/div[1]/div[2]/div[3]/div[1]/div[2]")).getText();
		System.out.println(text);
		
		WebElement startElement = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[5]/div[2]/form[1]/div[1]/div[2]/div[4]/table[1]/tbody[1]/tr[3]/td[1]/div[1]/span[1]"));
		WebElement EndElement = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[5]/div[2]/form[1]/div[1]/div[2]/div[4]/table[1]/tbody[1]/tr[3]/td[1]/div[1]/span[2]"));
		Point location = EndElement.getLocation();
		

		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);",startElement,"style","left: 10%;");		
		js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);",EndElement,"style","left: 100%;");

		Thread.sleep(1000);
		WebElement image = driver.findElement(By.id("form:logo"));
		js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);",image,"style","width: 150px; height: 30.125px; border: 5px solid; background: rgb(0, 0, 0); margin: 0px; resize: none; position: static; zoom: 1; display: block;");

		
		
		Thread.sleep(15000);//15000ms = 15s
		driver.quit();
	}

}
