package com.selenium.test.webtestsbase.container;

import com.selenium.test.webtestsbase.elements.Element;
import org.openqa.selenium.WebElement;

public interface Container extends Element {
    void init(WebElement wrappedElement);
}
