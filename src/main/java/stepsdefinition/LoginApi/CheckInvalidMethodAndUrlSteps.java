package stepsdefinition.LoginApi;

import static org.testng.Assert.assertEquals;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import common.ApiUtils;
import common.Response;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckInvalidMethodAndUrlSteps {
	String url, method;
	int actualStatusCode;
	String actualErrorMesage ;

	@Given("I have {string} and {string}")
	public void i_have_and(String givenUrl, String givenMethod) {
		url = givenUrl;
		method = givenMethod;
	}

	@When("I send the request")
	public void i_send_the_request() {
		ApiUtils apiUtils = new ApiUtils();
		String requestBody = "";
		HttpResponse<String> result = apiUtils.sendRequest(method, url, requestBody);
		actualStatusCode = result.statusCode();
		String body = result.body();
	}

	@Then("I validate the outcomes {string} and {string}")
	public void thenIValidateTheOutcomes(String expectedStatusCode, String expectedErrorMessage) {
		assertEquals(actualStatusCode, Integer.parseInt(expectedStatusCode));
		if (actualErrorMesage == null) {
			actualErrorMesage = "null";
		}
		assertEquals(actualErrorMesage, expectedErrorMessage);
	}
}