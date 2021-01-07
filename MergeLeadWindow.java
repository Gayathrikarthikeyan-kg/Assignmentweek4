package Assignmentsweek4;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeLeadWindow {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.get("http://leaftaps.com/opentaps/control/main");
		dr.findElementById("username").sendKeys("demosalesmanager");
		dr.findElementById("password").sendKeys("crmsfa");
		dr.findElementByClassName("decorativeSubmit").click();
		dr.findElementByLinkText("CRM/SFA").click();
		dr.findElementByLinkText("Leads").click();
		 //Click Merge leads
		dr.findElementByLinkText("Merge Leads").click();
		// Click on Icon near From Lead
		dr.findElementByXPath("(//img[@alt='Lookup'])[1]").click();
			//Move to new window
		String oldWindow=dr.getWindowHandle();
		Set<String> parentWindow=dr.getWindowHandles();
		List <String> allWindows=new ArrayList<String>(parentWindow);
		dr.switchTo().window(allWindows.get(1));
		//Enter Lead ID
		dr.findElementByXPath("(//label[text()='Lead ID:']/following::input)[1]").sendKeys("10039");
		// Click Find Leads button
		dr.findElementByXPath("//button[text()='Find Leads']").click();Thread.sleep(5000);
		//Click First Resulting lead
		dr.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a[1]").click();
		//Switch back to primary window
		dr.switchTo().window(oldWindow);
		//Click on Icon near To Lead
		dr.findElementByXPath("(//img[@alt='Lookup'])[2]").click();
		//Move to new window
		String oldWindow1=dr.getWindowHandle();
		Set<String> parentWindow1=dr.getWindowHandles();
		List <String> allWindows1=new ArrayList<String>(parentWindow1);
		dr.switchTo().window(allWindows1.get(1));
		//Enter Lead ID
		dr.findElementByXPath("(//label[text()='Lead ID:']/following::input)[1]").sendKeys("10053");
		// Click Find Leads button
		dr.findElementByXPath("//button[text()='Find Leads']").click();Thread.sleep(5000);
		//Click First Resulting lead
		dr.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a[1]").click();
		//Switch back to primary window
		dr.switchTo().window(oldWindow1);
		// Click Merge
		dr.findElementByLinkText("Merge").click();
		Alert mergealert= dr.switchTo().alert();
		//Accept Alert
		mergealert.accept();
		//Click Find Leads link
		dr.findElementByLinkText("Find Leads").click();
		// Enter From Lead ID
		dr.findElementByXPath("(//label[text()='Lead ID:']/following::input)[1]").sendKeys("10014");
		//Click Find Leads button
		dr.findElementByXPath("//button[text()='Find Leads']").click();
		// Verify message "No records to display" in the Lead List. 
		String text = dr.findElementByClassName("x-paging-info").getText();
		System.out.println("text is : "+text);
		if (text.equals("No records to display")) {
			System.out.println("Text matched");
		} else {
			System.out.println("Text not matched");
		}
		System.out.println("Test Method Ended");
		dr.close();
		
		
		
		
		
		
	}}
