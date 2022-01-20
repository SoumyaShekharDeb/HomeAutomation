package UI;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class printAllLinks {

	public static String browser = "Chrome";
	public static WebDriver driver;

	public static void main(String[] args) {

		if (browser.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.get("https://www.sugarcrm.com/au/request-demo/");
		driver.manage().window().maximize();
		
		List<WebElement> allTags = driver.findElements(By.tagName("a"));
		System.out.println("Total number of tags : "+allTags.size());
		
		
		for (int i=0;i<allTags.size();i++)
		{
			System.out.println("The links are : "+allTags.get(i).getAttribute("href"));
			System.out.println("The links are : "+allTags.get(i).getText());
		}
		
         List<WebElement> allOptions = driver.findElements(By.tagName("option"));
         System.out.println("Total number of options : "+allOptions.size());
         
         for (int j=0;j<allOptions.size();j++)
         {
        	 System.out.println("The options are :"+allOptions.get(j).getText());
         }
	

	}

}
