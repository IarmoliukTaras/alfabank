package com.selenium.test.junit.tests;

import com.selenium.test.junit.rules.ScreenShotOnFailRule;
import com.selenium.test.pages.LoginPage;
import org.junit.*;
import org.openqa.selenium.By;

import static com.selenium.test.webtestsbase.WebDriverFactory.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 *  Tests for login page
 */
public class LoginPageTest {

    @Rule
    public ScreenShotOnFailRule screenShotOnFailRule = new ScreenShotOnFailRule();

    private LoginPage page;

    @BeforeClass
    public static void beforeClass() {
        startBrowser(true);
    }

    @Before
    public void beforeTest() {
            page = new LoginPage();
    }

    @Test
    public void checkTextOnLoginForm() {
        page.loginForm.checkForm();
    }

    @Test
    public void checkLoginWithoutPassword() {
        page.loginForm.setLogin("login");
        page.loginForm.submitAndCheckError();
    }

    @Test
    public void checkLoginWithoutLogin() {
        page.loginForm.setPassword("password");
        page.loginForm.submitAndCheckError();
    }

    @Test
    public void checkLoginWithIncorrectInformation() {
        page.loginForm.setLogin("login");
        page.loginForm.setPassword("password");
        page.loginForm.submitAndCheckError();

    }

    @AfterClass
    public static void afterClass() {
        finishBrowser();
    }
}
