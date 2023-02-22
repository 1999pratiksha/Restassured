package restassured;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

public class trellodemo {
	public String url="https://trello.com";
	public String id;
	//@Test(enabled=false)
	public void get_boards() { //getiing the boards 
		
		Response response=given().queryParam("key", "aa38741c9070e0f822ff0dbf5b55b3ec")
				.queryParam("token", "ATTA682ce80a3e906c5e740faef11e28767d17277375f46d155d06bb6728636b5e2bA1C2C1AD")
				.header("content-Type","application/json").when()
				.get("https://trello.com/b/KlqVVzMQ/first-project-test-scenarios").then().extract().response();
		        System.out.println(response.getBody());
}
	
	
	@Test
	public void create_boards() {//create the boards 
		baseURI=url;
		Response response1=given().queryParam("name","trello_api").queryParam("key", "aa38741c9070e0f822ff0dbf5b55b3ec")
		.queryParam("token", "ATTA682ce80a3e906c5e740faef11e28767d17277375f46d155d06bb6728636b5e2bA1C2C1AD")
		.header("content-Type","application/json").when().post("/1/boards/").then().extract().response();
		JsonPath js=new JsonPath(response1.asString());//getting the id for deletion
		 id=js.get("id");
		System.out.println(id);
		System.out.println(response1.toString());
		
	}
	//@Test
	public void delete_boards() { //deleting the board
		Response response2=given().queryParam("key", "aa38741c9070e0f822ff0dbf5b55b3ec")
				.queryParam("token", "ATTA682ce80a3e906c5e740faef11e28767d17277375f46d155d06bb6728636b5e2bA1C2C1AD")
				.header("content-Type","application/json").when().delete("/1/boards/"+id).then().extract().response();
		
	}
	
	@Test
	public void update_boards() { //update the board
		        baseURI=url;
		        // This code sample uses the  'Unirest' library:
		        // http://unirest.io/java.html
		        Response  response4 = given().queryParam("name","Rest_api")
		        .queryParam("key", "aa38741c9070e0f822ff0dbf5b55b3ec")
		        .queryParam("token", "ATTA682ce80a3e906c5e740faef11e28767d17277375f46d155d06bb6728636b5e2bA1C2C1AD")
		        .put("/1/boards/"+id).then().extract().response();
		         System.out.println(response4.getBody());
		        		 	}
	}	

