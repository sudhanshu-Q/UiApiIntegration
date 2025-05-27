package com.integration.utilities;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Utilities {

    private final static Logger log = Logger.getLogger(Utilities.class);
    private static final String PATH_URL_PROPERTIES = "\\src\\main\\resources\\Url.properties";
    private static final String PATH_CONFIGURATIONS_PROPERTIES = "\\src\\main\\resources\\Configurations.properties";
    private static final String PATH_OBJECT_REPOSITORY_PROPERTIES = "\\src\\main\\resources\\ObjectRepository.properties";

    public String getPropertiesUrl(String key){
        FileReader reader= null;
        try {
            File file =new File(System.getProperty("user.dir")+PATH_URL_PROPERTIES);
            log.debug(file.getAbsoluteFile());
            reader = new FileReader(file);
        } catch (FileNotFoundException e) {
            log.error("ERROR FOR URL PROPERTIES");
        }
        Properties props=new Properties();
        try {
            props.load(reader);
        } catch (IOException e) {
            log.error("ERROR FOR LOADING URL PROPERTIES");
        }
        log.debug("Key : "+key +" Value : "+props.getProperty(key));
        return props.getProperty(key);
    }

    public String getPropertiesConfigurations(String key){
        FileReader reader= null;
        try {
            File file =new File(System.getProperty("user.dir")+PATH_CONFIGURATIONS_PROPERTIES);
            log.debug(file.getAbsoluteFile());
            reader = new FileReader(file);
        } catch (FileNotFoundException e) {
            log.error("ERROR FOR CONFIGURATION PROPERTIES");
        }
        Properties props=new Properties();
        try {
            props.load(reader);
        } catch (IOException e) {
            log.error("ERROR FOR LOADING CONFIGURATION PROPERTIES");
        }
        log.debug("Key : "+key +" Value : "+props.getProperty(key));
        return props.getProperty(key);
    }

    public String getPropertiesObjectRepository(String key){
        FileReader reader= null;
        try {
            File file =new File(System.getProperty("user.dir")+PATH_OBJECT_REPOSITORY_PROPERTIES);
            log.debug(file.getAbsoluteFile());
            reader = new FileReader(file);
        } catch (FileNotFoundException e) {
            log.error("ERROR FOR OBJECT PROPERTIES");
        }
        Properties props=new Properties();
        try {
            props.load(reader);
        } catch (IOException e) {
            log.error("ERROR FOR LOADING OBJECT REPOSITORY PROPERTIES");
        }
        log.debug("Key : "+key +" Value : "+props.getProperty(key));
        return props.getProperty(key);
    }
}
