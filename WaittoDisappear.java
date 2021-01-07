package Assignmentsweek4;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaittoDisappear {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/disapper.html");
		WebElement disappearElement =driver.findElementByXPath("//button[@id='btn']//b[1]");
	//	WebElement disappearElement=driver.findElementByXPath("//*[conatins(text(),'Keep Looking at me')] ");
		//to wait
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		//to get invisibility text
		wait.until(ExpectedConditions.invisibilityOf(disappearElement));
		String text=driver.findElementByTagName("Strong").getText();
		System.out.println(text);
		driver.close();

	}

}
