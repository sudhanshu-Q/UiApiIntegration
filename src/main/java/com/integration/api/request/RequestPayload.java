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

    public static String createNewEmployee( String name,Integer salary,
                                            Integer age,Integer id) {
        String payloadEmployee=null;
        try{
            payloadEmployee = "{\n" +
                    "  \"name\": "+ name + ",\n" +
                    "  \"salary\": \"" + salary + "\",\r\n" +
                    "  \"age\": \"" + age + "\",\r\n" +
                    "  \"id\": \"" + id + "\"\r\n" +
                    "}";
            log.debug(payloadEmployee);
        } catch (Exception e) {
            log.error("ERROR FOR CREATE EMPLOYEE REQUEST PAYLOAD : "+e.getMessage());
        }
        return payloadEmployee;
    }

}

