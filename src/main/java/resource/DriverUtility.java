package resource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverUtility {
	public static WebDriver driver;
	public String browser;
	public WebDriver initializeDriver(String url) throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resource\\data.properties");
		Properties prop = new Properties();
		prop.load(fis);
		browser = prop.getProperty("browser");
		if(browser.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resource\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(url);

		}
		else
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resource\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.get(url);
		}
		return driver;
	}
	
}
