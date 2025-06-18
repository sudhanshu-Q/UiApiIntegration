package com.extentListeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

    private static ExtentReports extent;


    public static ExtentReports createInstance(String filename){
        ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter(filename);
        //set report config for look and feel
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setDocumentTitle("Automation Report");
        extentSparkReporter.config().setReportName(System.getProperty("user.dir").toString());
        extentSparkReporter.config().setEncoding("utf-8");
        // set test in report
        extent = new ExtentReports();
        extent.attachReporter(extentSparkReporter);
        return extent;

    }
}
