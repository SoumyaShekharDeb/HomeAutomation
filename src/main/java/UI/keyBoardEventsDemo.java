package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class keyBoardEventsDemo {

	
	public static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://extendsclass.com/text-compare.html");
		driver.manage().window().maximize();
		WebElement source_text = driver.findElement(By.xpath("(//span[text()='File comparison can be difficult, '])[1]"));
		Actions action = new Actions(driver);
		action.keyDown(source_text, Keys.CONTROL).sendKeys("a").sendKeys("c").build().perform();
		WebElement destination_text = driver.findElement(By.xpath("(//span[text()='Indeeed it can be helpful to compare two text documents '])[2]"));
		action.keyDown(destination_text, Keys.CONTROL).sendKeys("a").sendKeys("v").build().perform();
		
	}

}

