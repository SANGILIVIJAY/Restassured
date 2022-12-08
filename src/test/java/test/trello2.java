package test;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class trello2 {
	public static String baseurl="https://api.trello.com";
	public String id;
	@Test()
	public void createBoard()
	{
		RestAssured.baseURI=baseurl;
	Response response=given().queryParam("name", "sushant")
		.queryParam("key", "01714c1f8016517240b4401e23f6a1a1")
		.queryParam("token", "26b1277bbffa6701a55d20438838ea958a3d493d5e92d46e7bcb83894ab16ec4")
		.header("Content-Type", "application/json")
		.when()
		.post("/1/boards/")
		.then()
		.assertThat().statusCode(200).contentType(ContentType.JSON)
		.extract().response();
		String jsonresponse = response.asString();
		JsonPath js= new JsonPath(jsonresponse);
		
		id = js.get("id");
		System.out.println(id);		
	}
	
	}



