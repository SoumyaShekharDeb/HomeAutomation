package Tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class readWriteDemo {

	public static void main(String[] args) throws IOException {
		
		Properties properties = new Properties();
		FileInputStream inputstream = new FileInputStream("C:\\Soumya-Workspace\\HomeMavenProject\\src\\test\\resources\\properties\\testdata.properties");  
        properties.load(inputstream);
        System.out.println(properties.getProperty("browser")); 
        System.out.println(properties.getProperty("url")); 
        FileOutputStream outputstream = new FileOutputStream("C:\\Soumya-Workspace\\HomeMavenProject\\src\\test\\resources\\properties\\testdata.properties");  
        properties.setProperty("testdate", "today");
        properties.store(outputstream, "this is an optional comment"); 
        
        
        
        
	}

}
