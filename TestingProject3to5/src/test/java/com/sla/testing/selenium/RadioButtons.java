package com.sla.testing.selenium;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtons {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/radio.xhtml");
		driver.manage().window().maximize();
		
		
		List<WebElement> tableColumns = driver.findElements(By.xpath("/html[1]/body[1]/div[1]/div[5]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td"));
		
		for(WebElement col : tableColumns) {
			WebElement radio = col.findElement(By.tagName("div"));
			WebElement label = col.findElement(By.tagName("label"));
			if(label.getText().equals("Firefox")) {
				radio.click();
				break;
			}
		}
		
		List<WebElement> tableCols = driver.findElements(By.xpath("/html[1]/body[1]/div[1]/div[5]/div[2]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td"));

		for(int i=0;i<tableCols.size();i++) {
			WebElement radio = tableCols.get(i).findElement(By.xpath("/html[1]/body[1]/div[1]/div[5]/div[2]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[" +(i+1)+ "]/div[1]/div[2]"));
			WebElement label = tableCols.get(i).findElement(By.tagName("label"));
			@Nullable
			String activeText = radio.getAttribute("class");
			if(activeText.contains("active")) {
				System.out.println(label.getText() + " has been clicked already");
				break;
			}
		}
		
		List<WebElement> parentDivs = driver.findElements(By.xpath("/html[1]/body[1]/div[1]/div[5]/div[2]/form[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div"));

		for(int i=0;i<parentDivs.size();i++) {
			WebElement classElement = parentDivs.get(i).findElement(By.xpath("/html[1]/body[1]/div[1]/div[5]/div[2]/form[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[" + (i+1) + "]/div[1]/div[2]"));
			String label = parentDivs.get(i).findElement(By.tagName("label")).getText();
			String activeElement = classElement.getAttribute("class");
			if(activeElement.contains("active")) {
				continue;
			}else {
				System.out.println(label + " is not active");
			}
		}
		Thread.sleep(5000);//15000ms = 15s
		driver.quit();
	}

}
