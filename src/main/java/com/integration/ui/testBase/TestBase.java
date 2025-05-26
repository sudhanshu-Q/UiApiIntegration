package com.integration.ui.testBase;

import com.integration.utilities.Utilities;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

public class TestBase {

    Playwright playwright;
    BrowserType browserType;
    Browser browser;
    public Page page;
    private static final Logger log = LoggerFactory.getLogger(TestBase.class);

    @BeforeSuite
    public void runBeforeTestSuite () {
        log.info("Starting");
        System.out.println("starting..Suite");
    }

    @BeforeTest
    public void runBeforeTest () {
        System.out.println("starting..Test");
    }

    @BeforeClass
    public void runBeforeClass () {
        System.out.println("starting..class");
    }

    @BeforeGroups
    public void runBeforeGroup () {
        System.out.println("starting..group");
    }

    @BeforeMethod
    public void runBeforeMethod () {
        System.out.println("starting..method");
    }

    public Page getBrowser (String browserName, String url,String headless){

        headless=new Utilities().getPropertiesConfigurations("HEADLESS");
        boolean browserHeadless = Boolean.parseBoolean(headless);
        if (browserName.equalsIgnoreCase("Firefox")) {
            playwright = Playwright.create();
            browserType = playwright.firefox();
            browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(browserHeadless));
            page = browser.newPage();
            //page.setDefaultTimeout(90000);
            page.navigate(url);
        } else if (browserName.equalsIgnoreCase("chrome")) {
            playwright = Playwright.create();
            browserType = playwright.chromium();
            browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(browserHeadless));
            page = browser.newPage();
            //page.setDefaultTimeout(90000);
            page.navigate(url);
        } else {
            System.out.println("Wrong browser name");
        }

        return page;
    }

    @AfterMethod
    public void runAfterMethod () {
        System.out.println("Shutdown..method");
    }


    @AfterGroups
    public void runAfterGroup () {
        System.out.println("Shutdown..group");
    }

    @AfterClass
    public void runAfterClass () {
        System.out.println("Shutdown..class");
    }

    @AfterTest
    public void runAfterTest () {
        System.out.println("shutdown..Test");
    }

    @AfterSuite
    public void runAfterTestSuite () {
        log.info("Shutdown");
        browser.close();
        playwright.close();
        page.close();
        System.out.println("shutdown..suite");
    }
}
