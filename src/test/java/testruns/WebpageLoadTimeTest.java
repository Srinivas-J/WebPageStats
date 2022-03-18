package testruns;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Utilities.BrowserSetup;
import Utilities.JsonUtil;
import Utilities.ExcelDataMap;
import Utilities.Utility;

public class WebpageLoadTimeTest {

	public WebDriver driver ;
	public String sheetname ;

	@BeforeClass
	public void init(){

		//Create the required Browser instance 
		BrowserSetup browser = new BrowserSetup();
		this.driver = browser.getBrowserInstance();
	}

	@Test
	public void runPages() {

		//Read the Excel sheet name from the JSON config file
		sheetname = JsonUtil.readJson(Utility.getConfigJsonFile(), "url_sheetname");

		//Call the Page time tracking logic 
		ExcelDataMap testData = new ExcelDataMap(driver);
		testData.getPageLoadingTime(sheetname);
	}


	@AfterClass
	public void tearDown() {

		//Close the Browsers
		driver.quit();
	}
}
