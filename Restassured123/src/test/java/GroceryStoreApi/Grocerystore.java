package GroceryStoreApi;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Grocerystore{
  @Test(enabled=false)
  public void Apistatus(){
	  given().get("https://simple-grocery-store-api.glitch.me/status\n").then().statusCode(200).log().all();
	}
  
  @Test(enabled=false)
  public void Getallproducts(){
	  given().get("https://simple-grocery-store-api.glitch.me/products\n").then().statusCode(200).log().all();
	}
  
  @Test(enabled=false)
  public void GetSingleproduct(){
	  given().head("https://simple-grocery-store-api.glitch.me/products/2585\n").then().statusCode(200).log().all();
	}
  
  @Test(enabled=false)
  public void CreateCart(){
	  
	  given().post("https://simple-grocery-store-api.glitch.me/carts").then().statusCode(201).log().all();
	}
  
  @Test(enabled=false)
  public void GetCart(){
	  
	  given().get("https://simple-grocery-store-api.glitch.me/carts/W9Wvs7YerDjGGtAa7cthk").then().statusCode(200).log().all();
	}
  @Test(enabled=false)
  public void AddItemtocart(){
	 /* JSONObject js=new JSONObject();
		js.put("productId","1535");  //put is the method of json object
	  given().post("https://simple-grocery-store-api.glitch.me/carts/W9Wvs7YerDjGGtAa7cthk/items").then().log().all();*/
	 given().queryParam("productId","4643").when().post("https://simple-grocery-store-api.glitch.me/carts/W9Wvs7YerDjGGtAa7cthk/items\n").then().extract().response();;
	 
}

  @Test(enabled=true)
  public void GetCartItems(){
	  
	  given().get("https://simple-grocery-store-api.glitch.me/carts/W9Wvs7YerDjGGtAa7cthk/items\n").then().statusCode(200).log().all();
	}
  
  @Test(enabled=false)
  public void Updatequantity(){
	  
	  given().patch("https://simple-grocery-store-api.glitch.me/carts/W9Wvs7YerDjGGtAa7cthk/items/:itemId\n").then().statusCode(200).log().all();
	}
  
}
 

