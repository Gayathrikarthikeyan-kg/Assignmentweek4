package Assignmentsweek4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lenskart {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver dr = new ChromeDriver();
		dr.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		dr.manage().window().maximize();
		dr.get("https://www.lenskart.com/");
		WebElement lens = dr.findElementByLinkText("Computer Glasses");
		Actions builder = new Actions(dr);

		builder.moveToElement(lens).perform();
		//to click men
		WebElement men=dr.findElementByXPath("(//img[@title='men'])[2]"); 
		men.click(); 
		//to click premium
		WebElement premium =dr.findElementByXPath( "//div[@id='cssmenu']/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/a[1]/div[1]/div[1]/span[1]" ); 
		builder.moveToElement(premium).click().perform();
				
		List<WebElement> list=dr.findElementsByXPath("/html/body/div[1]/div/div/div/div/div/div[4]/div[1]/div/div/div[3]/div/ul/child::*");
		//list.get(2).click();
		for(WebElement e: list) {
			if(e.getText().equalsIgnoreCase("round")) {
				e.click();
			}
		}
		list = dr.findElementsByXPath("/html/body/div[1]/div/div/div/div/div/div[4]/div[1]/div/div/div[4]/div/ul/li/div/label/child::span");
		List<Integer> frameColorsCount=new ArrayList<Integer>();
		Integer value = null;
		value=Integer.valueOf(list.get(0).getText().replaceAll("[^0-9]", ""));//extracts only numbers
		list.get(0).click();
		WebElement result = dr.findElementByXPath("/html/body/div[1]/div/div/div/div/div/div[6]/div[2]");
		String resultText = result.getText().split("of")[1];
		Integer resValue = Integer.valueOf(resultText.replaceAll("[^0-9]", ""));
		if(value == resValue) {
			System.out.println("Correct");
		}
		//to get size
		WebElement img=dr.findElementByXPath("(//div[contains(@class,'col-md-12 text-center')]//img)[1]");
		builder.moveToElement(img).build().perform();
		WebElement productHover = dr.findElementByXPath("/html/body/div[1]/div/div/div/div/div/div[8]/div[1]/div/div/div[1]/div[1]/div/div/div/div[3]/p/child::span");
		builder.moveToElement(productHover).build().perform();	
		String size = productHover.getText();
		System.out.println("size:"+size);
		}
}
