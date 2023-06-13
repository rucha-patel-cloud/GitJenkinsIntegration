import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.example.AddPlacePayload;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class TestFile {
    String place_id;

    @Test (priority = 1)
    public void addPlace(){

        RestAssured.baseURI="https://rahulshettyacademy.com";
        String res=given().queryParam("key","qaclick123").contentType("application/json")
                .body(AddPlacePayload.aPPayload())
                .when().post("maps/api/place/add/json")
                .then().log().all().assertThat().statusCode(200).body("status",equalTo("OK")).extract().response().asString();
        System.out.println("=============="+res);
        JsonPath js = new JsonPath(res);
        place_id=js.getString("place_id");
        System.out.println(place_id);

    }


    @Test (priority = 2)
    public void getPlace(){

        RestAssured.baseURI="https://rahulshettyacademy.com";
        given().log().all().queryParam("key","qaclick123").queryParam(place_id).contentType("application/json")
                .when().get("/maps/api/place/get/json")
                .then().log().all().assertThat().statusCode(200);
    }

    @Test (priority = 3)
    public void deletePlace()
    {
        RestAssured.baseURI="https://rahulshettyacademy.com";
        given().log().all().queryParam("key","qaclick123").contentType("application/json")
                .body("{\n" +
                        "\n" +
                        "    \"place_id\":\""+place_id+"\"\n" +
                        "}")
                .when().delete("/maps/api/place/delete/json")
                .then().log().all().assertThat().statusCode(200);
    }




}
