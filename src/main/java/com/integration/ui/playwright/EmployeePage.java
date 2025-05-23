package com.integration.ui.playwright;

import com.microsoft.playwright.Page;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class EmployeePage {

    //private String locator="input[@id='name']";

   private Page page;

    public EmployeePage(Page page){
        this.page=page;
    }

    public String verifyTitle() {
        return page.title();
    }

}
