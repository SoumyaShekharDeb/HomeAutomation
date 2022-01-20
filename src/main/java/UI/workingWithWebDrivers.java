package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class workingWithWebDrivers {

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
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Testing");
		driver.findElement(By.xpath("//input[@name='firstname']")).clear();	
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("TeStInG");
		System.out.println(driver.findElement(By.xpath("//input[@name='firstname']")).getAttribute("placeholder"));
		System.out.println(driver.findElement(By.xpath("//input[@value='Request a Demo']")).getCssValue("background-color"));	
		System.out.println(driver.findElement(By.xpath("//input[@value='Request a Demo']")).getSize());
		System.out.println(driver.findElement(By.xpath("//input[@value='Request a Demo']")).getLocation());
		System.out.println(driver.findElement(By.xpath("//input[@value='Request a Demo']")).getText());
		System.out.println(driver.findElement(By.xpath("//input[@value='Request a Demo']")).getTagName());
		
		// these 3 will return boolean value i.e. True or False
		System.out.println(driver.findElement(By.xpath("//input[@value='Request a Demo']")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//input[@value='Request a Demo']")).isEnabled());
		System.out.println(driver.findElement(By.xpath("//input[@value='Request a Demo']")).isSelected());

	}

}
