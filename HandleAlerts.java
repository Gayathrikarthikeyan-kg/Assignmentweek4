package Assignmentsweek4;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleAlerts {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.get("http://leafground.com/pages/Alert.html");
		//Click the button to display a alert box.
		WebElement alertBox=dr.findElementByXPath("//button[text()='Alert Box']");
		alertBox.click();
		Alert alert= dr.switchTo().alert();
		alert.accept();
		//Click the button to display a confirm box.
		WebElement confirmBox=dr.findElementByXPath("//button[text()='Confirm Box']");
		confirmBox.click();
		Alert confirmAlert=dr.switchTo().alert();
		confirmAlert.accept();
		//confirmAlert.dismiss();
		//Click the button to display a prompt box.
		WebElement promptBox=dr.findElementByXPath("//button[text()='Prompt Box']");
		promptBox.click();
		Alert promptAlert=dr.switchTo().alert();
		promptAlert.sendKeys("Gayu");
		promptAlert.accept();
		//Click the button to learn line-breaks in an alert.
		WebElement linebreak=dr.findElementByXPath("//button[text()='Line Breaks?']");
		linebreak.click();
		Alert linebreakAlert=dr.switchTo().alert();
		linebreakAlert.accept();
		//Click the below button and click OK.
		WebElement but=dr.findElementByXPath("//button[text()='Sweet Alert']");
		but.click();
		 //Alert butAlert=dr.switchTo().alert(); 
		// butAlert.accept();	
	    dr.close();
		
		


	}

}
