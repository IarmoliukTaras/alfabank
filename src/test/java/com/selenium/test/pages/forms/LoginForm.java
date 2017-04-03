package com.selenium.test.pages.forms;

import com.selenium.test.webtestsbase.container.AbstractContainer;
import com.selenium.test.webtestsbase.elements.Button;
import com.selenium.test.webtestsbase.elements.TextField;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by a123 on 02.04.17.
 */
public class LoginForm extends AbstractContainer {


    @FindBy(className = "field_login")
    private TextField field_login;

    @FindBy(className = "field_password")
    private TextField field_password;

    @FindBy(id = "loginButton")
    private Button loginButton;

    @FindBy(className = "error_txt")
    private WebElement error;

    @FindBy(className = "forgot_password")
    private WebElement forgot_password;

    @FindBy(className = "new_user_link")
    private WebElement new_user_link;

    @FindBy(tagName = "h2")
    private WebElement h2;

    @FindBy(tagName = "p")
    private WebElement p;


    public void setLogin(String login) {
        field_login.type(login);
    }

    public void setPassword(String password) {
        field_password.type(password);
    }

    public void pressSubmit() {
        loginButton.click();
    }

    public void checkForm() {
        assertEquals("Incorrect text", "My Alfa-Bank", h2.getText());
        assertEquals("Incorrect text", "інтернет сервіс", p.getText());
        assertEquals("Incorrect text", "Логін", field_login.getPlaceholderText());
        assertEquals("Incorrect text", "Пароль", field_password.getPlaceholderText());
        assertEquals("Incorrect text", "Нагадати?", forgot_password.getText());
        assertEquals("Incorrect text", "Новий користувач", new_user_link.getText());
    }

    public void submitAndCheckError() {
        pressSubmit();
        assertTrue("Error not found", error.isDisplayed());

        String[] wordsForCheck = { "Не", "вдалось", "вхід", "введення", "логіну", "паролю" };

        String textError = error.getText();
        for (String word : wordsForCheck) {
            assertTrue("Error: \"" + textError +"\" do not contains word - " + word + ".",
                    textError.contains(word));
        }
    }

    public void pressNewUserLink() {
        new_user_link.click();
    }

}
