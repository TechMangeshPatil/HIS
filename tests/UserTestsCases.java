package api.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPointer;
import api.payload.User;
import io.restassured.response.Response;


public class UserTestsCases {
	
	Faker fekar;
	User userPayload;
	
	@BeforeClass
	public void setUpData() {
		fekar=new Faker();
		userPayload=new User();
		
	userPayload.setId(fekar.idNumber().hashCode());
	userPayload.setFirstName(fekar.name().firstName());
	userPayload.setLastName(fekar.name().lastName());
	
	userPayload.setEmail(fekar.internet().safeEmailAddress());
	userPayload.setUsername(fekar.name().username());
	userPayload.setPassword(fekar.internet().password(5, 10));
	
	}
	@Test
	public void testPostReqUser() {
		           
		Response resp=UserEndPointer.createUser(userPayload);
		
		resp.then()
		.log().all();
		Assert.assertEquals(resp.getStatusCode(),200);
		
		
		
		
		
		
	}

}
