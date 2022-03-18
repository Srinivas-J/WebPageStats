package Utilities;

import java.io.File;

public class Utility {

	public static String getConfigJsonFile() {

		return "src"+File.separator+"main"+File.separator+"java"+File.separator+"config"+File.separator+"config.json";
	}

	public static String getURLsExcelFile() {

		return "src"+File.separator+"main"+File.separator+"java"+File.separator+"testdata"+File.separator+"URLsTestData.xlsx";
	}
}
