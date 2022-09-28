package stepsdefinition.LoginApi;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

import common.CucumberUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckValidationOfSingleFieldSteps {

	String url, method, requestBodyName;
	HttpResponse<String> response ;

//	@Given("I have Url and Method and RequestBodyName")
	public void i_have_url_and_method_and_request_body_name(List<Map<String, String>> loginTable) {
		url = CucumberUtils.getValueByTableKey(loginTable, "url");
		method = CucumberUtils.getValueByTableKey(loginTable, "method");
		requestBodyName = CucumberUtils.getValueByTableKey(loginTable, "requestBodyName");

	}

	@When("I send the request {string} and  {string}")
	public void i_send_the_request_and(String fieldName, String value) {
		
	}

	@Then("Request reponse return {string} and {string}")
	public void request_reponse_return_and(String string, String string2) {

	}

	@When("I send the request {string} and  {string}{string}")
	public void i_send_the_request_and(String string, String string2, String string3) {

	}
}
