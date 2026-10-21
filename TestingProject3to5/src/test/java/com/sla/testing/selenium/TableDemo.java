package com.sla.testing.selenium;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//https://practicetestautomation.com/practice-test-table/
public class TableDemo {

	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.leafground.com/table.xhtml");
		
		
		List<WebElement> rows = driver.findElements(By.xpath("/html[1]/body[1]/div[1]/div[5]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr"));
		System.out.println("Row Size" + rows.size());
		
		String[] countryNames = {"India","Canada","Brazil","Spain","Japan","Germany","Argentina","Russia","Australia"};
		for(String countryName: countryNames) {
			for(int i=0;i<rows.size();i++) {
				List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
	//			System.out.println(cols.size());
				List<WebElement> spans = cols.get(1).findElements(By.tagName("span"));
					String country = spans.get(2).getText();
					if(country.equals(countryName)) {
						String personName = cols.get(0).getText();
						System.out.println(country + " : " + personName);
					}
				
			}
		}
		
		Thread.sleep(15000);
		driver.quit();

	}

}
