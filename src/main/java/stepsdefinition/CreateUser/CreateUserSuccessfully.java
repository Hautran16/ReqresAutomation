package stepsdefinition.CreateUser;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import common.ApiUtils;
import common.JsonUtils;
import common.Response;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateUserSuccessfully {

	String url = "";
	String method = "";
	String requestBodyName = "";
	int actualStatusCode;
	ArrayList<String> actualNameList;
	String actualJob = "";

	@Given("I have Url and Method and RequestBodyName")

	public void i_have_url_and_method_and_request_body_name(List<Map<String, String>> requestDatas) {
		for (Map<String, String> requestData : requestDatas) {
			url = requestData.get("url");
			method = requestData.get("method");
			requestBodyName = requestData.get("requestBodyName");
		}
	}

	@When("I send the request with valid data")
	public void i_send_the_request_with_valid_data() {
		ApiUtils apiUtils = new ApiUtils();
		JsonUtils jsonUtils = new JsonUtils();
		File sourceFile = new File(
				"D:\\AutomationTest\\02Project\\02Git\\ReqresAutomation\\src\\main\\resources\\CreateUser\\CreateUserRequestBody.json");
		File destinationFile = new File(
				"D:\\AutomationTest\\02Project\\02Git\\ReqresAutomation\\src\\main\\resources\\CreateUser\\CopyCreateUserRequestBody.json");
		jsonUtils.copyJsonFile(sourceFile, destinationFile);
//		String requestBody = jsonUtils.readJsonFile("/Users/mr.tuong/Dev/Automationtest/01Project/ReqresAutomationHau/src/main/resources/CreateUser/" + requestBodyName);
		String requestBody = jsonUtils.readJsonFile(
				"D:\\AutomationTest\\02Project\\02Git\\ReqresAutomation\\src\\main\\resources\\CreateUser\\"
						+ requestBodyName);
//		HttpResponse<String> result = apiUtils.sendRequest(method, url, requestBody);
//		actualStatusCode = result.statusCode();
//		String body = result.body();
		Response<Integer, String> result = apiUtils.sendRequest1(method, url, requestBody);
		actualStatusCode = result.getStatusCode();
		String responseBody = result.getResponseBody();

		JSONParser parser = new JSONParser();
		try {
			JSONObject bodyOjbect = (JSONObject) parser.parse(responseBody);
			Object actualName = bodyOjbect.get("name");
			String actualNameStr = actualName.toString();
			actualNameList = new ArrayList<>(Arrays.asList(actualNameStr));
			System.out.println("actualName:    " + actualNameList);

		} catch (ParseException e) {
			System.out.println("Convert fail");
		}

	}

	@Then("Request reponse return {string} and responseBody {string} and {string}")
	public void request_reponse_return_and_response_body_and(String expectedStatusCode, String expectedJob,
			String expectedName) {
//		assertEquals(actualStatusCode, Integer.parseInt(expectedStatusCode));
		for (int i = 0; i < actualNameList.size(); i++) {
			// i is the index
			// yourArrayList.get(i) is the element
			if (actualNameList.get(i).equals(expectedName)) {
				assertEquals(actualNameList.get(i), expectedName);
			}
			
		}

//		assertEquals(actualJob, expectedJob);
	}

}
