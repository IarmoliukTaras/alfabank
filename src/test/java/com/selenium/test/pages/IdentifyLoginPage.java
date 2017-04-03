package com.selenium.test.pages;

import com.selenium.test.pages.forms.IdentifyForm;
import com.selenium.test.webtestsbase.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

/**
 * Created by a123 on 02.04.17.
 */
public class IdentifyLoginPage extends BasePage{

    @FindBy(id = "IdentifyForm")
    public IdentifyForm identifyForm;

    public IdentifyLoginPage() {
        super(false);
    }

    @Override
    protected void openPage() {
        //do nothing
    }

    @Override
    public boolean isPageOpened() {
        return getDriver().findElement(By.id("IdentifyForm")).isDisplayed();
    }
}
