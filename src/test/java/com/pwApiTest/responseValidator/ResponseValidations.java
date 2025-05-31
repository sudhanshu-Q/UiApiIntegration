package com.pwApiTest.responseValidator;

import com.microsoft.playwright.APIResponse;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import java.util.Map;

public class ResponseValidations {

    private final static Logger log = Logger.getLogger(ResponseValidations.class);

    public void validateStatusCode(APIResponse response,int expectedStatusCode){
        int getStatusCode=response.status();
        try {
            Assert.assertEquals(getStatusCode, expectedStatusCode);
            if (getStatusCode == expectedStatusCode) {
                log.debug("Status Code is : " + getStatusCode + " and expected status code is : " + expectedStatusCode);

            } else {
                log.error("Status Code not Matched");
            }
        } catch (Exception e) {
            log.error("Status Code not Matched"+e.getMessage());
        }

    }

    public void validateUrl(APIResponse response,String matchUrl) {
        String getUrl = response.url();
        log.debug("URL : " + getUrl);
        if (matchUrl.equalsIgnoreCase(getUrl)) {
            log.debug("URL MATCHED : " + getUrl);

        } else {
            log.error("NOT");
        }

    }
//    public void validateHeaders(APIResponse response,Map<String,String> matchHeader){
//        Map<String,String> getHeaders=response.headers();
//        Map<String,String> headersToMatch=matchHeader;
//        log.debug(getHeaders);
//        if(getHeaders.containsKey(matchHeader)){
//            log.debug("Matched");
//        }
//        else {
//            log.error("Not Matched");
//        }
//    }
}
