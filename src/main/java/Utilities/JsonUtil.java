package Utilities;

import java.io.File;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class JsonUtil {

	public static String readJson(String fileNameWithPath, String keyName) {

		String reqKeyValue = null;

		try {		
			JSONParser jsonparser = new JSONParser();
			File file = new File(fileNameWithPath);
			Object object = jsonparser.parse(new FileReader(file));    
			JSONObject obj = (JSONObject)object;
			reqKeyValue = (String) obj.get(keyName);

			if(reqKeyValue == null) {
				throw new Exception();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		return reqKeyValue;
	}

}
