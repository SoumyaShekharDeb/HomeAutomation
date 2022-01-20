package UI;

import java.util.List;

import javax.swing.plaf.basic.BasicSliderUI.ActionScroller;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class checkBoxDemo {

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
		
		WebElement checkbox = driver.findElement(By.xpath("//input[@name='interest_market_c']"));
		Actions actions = new  Actions(driver);
		actions.moveToElement(checkbox);
		actions.perform();
		
	    driver.findElement(By.xpath("//input[@name='interest_market_c']")).click();
	    driver.findElement(By.xpath("//input[@name='interest_sell_c']")).click();
	    driver.findElement(By.xpath("//input[@name='interest_serve_c']")).click();
	    driver.findElement(By.xpath("//input[@name='interest_market_c']")).click();
	    
	     List<WebElement> allCheckBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
	    System.out.println("The total number of checkboxex :"+allCheckBoxes.size());
	    
	    List<WebElement> allOptions = driver.findElements(By.xpath("//input[@type='checkbox']//parent::div//label"));
	    System.out.println("The total number of checkboxex :"+allOptions.size());
	    
	    for (int i=0; i<allOptions.size(); i++)
	    {
	    	System.out.println("The options are :"+allOptions.get(i).getText());
	    }
	    
	    driver.quit();

	}

}
