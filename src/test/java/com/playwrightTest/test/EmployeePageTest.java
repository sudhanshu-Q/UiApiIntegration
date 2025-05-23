package com.playwrightTest.test;

import com.integration.ui.playwright.EmployeePage;
import com.integration.ui.testBase.TestBase;
import com.integration.utilities.Utilities;
import com.microsoft.playwright.Page;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EmployeePageTest {

    Page page;
    EmployeePage employeePage;

    @BeforeTest
    public void setupBrowser() {
        page = new TestBase().
                getBrowser(new Utilities().getPropertiesConfigurations("BROWSER"),
                        new Utilities().getPropertiesUrl("URL_EMPLOYEE"),
                        new Utilities().getPropertiesConfigurations("HEADLESS"));
        employeePage = new EmployeePage(page);
    }

    @Test
    public void runTest() {
        String getTitle = employeePage.verifyTitle();
        System.out.println(getTitle);
        Assert.assertEquals(getTitle,new Utilities().getPropertiesUrl("TITLE_EMPLOYEE"));
    }

    @AfterTest
    public void stopTest(){
        page.close();
        System.out.println("shutdown..Employee Test");
    }
}