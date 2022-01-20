package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class javaScriptExecutorDemo {

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
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
		driver.manage().window().maximize();
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		//Print the title of the page
		String script = "return document.title;";
		String title = (String) jse.executeScript(script);
		System.out.println(title);
		
		//Click the try button
		WebElement Resultframe1 = driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
		driver.switchTo().frame(Resultframe1);
		jse.executeScript("myFunction()");
		driver.switchTo().alert().accept();
		
		// highlight the button
		WebElement trybtn = driver.findElement(By.xpath("//button[text()='Try it']"));
		jse.executeScript("arguments[0].style.border='3px solid red'", trybtn);
		
		//scroll
		driver.navigate().to("https://www.w3schools.com/");
		WebElement certification = driver.findElement(By.xpath("//a[text()='Get started']"));
		jse.executeScript("arguments[0].scrollIntoView(true);", certification);
		
		

	}

}
