package com.selenium.test.webtestsbase.elements.impl;

import com.selenium.test.webtestsbase.elements.TextField;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

class TextFieldImpl extends AbstractElement implements TextField {
    protected TextFieldImpl(final WebElement wrappedElement) {
        super(wrappedElement);
    }

    By input = By.tagName("input");

    @Override
    public void type(final String text) {
        wrappedElement.findElement(input).sendKeys(text);
    }

    @Override
    public void clear() {
        wrappedElement.findElement(input).clear();
    }

    @Override
    public void clearAndType(final String text) {
        clear();
        type(text);
    }

    @Override
    public String getPlaceholderText() {
        return wrappedElement.findElement(By.className("placeholder")).getText();
    }

    @Override
    public String getHintText() {
        wrappedElement.click();
        return wrappedElement.findElement(By.className("hint_txt")).getText();
    }
}
