package com.pwApiTest.responseValidator;

import com.microsoft.playwright.APIResponse;
import org.apache.log4j.Logger;

public class ResponseValidations {

    private final static Logger log = Logger.getLogger(ResponseValidations.class);

    public void validateStatusCode(APIResponse response,int statusCode){
        int getStatusCode=response.status();
        if(getStatusCode==statusCode){
            log.debug("Status Code is : "+getStatusCode +" and expected status code is : "+statusCode);
        }
        else {
            log.error("Status Code not Matched");
        }
    }
}
