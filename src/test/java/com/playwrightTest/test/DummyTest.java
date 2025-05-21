package com.playwrightTest.test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class DummyTest {

    public static void main(String[] args) {

        
        Playwright pw=Playwright.create();
        BrowserType browserType=pw.firefox();
        Browser browser=browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://playwright.dev/java/docs/intro");
        System.out.println(page.title());
        page.close();
        browser.close();
        pw.close();

    }
}
