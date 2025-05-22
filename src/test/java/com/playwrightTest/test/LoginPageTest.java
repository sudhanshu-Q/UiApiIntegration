package com.playwrightTest.test;

import com.TestConfigurations.TestBase;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {

    @Test
    public void runTest() {
        new TestBase().getBrowser("Chrome","http://username:password123@localhost:8010/Employee");

    }
}
