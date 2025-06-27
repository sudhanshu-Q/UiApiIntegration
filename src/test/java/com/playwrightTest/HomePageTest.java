package com.playwrightTest;

import com.integration.ui.playwright.HomePage;
import com.integration.ui.testBase.TestBase;
import com.integration.utilities.Utilities;
import com.microsoft.playwright.Page;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest {

    Page page;
    HomePage homePage;

    @BeforeTest
    public void setupBrowser() {
        page = new TestBase().
                getBrowser(new Utilities().getPropertiesConfigurations("BROWSER"),
                        new Utilities().getPropertiesUrl("URL_HOMEPAGE"),
                        new Utilities().getPropertiesConfigurations("HEADLESS"));
        homePage = new HomePage(page);
    }

    @Test
    public void verifyHomePageTest() {
        homePage.verify_homePage();
    }

    @AfterTest
    public void stopTest(){
        // page.close();
        System.out.println("shutdown..Employee Test");
    }
}
