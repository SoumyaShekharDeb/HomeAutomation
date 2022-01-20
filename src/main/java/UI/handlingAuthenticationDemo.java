package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class handlingAuthenticationDemo {

	public static WebDriver driver;
	public static String username = "admin";
	public static String password = "admin";

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://"+username+":"+password+"@the-internet.herokuapp.com/basic_auth");
		// format URL
		// https://username:password@the-internet.herokuapp.com/basic_auth
		driver.manage().window().maximize();

	}

}
