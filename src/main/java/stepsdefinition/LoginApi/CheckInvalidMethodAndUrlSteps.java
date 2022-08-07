package stepsdefinition.LoginApi;

import static org.testng.Assert.assertEquals;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckInvalidMethodAndUrlSteps {
	String url, method;
	int actualStatusCode;
	String actualErrorMesage;

	@Given("I have {string} and {string}")
	public void i_have_and(String givenUrl, String givenMethod) {
		url = givenUrl;
		method = givenMethod;
	}

	@When("I send the request")
	public void i_send_the_request() {
		HttpResponse<String> response = null;
		String requestBody = "";
		if (method.equals("GET")) {
			response = sendGetRequest();
		} else if ((method.equals("POST"))) {
			response = sendPostRequest(requestBody);
		}
		actualStatusCode = response.statusCode();
		String body = response.body();
	}

	@Then("I validate the outcomes {string} and {string}")
	public void thenIValidateTheOutcomes(String expectedStatusCode, String expectedErrorMessage) {
		assertEquals(actualStatusCode, Integer.parseInt(expectedStatusCode));
		if (actualErrorMesage == null) {
			actualErrorMesage = "null";
		}
		assertEquals(actualErrorMesage, expectedErrorMessage);
	}

	public HttpResponse<String> sendPostRequest(String requestBody) {
		HttpResponse<String> response = null;
		try {
			HttpRequest request = HttpRequest.newBuilder().uri(new URI(url))
					.POST(HttpRequest.BodyPublishers.ofString(requestBody))
					.build();
			response = HttpClient.newHttpClient().send(request, BodyHandlers.ofString());
			actualStatusCode = response.statusCode();
			 String body = response.body();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Send request fail");
		}
		return response;
	}

	public HttpResponse<String> sendGetRequest() {
		HttpResponse<String> response = null;
		try {
			HttpRequest request = HttpRequest.newBuilder().uri(new URI(url)).GET().build();
			response = HttpClient.newHttpClient().send(request, BodyHandlers.ofString());
			actualStatusCode = response.statusCode();
			 String body = response.body();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Send get request fail");
		}
		return response;
	}

}
