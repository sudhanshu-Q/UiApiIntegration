package com.pwApiTest;

import com.integration.api.request.RequestService;
import com.integration.utilities.Utilities;
import com.microsoft.playwright.APIResponse;
import com.pwApiTest.responseValidator.ResponseValidations;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BasePwTest {

    private final static Logger log = Logger.getLogger(BasePwTest.class);

    @BeforeClass
    public void runBeforeTestApi(){
        RequestService requestService=new RequestService();
        APIResponse response= requestService.healthCheck(
                new Utilities().getPropertiesUrl("GET_BASE_URI"),
                new RequestService().commonHeaders(),
                new Utilities().getPropertiesConfigurations("USERNAME"),
                new Utilities().getPropertiesConfigurations("PASSWORD"),
                new Utilities().getPropertiesUrl("HEALTH_CHECK"));
        log.debug(response.text());
        new ResponseValidations().validateStatusCode(response,200);
        //new ResponseValidations().validateUrl(response,"http://localhost:8010/users");
        System.out.println("before Test");
    }

    @AfterClass
    public void runAfterSuiteApi(){
        System.out.println("After Test APi");

    }
}
