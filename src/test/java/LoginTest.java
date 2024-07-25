import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageobject.ForgotPasswordPage;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.RegistrationPage;

import java.util.concurrent.TimeUnit;

import static driver.Driver.createWebDriver;
import static org.junit.Assert.assertTrue;

public class LoginTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = createWebDriver();
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной странице")
    public void successEnterThrowMainPage() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        MainPage objMainPage = new MainPage(driver);
        LoginPage objLoginPage = new LoginPage(driver, null, null);

        objMainPage.open();
        objMainPage.clickEnterButton();

        assertTrue(objLoginPage.loginPageIsVisible());
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void successEnterThrowPrivateOffice() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        MainPage objMainPage = new MainPage(driver);
        LoginPage objLoginPage = new LoginPage(driver, null, null);

        objMainPage.open();
        objMainPage.clickPrivateOfficeButton();

        assertTrue(objLoginPage.loginPageIsVisible());
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void successEnterThrowRegistrationPage() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        RegistrationPage objRegPage = new RegistrationPage(driver, null, null, null);
        LoginPage objLoginPage = new LoginPage(driver, null, null);

        objRegPage.open();
        objRegPage.clickEnterButton();

        assertTrue(objLoginPage.loginPageIsVisible());
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void successEnterThrowForgotPasswordPage() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        ForgotPasswordPage objForgotPasswordPage = new ForgotPasswordPage(driver);
        LoginPage objLoginPage = new LoginPage(driver, null, null);

        objForgotPasswordPage.open();
        objForgotPasswordPage.clickEnterButton();

        assertTrue(objLoginPage.loginPageIsVisible());
    }

    @After
    public void after() {
        driver.quit();
    }
}
