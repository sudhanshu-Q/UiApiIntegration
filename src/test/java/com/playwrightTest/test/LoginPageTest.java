package com.playwrightTest.test;

import com.integration.ui.playwright.LoginPage;
import com.integration.ui.testBase.TestBase;
import com.integration.utilities.Utilities;
import com.microsoft.playwright.Page;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPageTest {

    Page page;
    LoginPage login;

    @BeforeTest
    public void setupBrowser() {
        page = new TestBase().
                getBrowser(new Utilities().getPropertiesConfigurations("BROWSER"),
                        new Utilities().getPropertiesUrl("URL_EMPLOYEE"),
                        new Utilities().getPropertiesConfigurations("HEADLESS"));
        login = new LoginPage(page);
    }

    @Test
    public void runTest() {
        String title1 = login.verifyTitle();
        Assert.assertEquals(title1,new Utilities().getPropertiesUrl("TITLE_EMPLOYEE"));
    }

    @AfterTest
    public void stopTest(){
        page.close();
        System.out.println("shutdown..suite");
    }
}