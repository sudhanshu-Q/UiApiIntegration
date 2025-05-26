package com.integration.ui.playwright;

import com.integration.utilities.Utilities;
import com.microsoft.playwright.Page;
import org.apache.log4j.Logger;

public class EmployeePage {

    private final static Logger log = Logger.getLogger(ElementsUtilities.class);
    private static final String USERNAME_LOCATOR= new Utilities().getPropertiesObjectRepository("UsernameXpath");
    private static final String COURSE_DROPDOWN_LOCATOR = new Utilities().getPropertiesObjectRepository("DropDownXpath");
    private static final String OPTION_PYTHON_LOCATOR = "python";

//
    private Page page;

    public EmployeePage(Page page){
        this.page=page;
    }

    public void verify_EmployeePage() {
        try {
            ElementsUtilities elementsUtilities= new ElementsUtilities(page);
            elementsUtilities.assertion_Title(elementsUtilities.get_PageTitle(),"TITLE_EMPLOYEE");
            elementsUtilities.assertion_Url(elementsUtilities.get_PageUrl(), "URL_EMPLOYEE");
            elementsUtilities.send_TestData(USERNAME_LOCATOR,"Tsest");
            elementsUtilities.selectOption_selector(COURSE_DROPDOWN_LOCATOR, OPTION_PYTHON_LOCATOR);
            log.debug("Verify Employee Page ");

        } catch (Exception e) {
            log.error("Error Occurred : "+e.getMessage());
        }
    }

}
