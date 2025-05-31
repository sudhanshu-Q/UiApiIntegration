package com.pwApiTest;

import com.integration.api.baseTest.BaseTest;
import com.integration.api.request.CreateUserRequestPayload;
import com.integration.api.request.RequestPayload;
import com.integration.api.request.RequestService;
import com.integration.utilities.Utilities;
import com.microsoft.playwright.APIResponse;
import com.pwApiTest.responseValidator.ResponseValidations;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class UserApiTest {

    private final static Logger log = Logger.getLogger(UserApiTest.class);
    private Integer id=5;
    private String name="new test";
    private LocalDate birthdate=LocalDate.of(1994,06,11);

    @BeforeTest
    public void runBeforeTestApi(){

        System.out.println("before Test");
    }

    @Test(priority = 1)
    public void getUserTest_01(){
        RequestService requestService=new RequestService();
        APIResponse response= requestService.get_Request(
                new Utilities().getPropertiesUrl("GET_BASE_URI"),
                new RequestService().commonHeaders(),
                new Utilities().getPropertiesConfigurations("USERNAME"),
                new Utilities().getPropertiesConfigurations("PASSWORD"),
                new Utilities().getPropertiesUrl("GET_USER_API"));
        log.debug(response.text());
        new ResponseValidations().validateStatusCode(response,200);
        new ResponseValidations().validateUrl(response,"http://localhost:8010/users");
    }

    @Test(priority = 2)
    public void createUser_01(){
        CreateUserRequestPayload createUserRequestPayload=
                new CreateUserRequestPayload(id,name,birthdate);
        RequestService requestService=new RequestService();
        APIResponse response= requestService.post_Request(
                new Utilities().getPropertiesUrl("GET_BASE_URI"),
                new RequestService().commonHeaders(),
                new Utilities().getPropertiesConfigurations("USERNAME"),
                new Utilities().getPropertiesConfigurations("PASSWORD"),
                new Utilities().getPropertiesUrl("POST_CREATE_USER_API"),
                RequestPayload.createNewUser(id,name,birthdate).toString());
        log.debug(response.text());
        new ResponseValidations().validateStatusCode(response,201);
        new ResponseValidations().validateUrl(response,"http://localhost:8010/users");
    }

    @Test(priority = 3)
    public void getUserTest_02(){
        RequestService requestService=new RequestService();
        APIResponse response= requestService.get_Request(
                new Utilities().getPropertiesUrl("GET_BASE_URI"),
                new RequestService().commonHeaders(),
                new Utilities().getPropertiesConfigurations("USERNAME"),
                new Utilities().getPropertiesConfigurations("PASSWORD"),
                new Utilities().getPropertiesUrl("GET_USER_API"));
        log.debug(response.text());
        new ResponseValidations().validateStatusCode(response,200);
        new ResponseValidations().validateUrl(response,"http://localhost:8010/users");
    }

    @Test(priority = 4)
    public void updateUser_01(){
        RequestService requestService=new RequestService();
        APIResponse response= requestService.put_Request(
                new Utilities().getPropertiesUrl("GET_BASE_URI"),
                new RequestService().commonHeaders(),
                new Utilities().getPropertiesConfigurations("USERNAME"),
                new Utilities().getPropertiesConfigurations("PASSWORD"),
                new Utilities().getPropertiesUrl("PUT_UPDATE_USER_API"),
                RequestPayload.updateCreatedUser("THGFDSEWD").toString(),id);
        log.debug(response.text());
        new ResponseValidations().validateStatusCode(response,200);
        new ResponseValidations().validateUrl(response,"http://localhost:8010/put/users/"+id);
    }

    @Test(priority = 5)
    public void deleteCreatedUser_01(){
        RequestService requestService=new RequestService();
        APIResponse response= requestService.delete_Request(
                new Utilities().getPropertiesUrl("GET_BASE_URI"),
                new RequestService().commonHeaders(),
                new Utilities().getPropertiesConfigurations("USERNAME"),
                new Utilities().getPropertiesConfigurations("PASSWORD"),
                new Utilities().getPropertiesUrl("DELETE_USER_API"),id);
        log.debug(response.text());
        new ResponseValidations().validateStatusCode(response,200);
        new ResponseValidations().validateUrl(response,"http://localhost:8010/users/"+id);
    }

    @AfterTest
    public void runAfterSuiteApi(){
        System.out.println("After Test APi");

    }
}
