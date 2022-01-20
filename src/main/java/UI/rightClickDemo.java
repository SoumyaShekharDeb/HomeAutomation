package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class rightClickDemo {

	
	public static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/selectable/#display-grid");
		driver.manage().window().maximize();
		WebElement demoFrame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(demoFrame);
        WebElement select1 = driver.findElement(By.xpath("//ol[@id='selectable']//li[text()='1']"));
        WebElement select2 = driver.findElement(By.xpath("//ol[@id='selectable']//li[text()='2']"));
        WebElement select3 = driver.findElement(By.xpath("//ol[@id='selectable']//li[text()='3']"));
        WebElement select4 = driver.findElement(By.xpath("//ol[@id='selectable']//li[text()='4']"));
        select1.click();
        select2.click();
        select3.click();
        select4.click();
        Actions action = new Actions(driver);
        action.contextClick(select4).perform();
        
        
	}

}

