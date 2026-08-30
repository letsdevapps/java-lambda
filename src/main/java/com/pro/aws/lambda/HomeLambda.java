package com.pro.aws.lambda;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class HomeLambda implements RequestHandler<Map<String, Object>, String> {

	@Override
	public String handleRequest(Map<String, Object> input, Context context) {
//		return "----- Java AWS Lambda | Home | handleRequest -----";

		HttpClient client = HttpClient.newHttpClient();

		// HttpRequest request =
		// HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/api")).GET().build();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://172.17.0.1:8080/api")).GET().build();

		try {
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			return response.body();

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
