package Assignmentsweek4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitToAppear {

	public static void main(String[] args) {
		
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://leafground.com/pages/appear.html");
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//1.method	String appear=	wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//b[contains(text(),'Voila')]"))).getText();
//2.method	String appear=	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[contains(text(),'Voila')]"))).getText();
			String appear=	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[contains(text(),'Voila')]"))).getText();
			
System.out.println(appear);

}}
