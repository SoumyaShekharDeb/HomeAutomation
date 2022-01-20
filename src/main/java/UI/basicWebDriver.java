package UI;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class basicWebDriver {

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
		
		String currentURL = driver.getCurrentUrl();
		System.out.println(currentURL);
		
		String title = driver.getTitle();	
		System.out.println(title);
		
		String pagesource = driver.getPageSource();
		System.out.println(pagesource);
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.name("login-button")).click();
		
		List<WebElement> webelements = driver.findElements(By.xpath("//div[@class='inventory_list']//div[@class='inventory_item']"));
		System.out.println(webelements);
		
		driver.navigate().to("https://www.sugarcrm.com/au/why-sugar/");
		String windowhandle = driver.getWindowHandle();
		System.out.println(windowhandle);
		
		driver.findElement(By.xpath("//span[text()='Get a Demo']")).click();
		Set<String> windowhandles = driver.getWindowHandles();
		System.out.println(windowhandles);
		
		
		
		driver.navigate().to("https://www.facebook.com/");
		
		driver.close();

	}

}
