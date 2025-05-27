package com.integration.api.request;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class RequestService {

    private final static Logger log = Logger.getLogger(RequestService.class);
    String BaseURI;

    public APIResponse get_Request(String baseUri, Map<String,String> headers,String username,String password,String endpointUrl){
        String getBaseUri=baseUri;
        Playwright playwright=Playwright.create();
        APIRequestContext apiRequestContext= playwright.request().
                newContext(new APIRequest.NewContextOptions().
                        setBaseURL(getBaseUri).
                        setExtraHTTPHeaders(headers).
                        setHttpCredentials(username,password));
        APIResponse response = apiRequestContext.get(endpointUrl);
        log.debug(response.toString());
        System.out.println(response.status());
        return response;
    }

    public void post_Request(){

    }

    public void put_Request(){

    }

    public void delete_Request(){

    }

    public Map<String, String> commonHeaders(){
        Map<String, String> headers = new HashMap<>();
        headers.put("content-type", "application/json");
        log.debug(headers);
        return headers;
    }
}
