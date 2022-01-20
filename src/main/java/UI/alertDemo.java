package UI;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class alertDemo {

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

		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
		driver.manage().window().maximize();
		WebElement Resultframe1 = driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
		driver.switchTo().frame(Resultframe1);
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		String alertText1 = driver.switchTo().alert().getText();
		System.out.println(alertText1);

		Alert alertOnPage = driver.switchTo().alert();

		alertOnPage.sendKeys("Soumya");
		alertOnPage.accept();

		driver.switchTo().parentFrame();
		System.out.println(driver.getTitle());

		driver.quit();

	}

}
