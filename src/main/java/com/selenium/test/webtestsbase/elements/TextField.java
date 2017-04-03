package com.selenium.test.webtestsbase.elements;

public interface TextField extends Element {
    void type(String text);

    void clear();

    void clearAndType(String text);

    String getPlaceholderText();

    String getHintText();

}
