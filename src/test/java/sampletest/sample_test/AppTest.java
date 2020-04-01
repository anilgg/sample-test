package sampletest.sample_test;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class AppTest
{
    App app = new App(); 
    @Test(priority=0)
    void checkCapitalCodeForValidData() throws ParseException
    {
    	Response response = app.getCapitalcityByCode("CA");
    	int statusCode = response.getStatusCode();
    	System.out.println(statusCode);
    	Assert.assertEquals(statusCode, 200);
    }
    
    @Test(priority=1)
    void checkCapitalCodeForInvalidData() throws ParseException
    {
    	Response response = app.getCapitalcityByCode("123");
    	int statusCode = response.getStatusCode();
    	System.out.println(statusCode);
    	Assert.assertEquals(statusCode, 404);
    }
    
    @Test(priority=2)
    void checkCapitalCodeForEmptyData() throws ParseException
    {
    	Response response = app.getCapitalcityByCode("");
    	int statusCode = response.getStatusCode();
    	System.out.println(statusCode);
    	Assert.assertEquals(statusCode, 400);
    }
    
    @Test(priority=3)
    void checkCapitalNameForValidData() throws ParseException
    {
    	Response response = app.getCapitalcityByName("canada");
    	int statusCode = response.getStatusCode();
    	System.out.println(statusCode);
    	Assert.assertEquals(statusCode, 200);
    }
    
    @Test(priority=4)
    void checkCapitalNameForInvalidData() throws ParseException
    {
    	Response response = app.getCapitalcityByInvalidName("abcxyz");
    	int statusCode = response.getStatusCode();
    	System.out.println(statusCode);
    	Assert.assertEquals(statusCode, 404);
    }
    
    @Test(priority=5)
    void checkCapitalNameForEmptyData() throws ParseException
    {
    	Response response = app.getCapitalcityByInvalidName("");
    	int statusCode = response.getStatusCode();
    	System.out.println(statusCode);
    	Assert.assertEquals(statusCode, 404);
    }
   
}
