package com.integration.api.request;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class RequestService {

    private final static Logger log = Logger.getLogger(RequestService.class);

    public APIResponse get_Request(String baseUri,
                                   Map<String, String> headers,
                                   String username, String password,
                                   String endpointUrl) {
        Playwright playwright = Playwright.create();
        APIRequestContext apiRequestContext = playwright.request().
                newContext(new APIRequest.NewContextOptions().
                        setBaseURL(baseUri).
                        setExtraHTTPHeaders(headers).
                        setHttpCredentials(username, password));
        APIResponse response = apiRequestContext.get(endpointUrl);
        log.debug(response.toString());
        return response;
    }

    public APIResponse post_Request(String baseUri,
                                    Map<String, String> headers,
                                    String username, String password,
                                    String endpointUrl, String requestPayload) {
        Playwright playwright = Playwright.create();
        APIRequestContext apiRequestContext = playwright.request().
                newContext(new APIRequest.NewContextOptions().
                        setBaseURL(baseUri).
                        setExtraHTTPHeaders(headers).
                        setHttpCredentials(username, password));
        APIResponse response = apiRequestContext.post(endpointUrl,
                RequestOptions.create().setData(requestPayload));
        log.debug(response.toString());
        return response;
    }

    public APIResponse put_Request(String baseUri,
                                   Map<String, String> headers,
                                   String username,
                                   String password,
                                   String endpointUrl,
                                   String requestPayload, Integer id) {
        Playwright playwright = Playwright.create();
        APIRequestContext apiRequestContext = playwright.request().
                newContext(new APIRequest.NewContextOptions().
                        setBaseURL(baseUri).
                        setExtraHTTPHeaders(headers).
                        setHttpCredentials(username, password));
        APIResponse response = apiRequestContext.put(endpointUrl+"/"+id,
                RequestOptions.create().setData(requestPayload));
        log.debug(response.toString());
        return response;
    }


    public APIResponse delete_Request(String baseUri,
                               Map<String, String> headers,
                               String username,
                               String password,
                               String endpointUrl, Integer id) {
        Playwright playwright = Playwright.create();
        APIRequestContext apiRequestContext = playwright.request().
                newContext(new APIRequest.NewContextOptions().
                        setBaseURL(baseUri).
                        setExtraHTTPHeaders(headers).
                        setHttpCredentials(username, password));
        APIResponse response = apiRequestContext.delete(endpointUrl+"/"+id,
                RequestOptions.create());
        log.debug(response.toString());
        return response;
    }

    public Map<String, String> commonHeaders(){
        Map<String, String> headers = new HashMap<>();
        headers.put("content-type", "application/json");
        log.debug(headers);
        return headers;
    }
}
