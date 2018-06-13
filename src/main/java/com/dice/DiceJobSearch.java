package com.dice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DiceJobSearch {
	
	public static void main(String[] args) {
		
		//Set up chrome driver path
//		System.setProperty("webdriver.chrome.driver", "/Users/iambekzhan/Documents/Selenium/Drivers/chromedriver");
		WebDriverManager.chromedriver().setup();
	
		// invoke selenium webdriver
		WebDriver driver = new ChromeDriver();
		//fullscreen
		driver.manage().window().fullscreen();
		// set universal wait time in case web page is slow
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		/*
		 * Step1: Launch browser https://www.dice.com
		 * Expected: dice home page should be displayed
		 */
		String url = "https://www.dice.com";
		driver.get(url);
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "Job Search for Technology Professionals | Dice.com";
		
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("Pass");
		}else {
			System.out.println("Fail");
		}
		
		String keyword = "java developer";
		driver.findElement(By.id("search-field-keyword")).click();
		driver.findElement(By.id("search-field-keyword")).sendKeys(keyword);
		
		String location = "22102";
		driver.findElement(By.id("search-field-location")).clear();
		driver.findElement(By.id("search-field-location")).sendKeys(location);
		
		driver.findElement(By.id("findTechJobs")).click();
		
		
		
	}
}

