package Assignmentsweek4;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkwithWindows {

	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/Window.html");
		//Click button to open home page in New Window
		String oldWindow=driver.getWindowHandle();
		
		
		//  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebElement button= driver.findElementById("home");
		button.click();
		Set <String> handles=driver.getWindowHandles();
		for (String newWindow : handles) {

			driver.switchTo().window(newWindow);

		}
		WebElement edit=driver.findElementByXPath("//a[@href='pages/Edit.html']//img[1]");
		edit.click();
		driver.close();	
		driver.switchTo().window(oldWindow);
		//Find the number of opened windows
		WebElement multiple=driver.findElementByXPath("//*[@id=\"contentblock\"]/section/div[2]/div/div/button");	
		multiple.click();
		int SizeofWindow=driver.getWindowHandles().size();
		System.out.println("The  number of opened windows is "+SizeofWindow);
		//Close all except this window 
		WebElement dontcloseme=driver.findElementByXPath("(//button[@id='color'])[1]");
		dontcloseme.click();
		Set <String> mulwindowhandles=driver.getWindowHandles();
		for (String openmulwin : mulwindowhandles) {
			if(!openmulwin.equals(oldWindow))
				driver.switchTo().window(openmulwin);
				driver.close();
		}	
		  //Wait for 2 new Windows to open String oldWin=driver.getWindowHandle();
		driver.switchTo().window(oldWindow);
		driver.findElementByXPath("//button[text()='Wait for 5 seconds']").click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Set <String> mulwindowwaithandles=driver.getWindowHandles();
		 driver.quit();
			}	  		  
		 	}


