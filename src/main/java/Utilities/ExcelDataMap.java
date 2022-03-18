package Utilities;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;


public class ExcelDataMap {

	public WebDriver driver;
	ExcelUtil excel;
	String excelPath;

	public ExcelDataMap(WebDriver driver){
		this.driver =  driver;
		this.excelPath = Utility.getURLsExcelFile();
	}

	public ArrayList<String> get_URLs(String sheetname){

		String URL_Col = JsonUtil.readJson(Utility.getConfigJsonFile(), "url_col");
		ArrayList<String> arrayListObj = new ArrayList<String>();

		try {
			excel = new ExcelUtil(excelPath);
		}catch(Exception e) {
			e.printStackTrace();
		}

		for(int rowNum = 2; rowNum <= excel.getRowCount(sheetname); rowNum ++) {

			String URL = excel.getCellData(sheetname, URL_Col, rowNum);

			arrayListObj.add(URL);
		}

		return arrayListObj;
	}


	public void set_PageLoadTimings(String sheetname, int rowNum, String value){

		String LoadTime_Col = JsonUtil.readJson(Utility.getConfigJsonFile(), "pageloadtimeinseconds");

		try {
			excel = new ExcelUtil(excelPath);
		}catch(Exception e) {
			e.printStackTrace();
		}
		excel.setCellData(sheetname, LoadTime_Col, rowNum, value);
	}

	public void getPageLoadingTime(String sheetname) {

		ArrayList<String> urlsData = get_URLs(sheetname);

		int TOTAL_URLs = urlsData.size();
		System.out.println("TOTAL_URLs="+TOTAL_URLs);

		for(int i=0; i<TOTAL_URLs; i++) {

			String url = urlsData.get(i);

			System.out.println("URL = "+url.toString());

			long start = System.currentTimeMillis();

			driver.get(url);

			long end = System.currentTimeMillis();

			long loadTime = end - start;

			float timeSeconds = (float) (loadTime*0.001);

			String loadTimeValue = Float.toString(timeSeconds);

			set_PageLoadTimings(sheetname, i+2, loadTimeValue + " seconds");

			System.out.println("Load Time inSeconds = "+ loadTimeValue);
			System.out.println("Load Time inMilliSeconds = "+ loadTime);
			System.out.println("===========================================");
		}
	}
}
