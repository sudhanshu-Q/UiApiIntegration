package com.integration.api.request;

import com.integration.api.baseTest.BaseTest;
import org.apache.log4j.Logger;

import java.time.LocalDate;

public class RequestPayload {

    private final static Logger log = Logger.getLogger(RequestPayload.class);


    public static String createNewUser(Integer id, String name, LocalDate birthdate) {
        String payloadUser=null;
        try{
            payloadUser = "{\n" +
                    "  \"id\": "+ id + ",\n" +
                    "  \"name\": \"" + name + "\",\r\n" +
                    "  \"birthDate\": \"" + birthdate + "\"\r\n" +
                    "}";
            log.debug(payloadUser);
        } catch (Exception e) {
            log.error("ERROR FOR CREATE USER REQUEST PAYLOAD : "+e.getMessage());
        }
        return payloadUser;
    }

    public static String updateCreatedUser(String name) {
        String payloadUserUpdate=null;
        try{
            payloadUserUpdate = "{\n" +
                    "  \"name\": \"" + name + "\"\r\n" +
                    "}";
            log.debug(payloadUserUpdate);
        } catch (Exception e) {
            log.error("ERROR FOR UPDATE USER REQUEST PAYLOAD : "+e.getMessage());
        }
        return payloadUserUpdate;
    }


}
