package com.sla.testing.selenium;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBox {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/checkbox.xhtml");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[5]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[5]/div[2]/form[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]")).click();
		
		String langs[] = {"Java", "Javascript","C-Sharp"};
		
		List<WebElement> tableColumns = driver.findElements(By.xpath("/html[1]/body[1]/div[1]/div[5]/div[2]/form[1]/div[1]/div[1]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td"));
 		for(String lang : langs) {
			for(int i=0;i<tableColumns.size();i++) {
				WebElement check = tableColumns.get(i).findElement(By.tagName("div"));
				WebElement label = tableColumns.get(i).findElement(By.tagName("label"));
				String language = label.getText();
				
				if(language.equals(lang)) {
					check.click();
					break;
			}
				}
 		}
 		
 		for(int i=1;i<=3;i++) {
 			driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[5]/div[2]/form[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[2]")).click();
 	 		
 	 		Thread.sleep(1000);
 	 		
 	 		String state = driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[1]/div[1]/div[2]/p[1]")).getText();
 			System.out.println(state);
 			Thread.sleep(1000);
 		}
 		
 		
 		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[5]/div[2]/form[1]/div[1]/div[2]/div[1]/div[1]/div[2]")).click();
 		
 		Thread.sleep(1000);
 		String state1 = driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[1]/div[2]/span[1]")).getText();
 		System.out.println(state1);
 		
 		@Nullable
		String disabled = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[5]/div[2]/form[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]")).getAttribute("class");
 		if(disabled.contains("disabled")) {
 			System.out.println("It is a diabled Check box");
 		}
 		
 		String countries[] = {"London","Paris", "Rome","Berlin"};
 		
 		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[5]/div[2]/form[1]/div[1]/div[2]/div[3]/div[1]/ul[1]")).click();
 		
 		List<WebElement> lists = driver.findElements(By.xpath("/html[1]/body[1]/div[7]/div[2]/ul[1]/li"));
 		
 		for(String country : countries) {
	 		for(WebElement list:lists) {
	 			WebElement divElement = list.findElement(By.tagName("div"));
	 			WebElement label = list.findElement(By.tagName("label"));
	 			String countryText = label.getText();
	 			if(country.equals(countryText)) {
	 				divElement.click();
	 				break;
	 			}
	 		}
 		}
		Thread.sleep(5000);//15000ms = 15s
		driver.quit();
	}

}
