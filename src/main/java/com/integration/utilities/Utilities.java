package com.integration.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Utilities {

    public String getPropertiesUrl(String key){
        FileReader reader= null;
        try {
            File file =new File(System.getProperty("user.dir")+"\\src\\main\\resources\\Url.properties");
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
            File file =new File(System.getProperty("user.dir")+"\\src\\main\\resources\\Configurations.properties");
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
            File file =new File(System.getProperty("user.dir")+"\\src\\main\\resources\\ObjectRepository.properties");
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
