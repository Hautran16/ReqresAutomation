package stepsdefinition.LoginApi;

import static org.testng.Assert.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckInvalidMethodSteps {
	String url, method, requestBody = "";
	HttpResponse response = null;
	
	@Given("I have url {string} and invalid method {string}")
	public void giveHaveUrlAndMethod(String inputUrl, String inputMethod) {
		url = inputUrl;
		method = inputMethod;
	}
	
	@When("I send request with invaild metthod")
	public void sendTheRequest() {
		try {
			HttpRequest request = HttpRequest.newBuilder()
												.uri(new URI(url))
												.GET()
												.build();
			response = HttpClient.newHttpClient().send(request, BodyHandlers.ofString());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Send get request fail");
		}
		
	}
	
	@Then("The response return status code {int} success")
	public void the_response_return_status_code_200_success(int expectedStatusCode) {
		int actualStatusCode = response.statusCode();
		assertEquals(actualStatusCode, expectedStatusCode);
	}
}
