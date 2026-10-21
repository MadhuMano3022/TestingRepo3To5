package com.sla.testing.selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileDownload {

	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.leafground.com/file.xhtml");
		
	
		
		WebElement download = driver.findElement(By.id("j_idt93:j_idt95"));
		download.click();
		
		
		Thread.sleep(3000);
		File file = new File("C:\\Users\\chand\\Downloads");
		
		File[] files = file.listFiles();
		for(File fi : files) {
			if(fi.getName().equals("TestLeaf Logo.png")) {
				System.out.println("Found File Successfully: " + fi.getName());
				break;
			}
		}
		
		WebElement upload = driver.findElement(By.id("j_idt88:j_idt89"));
		upload.click();
		
		Thread.sleep(1000);
		
		String str = "C:\\Users\\chand\\Downloads\\TestLeaf Logo.png";
		
		StringSelection location = new StringSelection(str);
		
		Thread.sleep(1000);
		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(location,null);
		
		
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		
		
		Thread.sleep(15000);
		driver.quit();
	}

}
