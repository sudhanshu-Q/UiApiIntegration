package com.pwApiTest;

import com.integration.api.request.RequestService;
import com.integration.utilities.Utilities;
import com.microsoft.playwright.APIResponse;
import com.pwApiTest.responseValidator.ResponseValidations;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.util.Map;

public class UriVersioningApiTest extends BasePwTest{

    private final static Logger log = Logger.getLogger(UriVersioningApiTest.class);
    private final static String BASE_URI=new Utilities().getPropertiesUrl("GET_BASE_URI");
    private final static String API_USERNAME=new Utilities().getPropertiesConfigurations("USERNAME");
    private final static String API_PASSWORD=new Utilities().getPropertiesConfigurations("PASSWORD");
    private final static Map<String, String> GET_HEADERS_COMMON=new RequestService().commonHeaders();
    private final static RequestService requestService=new RequestService();

    @Test(priority = 1)
    public void get_version1_test(){
        APIResponse response= requestService.get_Request(
                BASE_URI,
                GET_HEADERS_COMMON,
                API_USERNAME,
                API_PASSWORD,
                new Utilities().getPropertiesUrl("GET_URI_VERSIONING_1_API"));
        log.debug(response.text());
        new ResponseValidations().validateStatusCode(response,200);
        new ResponseValidations().validateUrl(response,BASE_URI+new Utilities().getPropertiesUrl("GET_URI_VERSIONING_1_API"));
    }

    @Test(priority = 2)
    public void get_version2_test(){
        APIResponse response= requestService.get_Request(
                BASE_URI,
                GET_HEADERS_COMMON,
                API_USERNAME,
                API_PASSWORD,
                new Utilities().getPropertiesUrl("GET_URI_VERSIONING_2_API"));
        log.debug(response.text());
        new ResponseValidations().validateStatusCode(response,200);
        new ResponseValidations().validateUrl(response,BASE_URI+new Utilities().getPropertiesUrl("GET_URI_VERSIONING_2_API"));
    }
}
