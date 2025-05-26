package com.integration.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Utilities {

    private static final String PATH_URL_PROPERTIES = "\\src\\main\\resources\\Url.properties";
    private static final String PATH_CONFIGURATIONS_PROPERTIES = "\\src\\main\\resources\\Configurations.properties";
    private static final String PATH_OBJECT_REPOSITORY_PROPERTIES = "\\src\\main\\resources\\ObjectRepository.properties";

    public String getPropertiesUrl(String key){
        FileReader reader= null;
        try {
            File file =new File(System.getProperty("user.dir")+PATH_URL_PROPERTIES);
            reader = new FileReader(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Properties props=new Properties();
        try {
            props.load(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return props.getProperty(key);
    }

    public String getPropertiesConfigurations(String key){
        FileReader reader= null;
        try {
            File file =new File(System.getProperty("user.dir")+PATH_CONFIGURATIONS_PROPERTIES);
            reader = new FileReader(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Properties props=new Properties();
        try {
            props.load(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return props.getProperty(key);
    }

    public String getPropertiesObjectRepository(String key){
        FileReader reader= null;
        try {
            File file =new File(System.getProperty("user.dir")+PATH_OBJECT_REPOSITORY_PROPERTIES);
            reader = new FileReader(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Properties props=new Properties();
        try {
            props.load(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return props.getProperty(key);
    }
}
