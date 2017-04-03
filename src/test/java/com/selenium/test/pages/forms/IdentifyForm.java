package com.selenium.test.pages.forms;

import com.selenium.test.webtestsbase.container.AbstractContainer;
import com.selenium.test.webtestsbase.elements.TextField;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by a123 on 02.04.17.
 */
public class IdentifyForm  extends AbstractContainer {


    @FindBy(tagName = "h3")
    private WebElement h3;

    @FindBy(css = "div[class='field-form']")
    private TextField contractNumber;

    @FindBy(css = "p[class='field-form']")
    private WebElement p;

    @FindBy(id = "birthdayChooserDay")
    private WebElement birthdayChooserDay;

    @FindBy(id = "birthdayChooserMonth")
    private WebElement birthdayChooserMonth;

    @FindBy(css = "div[class='input-date-of-birth'] > div:nth-child(3)")
    private TextField birthdayChooserYear;

    @FindBy(id = "iAmTheMaster")
    private WebElement checkBox;

    @FindBy(css = "input[name='ok']")
    private WebElement submit_button;

    @FindBy(css = "input[name='cancel']")
    private WebElement cancel_button;

    @FindBy(className = "error")
    private WebElement error;

    public void setContractNumber(String number) {
        contractNumber.type(number);
    }

    public void selectDay(String day) {
        new Select(birthdayChooserDay).selectByVisibleText(day);
    }

    public void selectMonth(String month) {
        new Select(birthdayChooserDay).selectByVisibleText(month);
    }

    public void setYear(String year) {
        birthdayChooserYear.type(year);
    }

    public void setBirthday(Date date) {
        selectDay(String.valueOf(date.getDay()));
        selectMonth(String.valueOf(date.getMonth()));
        setYear(String.valueOf(date.getYear()));
    }

    public void clickCheckBox() {
        checkBox.click();
    }

    public void pressSubmitButton() {
        submit_button.click();
    }

    public void checkForm() {
        h3.click();
        assertEquals("Incorrect text", "Крок 1: Ідентифікація", h3.getText());
        assertEquals("Incorrect text", "Дата народження\n" +
                "(приклад: 25 лютого 1986)", p.getText());
        assertEquals("Incorrect text", "Номер договору / карти або рахунку",
                contractNumber.getPlaceholderText());
        assertEquals("Incorrect text", "рік", birthdayChooserYear.getPlaceholderText());
        assertEquals("Incorrect text", "Я підтверджую, що є власником даного договору/рахунку",
                checkBox.getText());
    }

    public void checkHintsTexts() {
        assertEquals("Incorrect text", "Введіть номер карти, договору або рахунку", contractNumber.getHintText());
        assertEquals("Incorrect text", "Введіть рік чотиризначним числом, наприклад \"1957\"",
                birthdayChooserYear.getHintText());
    }

    public void checkErrorText(String text) {
        assertEquals("Incorrect error text", text, error.getText());
    }

}
