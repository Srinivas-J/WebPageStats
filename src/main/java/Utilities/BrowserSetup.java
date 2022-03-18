package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserSetup {

	public WebDriver driver; 

	//Getting the Browser instance for which was specified at 'config.json'
	public WebDriver getBrowserInstance() {

		String BrowserName = JsonUtil.readJson(Utility.getConfigJsonFile(), "browser");

		if(BrowserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} 
		else if(BrowserName.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(BrowserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		else if(BrowserName.equalsIgnoreCase("Safari")) {
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
		}
		else if(BrowserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}else {
			System.out.println("Please pass a valid BrowserName!");
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		return driver;
	}
}
