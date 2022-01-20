package UI;



import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class captureScreenshotDemo {

	public static String browser = "Chrome";
	public static WebDriver driver;

	public static void main(String[] args) throws IOException {
		
		Date currentdate = new Date();
		System.out.println(currentdate);
		String screenshotFileName = currentdate.toString().replace(" ", "-").replace(":", "-");
		System.out.println(screenshotFileName);

		if (browser.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot/"+screenshotFileName+".png"));

	}

}
