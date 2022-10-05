package common;

public class Response<Integer, String> {
	private int statusCode;

	private String responseBody;
	
	public Response(int statusCode, String responseBody) {
		
		this.statusCode = statusCode;
		this.responseBody = responseBody;
	}
	
	public int getStatusCode(int statusCode) {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(String responseBody) {
		this.responseBody = responseBody;
	}
	
	
}
