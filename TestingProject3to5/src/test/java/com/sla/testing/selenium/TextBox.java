package com.sla.testing.selenium;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TextBox {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/input.xhtml");
		driver.manage().window().maximize();
		
		
		WebElement name = driver.findElement(By.id("j_idt88:name"));
		name.sendKeys("Madhu Chandrika");
		
		
		WebElement countryAppend = driver.findElement(By.id("j_idt88:j_idt91"));
		countryAppend.sendKeys("India");
		
		WebElement diabled = driver.findElement(By.id("j_idt88:j_idt93"));

		@Nullable
		String disabledText = diabled.getAttribute("class");
		String[] split = disabledText.split("-");
		System.out.println(split[split.length-1]);
//		if(!diabled.isEnabled()) {
//			System.out.println("It is not enabled");
//		}else {
//			System.out.println("It is enabled");
//		}
//		
		WebElement clearText = driver.findElement(By.id("j_idt88:j_idt95"));
		clearText.clear();

		WebElement readValue = driver.findElement(By.id("j_idt88:j_idt97"));

		@Nullable
		String readWord = readValue.getAttribute("value");
		System.out.println(readWord);
		
		
		WebElement emailTab = driver.findElement(By.id("j_idt88:j_idt99"));
		emailTab.sendKeys("madhu@gmail.com" + Keys.TAB);
		
		WebElement textarea = driver.findElement(By.id("j_idt88:j_idt101"));
		textarea.sendKeys("Hai Hello how are you?...!!!");
		
//		WebElement textEditor = driver.findElement(By.id("j_idt88:j_idt103_editor")).findElement(By.tagName("div")).findElement(By.tagName("p"));
//		
//		textEditor.sendKeys("In Text editor need to write something");
		
		
		WebElement textEditor = driver.findElement(By.xpath("//div[@id='j_idt88:j_idt103_editor']//p"));
		textEditor.sendKeys("In Text editor need to write something");
		
		
		WebElement enterAndError = driver.findElement(By.id("j_idt106:thisform:age"));
		enterAndError.sendKeys(Keys.ENTER);
		
		WebElement errorMessage = driver.findElement(By.xpath("//span[@id='j_idt106:thisform:j_idt110_error-detail']"));
		
		String error = errorMessage.getText();
		System.out.println(error);
		

		
		WebElement labelElement = driver.findElement(By.id("j_idt106:j_idt113"));
		Point position = labelElement.getLocation();
		System.out.println(position.getX());
		System.out.println(position.getY());
		
		WebElement floatInput = driver.findElement(By.id("j_idt106:float-input"));
		floatInput.click();
		
		labelElement = driver.findElement(By.id("j_idt106:j_idt113"));
		position = labelElement.getLocation();
		System.out.println(position.getX());
		System.out.println(position.getY());
		
		
		WebElement TypeChoose = driver.findElement(By.id("j_idt106:auto-complete_input"));
		TypeChoose.sendKeys("Madhu");
		
		Thread.sleep(2000);
		
		List<WebElement> listElements = driver.findElements(By.xpath("/html[1]/body[1]/span[1]/ul[1]/li"));
		listElements.get(2).click();
		
		WebElement dob = driver.findElement(By.id("j_idt106:j_idt116_input"));
		dob.sendKeys("05/30/1998");

		List<WebElement> tableRows = driver.findElements(By.xpath("/html[1]/body[1]/div[6]/div[1]/div[2]/table[1]/tbody[1]/tr"));
		System.out.println("Table Rows: " + tableRows.size());//6
		boolean flag = false;
		for(int i=0;i<tableRows.size();i++) {
			//tableRows.get(i).findElements(By.xpath("/html[1]/body[1]/div[6]/div[1]/div[2]/table[1]/tbody[1]/tr[i]/td
			if(i<=tableRows.size()-1) {//5<=5
				List<WebElement>  tableColumns = tableRows.get(i).findElements(By.xpath("/html[1]/body[1]/div[6]/div[1]/div[2]/table[1]/tbody[1]/tr[" +  (i+1) + "]/td"));
				System.out.println("Table Columns: " + tableColumns.size());//column size => 7
				for(int j=0;j<tableColumns.size();j++) {//Column iteration
					if(j<=tableColumns.size()-1) {//6<=6
					Thread.sleep(1000);
					//                                  0-6
					WebElement element = tableColumns.get(j).findElement(By.xpath("./*[1]"));//childElement
					if(element.getTagName().equals("span")) {
						System.out.println(element.getTagName() + " : " + element.getText() + "Which means no element");
						continue;
					}else {                      //0-6																						1-6              1-7
						WebElement a = tableColumns.get(j).findElement(By.xpath("/html[1]/body[1]/div[6]/div[1]/div[2]/table[1]/tbody[1]/tr[" +(i+1)+ "]/td[" + (j+1)+ "]/a"));
					System.out.println(element.getTagName() + " : " + a.getText());//1
					@Nullable
					String classText = a.getAttribute("class");
					if(classText.contains("active")) {
						String date = a.getText();
						System.out.println("Active date: " + date);
						a.click();
						flag = true;
						break;
					}
					}
					}
					
				}
			}
			if(flag) {//true
				break;
			}
		}
		
		
		WebElement spinElement = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[5]/div[2]/div[1]/div[2]/div[1]/span[3]/a[1]"));
		spinElement.click();
		spinElement.click();
		spinElement.click();
		
		@Nullable
		String spinInputValue = driver.findElement(By.id("j_idt106:j_idt118_input")).getAttribute("aria-valuenow");
		System.out.println(spinInputValue);
		
		WebElement slideInput = driver.findElement(By.id("j_idt106:slider"));
		slideInput.sendKeys("50");
		
		WebElement slideElement = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[5]/div[2]/div[1]/div[2]/div[1]/div[2]/span[1]"));
		Thread.sleep(1000);
		String slideCss = slideElement.getAttribute("style");
		System.out.println(slideCss);
		String slideSub = slideCss.substring(slideCss.length()-4,slideCss.length()-2);
		System.out.println(slideSub);
		
		
		driver.findElement(By.id("j_idt106:j_idt122")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[normalize-space()='Close']")).click();
		
		
		
		Thread.sleep(5000);//15000ms = 15s
		driver.quit();
	}

}
