package APIRequest;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequest {

	public static void main(String[] args) {
		
		JSONObject json =new JSONObject();
		
		json.put("fname","Rohit");
		json.put("lname","Patel");
		json.put("mobile","787878787");
		json.put("address","Indore");
		
		String requestBody = json.toString();
		
		RestAssured.baseURI="https://reqres.in/api/users";
		   RequestSpecification httpReq =RestAssured.given();
		   
		   httpReq.header("Content-Type", "application/json");
		   httpReq.body(requestBody);
		   
		   Response resp =httpReq.post();
		   
		   System.out.println(resp.getStatusCode());
		   System.out.println(resp.getStatusLine());
		   System.out.println(resp.getTime());
		   Headers allHeader =resp.getHeaders();
		   
		   for(Header header : allHeader)
		   {
			   System.out.println(header.getName()+":"+header.getValue());
		   }
		   
		   System.out.println(resp.getBody().asPrettyString());
		   
		   

	}

}
