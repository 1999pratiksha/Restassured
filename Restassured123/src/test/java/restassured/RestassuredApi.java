package restassured;


import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class RestassuredApi {
	public String URL="https://reqres.in/api/users?page=2";
	public String URL1="http://localhost:3000/users";
	
	@Test(enabled=false)
	public void Listuser1() {
		Response rep=get(URL);//getting the url and storing it in response
	    int status_code=rep.statusCode();
	    Assert.assertEquals(status_code, 200);//assertions in statuscode
	    System.out.println(rep.asString());//getting the results in string
	    System.out.println(rep.getBody());
		
	}
	@Test(enabled=false)
	public void Listusers2() {
		given().get(URL).then().statusCode(200).body("data.first_name",hasItems("Michael"));//given get the url and perform the operations with one line we can make the assertion
		//.body will go inside the data and checking for firstname as "michel" or not
		//given().get(URL).then().statusCode(200).body("data.id[0]",equalTo(7)).log().all();//check the index value 0 has the id of 7 or not
		given().get(URL).then().statusCode(200).body("data.id",equalTo(37));//checking id of 37 but it will show 37 is not present #by removing index value[] in the code
		
	}
	@Test(enabled=true)
	public void Singleuser() {
		given().get("https://reqres.in/api/users/2").then().statusCode(200).body("data.id",equalTo(2)).log().all();
	}
	@Test (enabled = false)
	public void SINGLE_USER_NOT_FOUND() {
		given().get("https://reqres.in/api/users/23").then().statusCode(404);
	}
	@Test (enabled = false)
	public void LIST_RESOURCE() {
		given().get("https://reqres.in/api/unknown").then().statusCode(200).log().all();
	}
	@Test (enabled = false)
	public void SINGLE_RESOURCE() {
		
		given().get("https://reqres.in/api/unknown/2").then().statusCode(200).log().all();
	}
	@Test (enabled = true)
	public void SINGLE_RESOURCE_NotFound() {
		given().get("https://reqres.in/api/unknown/23").then().statusCode(404).log().all();
	}
	
@Test(enabled=false)
public void Created() {
	JSONObject js=new JSONObject();
	js.put("name","Prati");  //put is the method of json object
	js.put("job", "QA");
	given().body(js.toJSONString()).when().post("https://reqres.in/api/users").then().statusCode(201).log().all();
	//System.out.println(js.toJSONString());//converting it to a json string
	
}
@Test(enabled=false)
public void Update() {
	JSONObject js=new JSONObject();
	js.put("name","Prati");  //put is the method of json object
	js.put("job", "QA analyst");
	given().body(js.toJSONString()).when().post("https://reqres.in/api/users/2").then().statusCode(201).log().all();
}
@Test(enabled=false)
public void Delete() {
	given().delete("https://reqres.in/api/users/2").then().statusCode(204).log().all();
	//in the url only mentioned it will delete the 2nd records
}

@Test (enabled = false)
public void REGISTER_SUCCESSFUL() {
	JSONObject js = new JSONObject();
	js.put("email", "eve.holt@reqres.in");
	js.put("password", "pistol");
	given().body(js.toJSONString()).when().post("https://reqres.in/api/register").then().statusCode(200).log().all();
}

@Test (enabled = true)
public void DELAYED_RESPONSE() {
	given().get("https://reqres.in/api/users?delay=3").then().statusCode(200).log().all();
}

@Test(enabled=false)
   public void testcase6()
   {   
	//given().get(URL1).then().statusCode(200).body(js.toJSONString());
	Response Json = given() .get(URL1);
    JsonPath path  = Json.jsonPath();
    path.getList(".");
    path.prettyPrint();
}
}

