package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dragAndDropDemo {

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
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		WebElement demoframe = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(demoframe);
		WebElement drag_element = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement drop_element = driver.findElement(By.xpath("//div[@id='droppable']"));
		Actions action = new Actions(driver);
		action.dragAndDrop(drag_element, drop_element).perform();
		driver.switchTo().parentFrame();
		System.out.println(driver.getTitle());
		driver.close();

	}

}
