package UI;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class radioButtonDemo {

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

		WebElement radio1 = driver.findElement(By.xpath("//div[@id='field20']//input[@value='1']"));
		radio1.click();
		System.out.println(radio1.isSelected());

		WebElement radio2 = driver.findElement(By.xpath("//div[@id='field20']//input[@value='0']"));
		System.out.println(radio2.isSelected());
		
		List<WebElement> allRadios = driver.findElements(By.xpath("//div[@id='field20']//input"));
		System.out.println("The total number of radio buttons :"+allRadios.size());
		
		
		driver.quit();

	}

}
