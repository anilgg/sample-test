package sampletest.sample_test;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class App 
{
	Response getCapitalcityByCode(String code) throws ParseException {

        RestAssured.baseURI = "https://restcountries.eu/rest/v2/alpha/";
        //Define the specification of request. Server is specified by URI above.
        RequestSpecification httpRequest = RestAssured.given(); 
        //Makes calls to the server using Method type.
        Response response = httpRequest.request(Method.GET,"{code}",code);
        JSONParser parse = new JSONParser();
        JSONObject jobj = (JSONObject)parse.parse(response.getBody().asString());
        System.out.println(jobj.get("capital"));
        return response;
    }
  
    Response getCapitalcityByName(String name) throws ParseException {

        RestAssured.baseURI = "https://restcountries.eu/rest/v2/name/"; 
        //Define the specification of request. Server is specified by baseURI above.
        RequestSpecification httpRequest = RestAssured.given();
 
        //Makes calls to the server using Method type.
        Response response = httpRequest.request(Method.GET,"{country}",name);
        JSONParser parse = new JSONParser();
        JSONArray jobj = (JSONArray)parse.parse(response.getBody().asString());
        for(int i=0;i<jobj.size();i++) {
        	JSONObject obj = (JSONObject) jobj.get(i);
        	System.out.println(obj.get("capital"));
        }
        return response;
    }
    
    Response getCapitalcityByInvalidName(String name) throws ParseException {

        RestAssured.baseURI = "https://restcountries.eu/rest/v2/name/"; 
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET,"{country}",name);
        return response;
    }
}
