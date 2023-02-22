package restassured;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class localhost3000 {
	public String URL1="http://localhost:3000/users";
	public String URL2="http://localhost:3000/jobrole";
	
	@Test(enabled=false)
	public  void vscode() {
		baseURI="http://localhost:3000/users";
		RequestSpecification request = given(); 
		JSONObject js=new JSONObject();
		js.put("firstname","Pavi");  //put is the method of json object
		js.put("last_name", "naik");
		given().body(js.toJSONString()).when().put("/users/4").then().log().all();
		Response response = request.put("/User"); 
	    ResponseBody body = response.getBody();
	    System.out.println(response.getStatusLine());
	    System.out.println(body.asString());
	}
	
	
}
