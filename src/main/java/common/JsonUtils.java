package common;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;

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
			jsonBody = responseBodyJsonObj.toJSONString();
		} catch (IOException | ParseException e) {
			System.out.println("File not found");
			e.printStackTrace();
		}

		return jsonBody;
	}

	public void copyJsonFile(File sourceFile, File destinationFile) {
		if (destinationFile.exists()) {
			destinationFile.delete();
		}

		try {
			Files.copy(sourceFile.toPath(), destinationFile.toPath());
			System.out.println("Copy successfully");
		} catch (Exception e) {
			System.out.println("Json request body is not found");
		}

	}
	
	public String getValuebykey(String responseBody, String key) {
		String value = "";
		JSONParser parser = new JSONParser(); 
		try {
			JSONObject bodyOjbect = (JSONObject) parser.parse(responseBody);
			value = bodyOjbect.get(key).toString();
		} catch (ParseException e) {
			System.out.println("Convert fail");
		}
		
		return value;
	}

}
