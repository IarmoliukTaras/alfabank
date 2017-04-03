package com.selenium.test.pages;

import com.selenium.test.pages.forms.LoginForm;
import com.selenium.test.webtestsbase.BasePage;
import com.selenium.test.webtestsbase.container.AbstractContainer;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    private static final String PAGE_URL = "https://my.alfabank.com.ua/login";

    @FindBy(className = "login_block")
    public LoginForm loginForm;

    public LoginPage() {
        super(true);
    }

    public IdentifyLoginPage newUser() {
        loginForm.pressNewUserLink();
        return new IdentifyLoginPage();
    }


    @Override
    protected void openPage() {
        getDriver().get(PAGE_URL);
    }

    @Override
    public boolean isPageOpened() {
        return getDriver().findElement(By.className("login_block")).isDisplayed();
    }

}
