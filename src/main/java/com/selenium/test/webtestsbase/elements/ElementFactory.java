package com.selenium.test.webtestsbase.elements;

import com.selenium.test.webtestsbase.elements.Element;
import org.openqa.selenium.WebElement;

public interface ElementFactory {
    <E extends Element> E create(Class<E> elementClass, WebElement wrappedElement);
}
