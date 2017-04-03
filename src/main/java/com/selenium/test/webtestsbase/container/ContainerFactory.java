package com.selenium.test.webtestsbase.container;

import org.openqa.selenium.WebElement;

public interface ContainerFactory {
    <C extends Container> C create(Class<C> containerClass, WebElement wrappedElement);
}
