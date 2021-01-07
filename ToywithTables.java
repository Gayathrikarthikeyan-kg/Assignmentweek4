package Assignmentsweek4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToywithTables {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.get("http://www.leafground.com/pages/table.html");
		//to get the no of columns
		List<WebElement>columns=	dr.findElementsByTagName("th");
		int columnscount= columns.size();
		System.out.println("The column count is"+columnscount);
		//to get  no of row size
		List<WebElement>rows=	dr.findElementsByTagName("tr");
		int rowscount= rows.size();
		System.out.println("The column count is"+rowscount);
		//to get the prgrs value of learn to interact with Elements
		WebElement getpercent=dr.findElementByXPath("//td[normalize-space()='Learn to interact with Elements']//following::td[1]");
		String percent= getpercent.getText();
		System.out.println("The percentage of interact is "+percent);
		//check the vital task for least completed prcs
		//check the vital progress for the  least completed task
		List<WebElement>allprogress=	dr.findElementsByXPath("//td[2]");
		List<Integer>numlist=new ArrayList<Integer>();
		for (WebElement webElement : allprogress) {
			//get single element and removing %
			String individualvalue=webElement.getText().replace("%", "");
			//changing string into int
			numlist.add(Integer.parseInt(individualvalue));			
		}
		System.out.println("The Final progress is"+numlist);
		//converting the int to again string
		//to find the minimal value
		int smallvalue=Collections.min(numlist);
		System.out.println("The Minimal progress is"+smallvalue);
		//to get result along with percentage 
		//String smallvaluestring=Integer.toString(smallvalue)+"%";
		//String finalxpath ="//td[normalize-space()="+"\""+smallvaluestring+"\""+"]"+"//following::td[1]//child::input";
		//System.out.println(finalxpath);
		WebElement check=dr.findElementByXPath("//td[contains(text(),'"+smallvalue+"')]/following::input");
		check.click();
	}

}

