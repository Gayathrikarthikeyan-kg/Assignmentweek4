package Assignmentsweek4;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TextChange {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/TextChange.html"); 
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement appear=	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='todo']//button[1]")));
		
		appear.click();
		Alert appearclick=driver.switchTo().alert();
		appearclick.accept();
		
		
	}

}
