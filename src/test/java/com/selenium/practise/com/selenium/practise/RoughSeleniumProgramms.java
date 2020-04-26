package com.selenium.practise.com.selenium.practise;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RoughSeleniumProgramms {
// Broken links program
	@Test
	public void brokenLinks() throws InterruptedException, IOException {
		System.setProperty("WebDriver.Chrome.Driver",("User.dir")+"eclipse-workspace\\com.selenium.practise");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://mein-deutschbuch.de");
		Thread.sleep(5000);
		//Capture all the Anchor tag
	      List<WebElement>links=driver.findElements(By.tagName("a"));
	      //number of links
	      System.out.println(links.size());
		for(int i=0;i<links.size();i++) {
			//by using href property we can get URL of required link
			WebElement element=links.get(i);
			String url=element.getAttribute("href");
			URL urlconn= new URL(url); // create URL link object
	HttpURLConnection httpurlconn= (HttpURLConnection) urlconn.openConnection();// create a connection using url object"urlconn"
	Thread.sleep(2000);
	//establish connection
	httpurlconn.connect();		
	//getting response code,if getting 400 above it's broken link		
	int responsecode=httpurlconn.getResponseCode();	
	if(responsecode>=400) {
		System.out.println(url+"- "+ "is broken link");
	}	else {
		System.out.println(url+"- "+ "is valid link");	
	}
		
		}
	      
	      
			driver.close();
	}		}



