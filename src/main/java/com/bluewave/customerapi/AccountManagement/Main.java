package com.bluewave.customerapi.AccountManagement;

import com.google.cloud.functions.HttpFunction;
import com.google.cloud.functions.HttpRequest;
import com.google.cloud.functions.HttpResponse;
import java.io.IOException;

import static spark.Spark.get;
 
import spark.Request;
import spark.Response;
import spark.Route;

public class Main implements HttpFunction {
	// public static void main(String[] args) {
	// 	//		get(new Route("/Accounts/:id") {
	// }

	@Override
	public void service(HttpRequest request, HttpResponse response) throws IOException {
		get(new Route("/accounts/1001") {
			@Override
			public Object handle(Request request, Response response) {
				// return  "Account: number=1001, name=John Doe, email=johndoe@gmail.com";
				BufferedWriter writer = response.getWriter();
				writer.write("1001");
			}
		});
		
		
		get(new Route("/accounts/1002") {
			@Override
			public Object handle(Request request, Response response) {
				return  "Account: number=1002, name=Jane Smith, email=janesmith@gmail.com";
			}
		});
	}
}
