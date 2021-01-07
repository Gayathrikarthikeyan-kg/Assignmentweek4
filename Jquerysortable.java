package Assignmentsweek4;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Jquerysortable {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.get("https://jqueryui.com/sortable/");
        JavascriptExecutor js = (JavascriptExecutor) dr;
        js.executeScript("window.scrollBy(0, 500)");
        dr.switchTo().frame(0); 
        Actions builder = new Actions(dr);  
        WebElement item5 = dr.findElementByXPath("//li[text()='Item 5']");
        WebElement item6 = dr.findElementByXPath("//li[text()='Item 6']");    
        Point item6Loc = dr.findElementByXPath("//li[text()='Item 6']").getLocation();
        builder.clickAndHold(item5).moveToElement(item6, item6Loc.x, item6Loc.x).release(item5).perform();
        System.out.println("moved");
        

		

	}



}


