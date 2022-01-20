package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class selectDropDown {

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
		WebElement dropdown = driver.findElement(By.xpath("//select[@name='employees_c']"));
		Select select = new Select(dropdown);
		
		
		System.out.println(select.getFirstSelectedOption().getText());
		
		select.selectByValue("level3");

		select.selectByIndex(4);
		
		select.selectByVisibleText("501 - 1,000 employees");
		
		
		
		
		// multi select demo
		
	/*	driver.get("https://semantic-ui.com/modules/dropdown.html");
		//driver.findElement(By.xpath("(//div[text()='Skills'])[2]//parent::div//div[@class='menu']")).click();
		
		WebElement multipledropdown = driver.findElement(By.xpath("(//div[text()='Skills'])[2]//parent::div//div[@class='menu']/div"));
		Select selectmultiselect = new Select(multipledropdown);
		
		select.selectByValue("Angular");
		select.selectByValue("Javascript");
		select.selectByValue("Python");
		select.selectByValue("User Experience");
		
		System.out.println(select.getAllSelectedOptions());
		System.out.println(select.getAllSelectedOptions().size());
		select.deselectAll();
		select.selectByValue("React");
		System.out.println(select.getAllSelectedOptions());
		System.out.println(select.getAllSelectedOptions().size());
		
		*/
		
		
	

	}

}
