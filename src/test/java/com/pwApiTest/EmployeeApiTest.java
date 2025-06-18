package com.pwApiTest;

import com.integration.api.request.RequestPayload;
import com.integration.api.request.RequestService;
import com.integration.utilities.Utilities;
import com.microsoft.playwright.APIResponse;
import com.pwApiTest.responseValidator.ResponseValidations;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.util.Map;

public class EmployeeApiTest extends BasePwTest{

    private final static Logger log = Logger.getLogger(EmployeeApiTest.class);
    private final static String BASE_URI=new Utilities().getPropertiesUrl("GET_BASE_URI");
    private final static String API_USERNAME=new Utilities().getPropertiesConfigurations("USERNAME");
    private final static String API_PASSWORD=new Utilities().getPropertiesConfigurations("PASSWORD");
    private final static Map<String, String> GET_HEADERS_COMMON=new RequestService().commonHeaders();
    private final static String GET_EMPLOYEE_API_URL=new Utilities().getPropertiesUrl("GET_EMPLOYEE_API");
    private final static String ADD_EMPLOYEE_API_URL=new Utilities().getPropertiesUrl("ADD_EMPLOYEE_API");
    private final static RequestService requestService=new RequestService();

    @Test(priority = 1)
    public void getEmployeeTest_01()
    {
        APIResponse response= requestService.get_Request(
                BASE_URI,
                GET_HEADERS_COMMON,
                API_USERNAME,
                API_PASSWORD,
                GET_EMPLOYEE_API_URL);
        log.debug(response.text());
        new ResponseValidations().validateStatusCode(response,200);
        new ResponseValidations().validateUrl(response,BASE_URI+GET_EMPLOYEE_API_URL);
    }

    @Test(priority = 2)
    public void addEmployeeTest_01()
    {
        APIResponse response= requestService.post_Request(
                BASE_URI,
                GET_HEADERS_COMMON,
                API_USERNAME,
                API_PASSWORD,
                ADD_EMPLOYEE_API_URL,
                RequestPayload.createNewEmployee("SHUKLA",12400,33,2));
        log.debug(response.text());
        new ResponseValidations().validateStatusCode(response,200);
        new ResponseValidations().validateUrl(response,BASE_URI+ADD_EMPLOYEE_API_URL);
    }
}
