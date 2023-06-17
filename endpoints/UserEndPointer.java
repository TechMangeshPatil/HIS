package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPointer {

	// Created for perform Create,Read,Update,Delete the User Api

	public static Response createUser(User payload) {

		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).when().post(Rootes.post_url);
		return response;

	}

	public static Response readUser(User payload) {

		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).when().post(Rootes.get_url);
		return response;

	}

	public static Response putUser(String userName, User payload) {

		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON)
				.pathParam("username", userName).when().post(Rootes.put_url);
		return response;

	}

	public static Response deleteUser(String userName) {

		Response response = given().pathParam("username", userName).when().post(Rootes.delete_url);
		return response;

	}

}
