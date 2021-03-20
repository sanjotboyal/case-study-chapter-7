package com.bluewave.customerapi.AccountManagement;

import com.google.cloud.functions.HttpFunction;
import com.google.cloud.functions.HttpRequest;
import com.google.cloud.functions.HttpResponse;
import java.io.IOException;
import java.io.BufferedWriter;

import static spark.Spark.get;
 
import spark.Request;
import spark.Response;
import spark.Route;

public class Main implements HttpFunction {
	
	/* Implemented Google Cloud Functions */
	@Override
	public void service(HttpRequest request, HttpResponse response) throws IOException {

		/* Spark HTTP framework doesn't work with google cloud functions */
		// get(new Route("/accounts/1001") {
		// 	@Override
		// 	public Object handle(Request request, Response response) {
		// 		return  "Account: number=1001, name=John Doe, email=johndoe@gmail.com";
		// 	}
		// });
		
		
		// get(new Route("/accounts/1002") {
		// 	@Override
		// 	public Object handle(Request request, Response response) {
		// 		return  "Account: number=1002, name=Jane Smith, email=janesmith@gmail.com";
		// 	}
		// });

		// writing http responses 
		BufferedWriter writer = response.getWriter();

		String route = request.getPath();

		// handling different routes based on account id 
		switch(route) {
			case "/1001":
				writer.write("Account: number=1001, name=John Doe, email=johndoe@gmail.com");
				break;
			case "/1002":
				writer.write("Account: number=1002, name=Jane Smith, email=janesmith@gmail.com");
				break;
			default: 
				writer.write("Invalid account ID");
				break;
		}
	}
}
