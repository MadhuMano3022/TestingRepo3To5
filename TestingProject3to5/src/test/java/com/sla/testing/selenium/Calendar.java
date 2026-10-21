package com.sla.testing.selenium;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendar {

	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.leafground.com/calendar.xhtml");
	
		List<WebElement> rows = driver.findElements(By.xpath("/html[1]/body[1]/div[1]/div[5]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr"));
		
		for(int i=0;i<rows.size();i++) {
			List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
			for(int j=0;i<cols.size();j++) {
//				/html[1]/body[1]/div[1]/div[5]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[7]/div[1]/div[1]/a[1]
				WebElement a = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[5]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[" +(i+1) + "]/td[" + (j+1) + "]/div[1]/div[1]/a[1]"));
				String date = a.getText();
				if(date.equals("3")) {
					cols.get(j).click();
					Thread.sleep(3000);
					driver.findElement(By.id("j_idt87:title")).sendKeys("Jailer 2 Movie");
					
					driver.findElement(By.id("j_idt87:from_input")).click();
					
				for(int k=1;k<=7;k++) {///html[1]/body[1]/div[7]/div[2]/div[1]/a[1]/span[1]
					driver.findElement(By.xpath("/html[1]/body[1]/div[7]/div[2]/div[1]/a[1]/span[1]")).click();
				}
					
				
				for(int k=1;k<=30;k++) {
					driver.findElement(By.xpath("/html[1]/body[1]/div[7]/div[2]/div[3]/a[1]/span[1]")).click();
				}
				
					driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]")).click();
					
					driver.findElement(By.id("j_idt87:to_input")).click();
					
					for(int k=1;k<=8;k++) {///html[1]/body[1]/div[7]/div[2]/div[1]/a[1]/span[1]
						driver.findElement(By.xpath("/html[1]/body[1]/div[8]/div[2]/div[1]/a[1]/span[1]")).click();
					}
						
					
					for(int k=1;k<=30;k++) {
						driver.findElement(By.xpath("/html[1]/body[1]/div[8]/div[2]/div[3]/a[1]/span[1]")).click();
					}
					
					driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[5]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/table[1]/thead[1]/tr[1]/td[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/th[7]/div[1]")).click();

					driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[5]/div[2]/form[1]/div[1]/div[1]/div[1]/div[2]/div[3]/span[1]/button[1]/span[2]")).click();

				}
			}
		}

//		WebElement startHour = driver.findElement(By.xpath("/html[1]/body[1]/div[7]/div[2]/div[1]/span[1]"));
//		startHour.sendKeys("07");
//		WebElement startMinute = driver.findElement(By.xpath("/html[1]/body[1]/div[7]/div[2]/div[3]/span[1]"));
//		startMinute.sendKeys("30");
//		
//		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[5]/div[2]/form[1]/div[1]/div[1]/div[1]")).click();
//		
		
		Thread.sleep(15000);
		driver.quit();
	}

}
