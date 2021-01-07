package Assignmentsweek4;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/frame.html");
		//I am inside a frame 
		driver.switchTo().frame(0);//swtiching to frame by index value
		 WebElement but1=driver.findElementById("Click");
		 but1.click();
		 String text=but1.getText();
		 System.out.println("The Text Inside frame is "+text);
		 //I am inside a nested frame 
		driver.switchTo().defaultContent(); //to back to old page
		driver.switchTo().frame(1);//select using index
		driver.switchTo().frame(0);//or useframe("frame");
		 WebElement but2=driver.findElementById("Click1");
		 but2.click();
		 String text1=but2.getText();
		 System.out.println("The Text Inside Nestedframe is "+text1);
		 //Find total number of frames.
		 driver.switchTo().defaultContent();
		List <WebElement> size=driver.findElementsByTagName("iframe");
		 int totalsize=size.size();
		 int count=totalsize;
		 for(int  i=0;i<totalsize ;i++)
		 {
			 driver.switchTo().frame(i);
			 count = count + driver.findElementsByTagName("iframe").size(); 
			 driver.switchTo().defaultContent(); } System.out.println(count); 
			 System.out.println("The Total Number of frames is"+count);
			 
			 
		 }
		
	}

