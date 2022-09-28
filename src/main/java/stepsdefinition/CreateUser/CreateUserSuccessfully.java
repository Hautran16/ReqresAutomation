package stepsdefinition.CreateUser;

import static org.testng.Assert.assertEquals;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

import common.ApiUtils;
import common.JsonUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateUserSuccessfully {

	String url = "";
	String method = "";
	String requestBodyName = "";
	int actualStatusCode ;

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
		String requestBody = jsonUtils.readJsonFile("/Users/mr.tuong/Dev/Automationtest/01Project/ReqresAutomationHau/src/main/resources/CreateUser/" + requestBodyName);
		
		HttpResponse<String> result = apiUtils.sendRequest(method, url, requestBody);
		System.out.println("result:  " + result);
		actualStatusCode = result.statusCode();
		String body = result.body();
	}

	@Then("Request reponse return {string} and responseBody {string} and {string}")
	public void request_reponse_return_and_response_body_and(String expectedStatusCode, String expectedJob, String ExpectedName) {
			assertEquals(actualStatusCode, Integer.parseInt(expectedStatusCode));
	}

}
