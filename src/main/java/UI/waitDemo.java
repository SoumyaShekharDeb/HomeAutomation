package UI;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class waitDemo {

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
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
		
		// applying implicit wait
		
	//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement electronics = driver.findElement(By.xpath("(//a[text()='Electronics'])[2]"));
		Actions action = new Actions(driver);
		action.moveToElement(electronics).perform();
		// applying explicit wait
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement apple = driver.findElement(By.xpath(
				"(//a[text()='Electronics'])[2]//parent::li//a[text()='Apple']"));
		wait.until(ExpectedConditions.visibilityOf(apple));
		apple.click();
		System.out.println(electronics.getText());
		System.out.println(apple.getText());
			
		System.out.println(driver.getTitle());
		

	}

}
