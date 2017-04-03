package com.selenium.test.junit.tests;

import com.selenium.test.junit.rules.ScreenShotOnFailRule;
import com.selenium.test.pages.IdentifyLoginPage;
import com.selenium.test.pages.LoginPage;
import org.junit.*;

import static com.selenium.test.webtestsbase.WebDriverFactory.finishBrowser;
import static com.selenium.test.webtestsbase.WebDriverFactory.startBrowser;

public class IdentifyLoginPageTest {

    @Rule
    public ScreenShotOnFailRule screenShotOnFailRule = new ScreenShotOnFailRule();

    private IdentifyLoginPage page;

    @BeforeClass
    public static void beforeClass() {
        startBrowser(true);
    }

    @Before
    public void beforeTest() {
        page = new LoginPage().newUser();
    }

    @Test
    public void checkTextOnLoginForm() {
        page.identifyForm.checkForm();
    }

    @Test
    public void checkHintsTexts() {
        page.identifyForm.checkHintsTexts();
    }

    @Test
    public void checkErrorWithoutContractNumber() {
        page.identifyForm.setYear("1992");
        page.identifyForm.pressSubmitButton();
        page.identifyForm.checkErrorText("Введіть номер договору / карти або рахунку");
    }

    @Test
    public void checkErrorWithoutYear() {
        page.identifyForm.setContractNumber("1111111111111");
        page.identifyForm.pressSubmitButton();
        page.identifyForm.checkErrorText("Невірний формат дати народження");
    }

    @Test
    public void checkErrorWithIncorrectContractNumber() {
        page.identifyForm.setContractNumber("1111111111111");
        page.identifyForm.setYear("1992");
        page.identifyForm.clickCheckBox();
        page.identifyForm.pressSubmitButton();
        page.identifyForm.checkErrorText("Договір з номером \"1111111111111\" не знайдений або невірна дата народження");
    }

    @Test
    public void checkErrorWithoutClickCheckBox() {
        page.identifyForm.setContractNumber("1111111111111");
        page.identifyForm.setYear("1992");
        page.identifyForm.pressSubmitButton();
        page.identifyForm.checkErrorText("Підтвердіть, що є власником даного договору.");
    }

    @AfterClass
    public static void afterClass() {
        finishBrowser();
    }
}
