package com.integration.ui.playwright;

import com.integration.utilities.Utilities;
import com.microsoft.playwright.Page;
import org.apache.log4j.Logger;
import org.testng.Assert;

public class ElementsUtilities {

    private final static Logger log = Logger.getLogger(ElementsUtilities.class);
    private Page page;

    public ElementsUtilities(Page page){
        this.page=page;
    }

    public String get_PageUrl() {
        String url= null;
        try{
            url=page.url();
            log.debug("URL of the page : "+url);
        } catch (Exception e) {
            log.error("Error for URL : "+e.getMessage()+e);
        }
        return url;
    }

    public String get_PageTitle() {
        String title = null;
        try {
            title=page.title();
            log.debug("Title of the page : "+title);
        } catch (Exception e) {
            log.error("Error for Title of the page : "+e.getMessage()+e);
        }
        return title;
    }

    public void clickOn_Element(String getLocators) {
        try {
            page.click(getLocators);
            log.debug("Locator : "+ getLocators);
        } catch (Exception e) {
            log.error("Error occurred for clickOn_Element : "+e.getMessage() +getLocators);
        }
    }

    public void assertion_Title(String getTitle,String getTitleKey) {
        try{
            Assert.assertEquals(getTitle,new Utilities().getPropertiesUrl(getTitleKey));
            log.debug("Get Title of page from active session : " + getTitle);
            log.debug("Get Title of page from Configuration : " + new Utilities().getPropertiesUrl(getTitleKey));
            log.debug("Assert Title of page : " + getTitle.equalsIgnoreCase(new Utilities().getPropertiesUrl(getTitleKey)));
        } catch (Exception e) {
            log.error("Error for Title assertion : " +e.getMessage()+e);
        }
    }

    public void assertion_Url(String getUrl,String getUrlKey) {
        try{
            Assert.assertEquals(getUrl,new Utilities().getPropertiesUrl(getUrlKey));
            log.debug("Get Url of page from active session : " + getUrl);
            log.debug("Get Url of page from Configuration : " + new Utilities().getPropertiesUrl(getUrlKey));
            log.debug("Assert url : "+getUrl.equalsIgnoreCase(new Utilities().getPropertiesUrl(getUrlKey)));
        } catch (Exception e) {
            log.error("Error for Url assertion : " +e.getMessage()+e);
        }
    }

    public void wait_Action(int waitForMilliSecond){
        try {
            page.wait(waitForMilliSecond);
            log.debug("wait for : "+waitForMilliSecond);
        } catch (InterruptedException e) {
            log.error("Error for wait Action : "+e.getMessage());
        }
    }

    public void send_TestData(String getLocator, String sendTestData){
        try{
            boolean isEditableTextBox = page.isEditable(getLocator);
            log.debug("Is Locator Editable : " + isEditableTextBox);
            Assert.assertTrue(isEditableTextBox);
            page.fill(getLocator,sendTestData);
            log.debug("Get locator : " + getLocator + " | " + "Get TestData : " + sendTestData);
        } catch (Exception e) {
            log.error("Error while sending Test data : "+ e.getMessage());
        }
    }

    public void selectOption_selector(String getSelector, String selectOption){
        try{
            boolean isLocatorVisible = page.isVisible(getSelector);
            Assert.assertTrue(isLocatorVisible);
            log.debug("Is Locator Visible : " + isLocatorVisible);
            page.selectOption(getSelector,selectOption);
            log.debug("Select Option : " + selectOption);
        } catch (Exception e) {
            log.error("Error While selecting DropDown : "+ e.getMessage());
        }

    }
}
