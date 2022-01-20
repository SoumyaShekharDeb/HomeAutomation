import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenChromeScript {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Soumya-Workspace\\HomePracticeProject\\WebDrivers\\chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		
	}

}
