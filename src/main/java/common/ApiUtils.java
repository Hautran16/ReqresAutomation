package common;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ApiUtils {
	
	public enum Method{POST,GET};
	
	public Response<Integer, String> sendRequest(String method, String url, String requestBody) {
		HttpResponse<String> response = null;
		Response<Integer, String> result = null;
		
		if(method.equals(Method.POST)) {
			response = sendPostRequest(requestBody, url);
			result.setStatusCode(response.statusCode());
			result.setResponseBody(response.body());
		} else if(method.equals(Method.GET)) {
			response = sendGetRequest(url);
			result.setStatusCode(response.statusCode());
			result.setResponseBody(response.body());
		}
		
		return result;
	}
	
	public HttpResponse<String> sendPostRequest(String requestBody, String url) {
		HttpResponse<String> response = null;
		try {
			HttpRequest request = HttpRequest.newBuilder().uri(new URI(url))
					.POST(HttpRequest.BodyPublishers.ofString(requestBody))
					.build();
			response = HttpClient.newHttpClient().send(request, BodyHandlers.ofString());
			//actualStatusCode = response.statusCode();
			 //String body = response.body();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Send request fail");
		}
		return response;
	}

	public HttpResponse<String> sendGetRequest(String url) {
		HttpResponse<String> response = null;
		try {
			HttpRequest request = HttpRequest.newBuilder().uri(new URI(url)).GET().build();
			response = HttpClient.newHttpClient().send(request, BodyHandlers.ofString());
			//actualStatusCode = response.statusCode();
			// String body = response.body();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Send get request fail");
		}
		return response;
	}

	
}