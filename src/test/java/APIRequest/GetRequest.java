package APIRequest;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class GetRequest {

	@Test
	public void abc()
	{
		
		RestAssured.baseURI ="https://reqres.in/api/users/2";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		Response resp =httpRequest.get();
		
		ValidatableResponse validateResp=resp.then();
		validateResp.body("data.email",Matchers.equalTo("janet.weaver@reqres.in"));
		
		int a =resp.getStatusCode();
		System.out.println(a);
		
		String b = resp.getStatusLine();
		System.out.println(b);
		System.out.println(resp.getHeader("content-Type"));
		String c =resp.getBody().asPrettyString();
		System.out.println(c);
		
		long d = resp.getTime();
		System.out.println(d);
		
		
		
		Headers allHeader =resp.getHeaders();
		
		for(Header all:allHeader)
		{
			System.out.println(all.getName()+" ::"+all.getValue());
		}
		
		System.out.println("------------------");
		validateResp.body("data.email",Matchers.equalTo("janet.weaver@reqres.in"));

	}

}
