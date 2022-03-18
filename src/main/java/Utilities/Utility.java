package Utilities;

import java.io.File;

public class Utility {

	//To get the 'config.json' file with complete path
	public static String getConfigJsonFile() {

		return "src"+File.separator+"main"+File.separator+"java"+File.separator+"config"+File.separator+"config.json";
	}

	//To get the 'URLsTestData.xlsx' file with complete path
	public static String getURLsExcelFile() {

		return "src"+File.separator+"main"+File.separator+"java"+File.separator+"testdata"+File.separator+"URLsTestData.xlsx";
	}
}
