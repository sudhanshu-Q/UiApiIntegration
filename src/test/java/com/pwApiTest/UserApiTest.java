package com.pwApiTest;

import com.integration.api.request.RequestPayload;
import com.integration.api.request.RequestService;
import com.integration.utilities.Utilities;
import com.microsoft.playwright.APIResponse;
import com.pwApiTest.responseValidator.ResponseValidations;
import org.apache.log4j.Logger;
import org.testng.annotations.*;
import java.time.LocalDate;
import java.util.Map;

public class UserApiTest extends BasePwTest{

    private final static Logger log = Logger.getLogger(UserApiTest.class);
    private final static String BASE_URI=new Utilities().getPropertiesUrl("GET_BASE_URI");
    private final static String API_USERNAME=new Utilities().getPropertiesConfigurations("USERNAME");
    private final static String API_PASSWORD=new Utilities().getPropertiesConfigurations("PASSWORD");
    private final static Map<String, String> GET_HEADERS_COMMON=new RequestService().commonHeaders();
    private final static RequestService requestService=new RequestService();
    private final static Integer id=5;
    private final static String name="new test";
    private final static LocalDate birthdate=LocalDate.of(1994,06,11);

    @Test(priority = 1)
    public void getUserTest_01(){
        APIResponse response= requestService.get_Request(
                BASE_URI,
                GET_HEADERS_COMMON,
                API_USERNAME,
                API_PASSWORD,
                new Utilities().getPropertiesUrl("GET_USER_API"));
        log.debug(response.text());
        new ResponseValidations().validateStatusCode(response,200);
        new ResponseValidations().validateUrl(response,"http://localhost:8010/users");
    }

    @Test(priority = 2)
    public void createUser_01(){
        APIResponse response= requestService.post_Request(
                BASE_URI,
                GET_HEADERS_COMMON,
                API_USERNAME,
                API_PASSWORD,
                new Utilities().getPropertiesUrl("POST_CREATE_USER_API"),
                RequestPayload.createNewUser(id,name,birthdate).toString());
        log.debug(response.text());
        new ResponseValidations().validateStatusCode(response,201);
        new ResponseValidations().validateUrl(response,"http://localhost:8010/users");
    }

    @Test(priority = 3)
    public void getUserTest_02(){
        APIResponse response= requestService.get_Request(
                BASE_URI,
                GET_HEADERS_COMMON,
                API_USERNAME,
                API_PASSWORD,
                new Utilities().getPropertiesUrl("GET_USER_API"));
        log.debug(response.text());
        new ResponseValidations().validateStatusCode(response,200);
        new ResponseValidations().validateUrl(response,"http://localhost:8010/users");
    }

    @Test(priority = 4)
    public void updateUser_01(){
        int getId=id-1;
        APIResponse response= requestService.put_Request(
                BASE_URI,
                GET_HEADERS_COMMON,
                API_USERNAME,
                API_PASSWORD,
                new Utilities().getPropertiesUrl("PUT_UPDATE_USER_API"),
                RequestPayload.updateCreatedUser("NEW NAME").toString(),getId);
        log.debug(response.text());
        new ResponseValidations().validateStatusCode(response,200);
        new ResponseValidations().validateUrl(response,"http://localhost:8010/put/users/"+getId);
    }

    @Test(priority = 5)
    public void deleteCreatedUser_01(){
        APIResponse response= requestService.delete_Request(
                BASE_URI,
                GET_HEADERS_COMMON,
                API_USERNAME,
                API_PASSWORD,
                new Utilities().getPropertiesUrl("DELETE_USER_API"),id);
        log.debug(response.text());
        new ResponseValidations().validateStatusCode(response,200);
        new ResponseValidations().validateUrl(response,"http://localhost:8010/users/"+id);
    }

    @Test(priority = 6)
    public void getUserTestWithLink_03(){
        APIResponse response= requestService.get_Request(
                BASE_URI,
                GET_HEADERS_COMMON,
                API_USERNAME,
                API_PASSWORD,
                new Utilities().getPropertiesUrl("GET_USER_API_LINK")+2);
        log.debug(response.text());
        new ResponseValidations().validateStatusCode(response,200);
        new ResponseValidations().validateUrl(response,BASE_URI+new Utilities().getPropertiesUrl("GET_USER_API_LINK")+2);
    }
}
