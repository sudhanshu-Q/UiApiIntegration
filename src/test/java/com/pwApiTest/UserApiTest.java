package com.pwApiTest;

import com.integration.api.request.RequestService;
import com.integration.utilities.Utilities;
import com.microsoft.playwright.APIResponse;
import com.pwApiTest.responseValidator.ResponseValidations;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UserApiTest {

    private final static Logger log = Logger.getLogger(UserApiTest.class);

    @BeforeTest
    public void runBeforeTestApi(){
        System.out.println("before Test");
    }

    @Test
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
    }

    @AfterTest
    public void runAfterSuiteApi(){
        System.out.println("After Test APi");

    }
}
