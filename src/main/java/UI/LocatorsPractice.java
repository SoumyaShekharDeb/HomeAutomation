package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorsPractice {

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
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		/*driver.findElement(By.id("user-name")).sendKeys("testing_id");
		driver.findElement(By.name("user-name")).sendKeys("testing_name");
		driver.findElement(By.className("input_error form_input")).sendKeys("testing"); 
		driver.findElement(By.cssSelector("#user-name")).sendKeys("testing"); 
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("testing"); // direct copy//
		driver.findElement(By.xpath("//input[@id=\"user-name\"]")).sendKeys("testing");  //manual// */
		driver.get("https://www.selenium.dev/");
		driver.findElement(By.linkText("Downloads")).click();
		driver.findElement(By.partialLinkText("other")).click();
		driver.get("https://www.saucedemo.com/");
		WebElement password = driver.findElement(By.id("password"));
		driver.findElement(with(By.tagName("input")).above(password)).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(with(By.tagName("input")).below(password)).click();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.xpath("//input[starts-with(@name,'user')]")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[contains(@name,'pass')]")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[contains(@name,'login-button')]")).click();
		driver.findElement(By.xpath("//button[text()='Open Menu']")).click();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//input[@name='email' and @data-testid='royal_email']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@name='pass' or @data-testid='royal_pass']")).sendKeys("secret_sauce");
		
		// xpath e.g. for parent and child { //select[@id='year']//child::option[@value='1995']//parent::select//parent::span }			
		
		
		
	}


}
