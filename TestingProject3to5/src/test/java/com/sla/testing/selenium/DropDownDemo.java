package com.sla.testing.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/select.xhtml");
		driver.manage().window().maximize();
		
		WebElement selectTool = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
		selectTool.click();
		Select select = new Select(selectTool);
		select.selectByVisibleText("Playwright");
		
		driver.findElement(By.id("j_idt87:country_label")).click();
		
		Thread.sleep(1000);
		
		List<WebElement> countries = driver.findElements(By.xpath("/html[1]/body[1]/div[5]/div[1]/ul[1]/li"));
		for(WebElement country : countries) {
			if(country.getText().equals("India")) {
				country.click();
				break;
			}
		}
		
		
		Thread.sleep(1000);
		
		driver.findElement(By.id("j_idt87:city_label")).click();
		
		List<WebElement> cities = driver.findElements(By.xpath("/html[1]/body[1]/div[8]/div[1]/ul[1]/li"));
		for(WebElement city : cities) {
			if(city.getText().equals("Chennai")) {
				city.click();
				break;
			}
		}
		
		String langs[] = {"AWS","ReactJs","Playwright"};
		
		
		
		
		WebElement autoCompleteElement = driver.findElement(By.id("j_idt87:auto-complete_input"));

		
		for(int i=0;i<langs.length;i++) {
			System.out.println(langs[i]);
			autoCompleteElement.sendKeys(langs[i]);
			Thread.sleep(1000);
			List<WebElement> courses = driver.findElements(By.xpath("/html[1]/body[1]/span[1]/ul[1]/li"));		
			for(WebElement course : courses) {
				if(course.getText().equals(langs[i])) {
					course.click();
					break;
				}
				}
		}

		
		WebElement languages = driver.findElement(By.id("j_idt87:lang_label"));
		languages.click();
	
		Thread.sleep(1000);
		List<WebElement> langList = driver.findElements(By.xpath("/html[1]/body[1]/div[6]/div[1]/ul[1]/li"));
//		System.out.println(langList.size());
//		System.out.println(langList.get(2));
//		langList.get(2).click();
		for(WebElement lang : langList) {
			if(lang.getText().equals("Tamil")) {
				lang.click();
				break;
			}
		}
		
		Thread.sleep(1000);
	
		WebElement count = driver.findElement(By.id("j_idt87:value_label"));
		count.click();
		
		Thread.sleep(1000);
		
		List<WebElement> countElements = driver.findElements(By.xpath("/html[1]/body[1]/div[8]/div[1]/ul[1]/li"));
		for(WebElement ele : countElements) {
			System.out.println(ele.getText());
			if(ele.getText().equals("மூன்று")) {
				ele.click();
				break;
			}
		}
		
		Thread.sleep(5000);
		driver.quit();
	}

}
