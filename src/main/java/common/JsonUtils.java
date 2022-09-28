package common;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtils {
	public String readJsonFile(String filePath) {
		File file = new File(filePath);
		
		String jsonBody = "";
		try {

			FileReader reader = new FileReader(file);
			JSONParser parser = new JSONParser();
			JSONObject responseBodyJsonObj;

			responseBodyJsonObj = (JSONObject) parser.parse(reader);
			
			System.out.println("File path:   " + filePath);

			jsonBody = responseBodyJsonObj.toJSONString();
			System.out.println("JsonBody :  " + jsonBody);
		} catch ( IOException | ParseException e) {
			System.out.println("File not found");
			e.printStackTrace();
		}
		
		return jsonBody;
	}
	
	
	
}
