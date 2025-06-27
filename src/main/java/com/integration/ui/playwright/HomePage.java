package com.integration.ui.playwright;

import com.integration.utilities.Utilities;
import com.microsoft.playwright.Page;
import org.apache.log4j.Logger;

public class HomePage {

    private final static Logger log = Logger.getLogger(ElementsUtilities.class);

    private Page page;

    public HomePage(Page page){
        this.page=page;
    }

    public void verify_homePage() {
        try {
            ElementsUtilities elementsUtilities= new ElementsUtilities(page);
            elementsUtilities.assertion_Title(elementsUtilities.get_PageTitle(),"TITLE_HOMEPAGE");
            elementsUtilities.assertion_Url(elementsUtilities.get_PageUrl(), "URL_HOMEPAGE");
            //  elementsUtilities.send_TestData(USERNAME_LOCATOR,"Tsest");
            //  elementsUtilities.selectOption_selector(COURSE_DROPDOWN_LOCATOR, OPTION_PYTHON_LOCATOR);
            log.debug("Verify HomePage ");

        } catch (Exception e) {
            log.error("Error Occurred : "+e.getMessage());
        }
    }
}
