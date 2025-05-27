package com.integration.api.baseTest;

import com.microsoft.playwright.*;
import org.apache.log4j.Logger;
import org.testng.annotations.*;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {

    private final static Logger log = Logger.getLogger(BaseTest.class);

    @BeforeSuite
    public void runBeforeTestSuite () {
        log.info("Starting");
        System.out.println("starting..Suite");
    }

    @BeforeTest
    public void runBeforeTest () {
        System.out.println("starting..Test");
    }

    @BeforeClass
    public void runBeforeClass () {
        System.out.println("starting..class");
    }

    @BeforeGroups
    public void runBeforeGroup () {
        System.out.println("starting..group");
    }

    @BeforeMethod
    public void runBeforeMethod () {
        System.out.println("starting..method");
    }

    public APIResponse createSetup (String baseUri,HashMap<String,String> headers,String username,String password,String endpointUrl){

        String BaseURL=baseUri;
        Playwright playwright=Playwright.create();
        APIRequestContext apiRequestContext= playwright.request().
                newContext(new APIRequest.NewContextOptions().
                        setBaseURL(BaseURL).
                        setExtraHTTPHeaders(headers).
                        setHttpCredentials(username,password));
        APIResponse response = apiRequestContext.get(endpointUrl);
        log.debug(response.toString());
        System.out.println(response.status());
        return response;

    }

    @AfterMethod
    public void runAfterMethod () {
        System.out.println("Shutdown..method");
    }


    @AfterGroups
    public void runAfterGroup () {
        System.out.println("Shutdown..group");
    }

    @AfterClass
    public void runAfterClass () {
        System.out.println("Shutdown..class");
    }

    @AfterTest
    public void runAfterTest () {
        System.out.println("shutdown..Test");
    }

    @AfterSuite
    public void runAfterTestSuite () {
        log.info("Shutdown");
        System.out.println("shutdown..suite");
    }
}

