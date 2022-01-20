package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class autoSuggestDropDown {

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
		driver.get("https://www.makemytrip.com/flights/");
		driver.manage().window().maximize();

		/*
		 * driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(
		 * "Kolkata");
		 * driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(Keys.
		 * ARROW_DOWN);
		 * driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(Keys.
		 * ENTER);
		 */

		// alternate approach for a cleaner look
		driver.findElement(By.xpath("//li[@data-cy='oneWayTrip']")).click();
		driver.findElement(By.xpath("//span[text()='From']")).click();
		WebElement from = driver.findElement(By.xpath("//input[@placeholder='From']"));

		from.sendKeys("Silchar");
		from.sendKeys(Keys.ARROW_DOWN);
		from.sendKeys(Keys.ENTER);

	}

}
