package Assignmentsweek4;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calaender {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.get("http://leafground.com/pages/Calendar.html");
		//Select 10th day of following month 
		/*
		 * WebElement calender= dr.findElementById("datepicker");
		 * calender.sendKeys("10/01/2021"+Keys.ENTER);
		 */
		
		/*to select next month
		 * WebElement calender=dr.findElementByXPath("//span[text()='Next']");
		 * calender.click();
		 */
		WebElement calender=	dr.findElementById("datepicker");
		calender.click();
		  WebElement datetobeGiven=dr.findElementByLinkText("10");
		  datetobeGiven.click();
		 
		}

}
