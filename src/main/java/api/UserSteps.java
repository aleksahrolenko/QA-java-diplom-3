package api;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_ACCEPTED;
import static org.hamcrest.CoreMatchers.equalTo;

public class UserSteps {

    private static final String CREATION_ENDPOINT = "/api/auth/register";
    private static final String LOGIN_ENDPOINT = "/api/auth/login";
    private static final String USER_GET_UPDATE_DELETE_ENDPOINT = "/api/auth/user";

    @Step("Отправка POST запроса /api/auth/register")
    public static Response sendPostRequestUserCreation(Object json){
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(json)
                .post(CREATION_ENDPOINT);
    }

    @Step("Отправка POST запроса /api/auth/login")
    public static Response sendPostRequestUserLogin(Object json){
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(json)
                .post(LOGIN_ENDPOINT);
    }

    @Step("Отправка DELETE запроса /api/auth/user")
    public static void deleteUser(String accessToken) {
        given()
                .header("Authorization", accessToken)
                .delete(USER_GET_UPDATE_DELETE_ENDPOINT)
                .then()
                .statusCode(SC_ACCEPTED)
                .and()
                .body("success", equalTo(true))
                .body("message", equalTo("User successfully removed"));
    }
}
