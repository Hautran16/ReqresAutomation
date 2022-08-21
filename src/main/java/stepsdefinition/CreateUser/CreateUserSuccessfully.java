package stepsdefinition.CreateUser;

import java.util.List;
import java.util.Map;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateUserSuccessfully {

	String url = "";
	String method = "";
	String requestBodyName = "";

@Given("I have Url and Method and RequestBodyName")

public void i_have_url_and_method_and_request_body_name(List<Map<String, String>> requestDatas) {
    for(Map<String, String> requestData : requestDatas) {
    	url = requestData.get("url");
    	method = requestData.get("method");
    	requestBodyName = requestData.get("requestBodyName");
    }
}

@Then("Request reponse return {string} and responseBody {string} and {string}")
public void request_reponse_return_and_response_body_and(String string, String string2, String string3, io.cucumber.datatable.DataTable dataTable) {
   
}
	
}
