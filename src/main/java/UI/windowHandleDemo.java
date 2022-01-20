package UI;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class windowHandleDemo {

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
		driver.get("http://demo.automationtesting.in/Windows.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[text()='    click   ']")).click();

		Set<String> windows = driver.getWindowHandles();
		System.out.println(windows);
		Iterator<String> iterator = windows.iterator();
		String parentwindow = iterator.next();
		System.out.println("The parent window is :"+parentwindow);
		String childwindow = iterator.next();
		System.out.println("The child window is :"+childwindow);
		driver.switchTo().window(childwindow);
		driver.findElement(By.xpath("//a[@class='selenium-button selenium-webdriver text-uppercase font-weight-bold']"))
				.click();
		System.out.println(driver.getTitle());
		
		driver.switchTo().window(parentwindow);

		driver.close();

	}

}
