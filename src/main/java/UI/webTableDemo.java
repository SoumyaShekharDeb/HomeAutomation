package UI;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class webTableDemo {

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

		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_table_intro");
		driver.manage().window().maximize();

		// Step1 - Switch to frame containing the table
		// Step2 - Get the number of rows
		// Step3 - Get the number of columns
		// Step4 - iterate rows and columns and get the text and print it

		WebElement Resultframe = driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
		driver.switchTo().frame(Resultframe);

		List<WebElement> rows = driver.findElements(By.xpath("/html/body/table/tbody/tr"));
		System.out.println("The total number of rows are :" + rows.size());

		List<WebElement> columns = driver.findElements(By.xpath("/html/body/table/tbody/tr[2]/td"));
		System.out.println("The total number of columns are :" + columns.size());

		for (int i = 2; i <= rows.size(); i++) {
			for (int j = 1; j <= columns.size(); j++) {

				System.out.print(
						driver.findElement(By.xpath("/html/body/table/tbody/tr[" + i + "]/td[" + j + "]")).getText()+ "     ||    ");

			}

			System.out.println();
		}
	}
}
