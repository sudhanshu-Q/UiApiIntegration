package com.playwrightTest;

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
    public void verifyEmployeePageTest() {
        employeePage.verify_EmployeePage();
    }

    @AfterTest
    public void stopTest(){
       // page.close();
        System.out.println("shutdown..Employee Test");
    }
}