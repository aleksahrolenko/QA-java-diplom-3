package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private final WebDriver driver;
    public static final String FORGOT_PASSWORD_URL = "https://stellarburgers.nomoreparties.site/forgot-password";
    private By enterButton = By.xpath(".//div/p/a[text()='Войти']");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Открыть страницу восстановления пароля")
    public void open() {
        driver.get(FORGOT_PASSWORD_URL);
    }
    @Step("Клик на кнопку Войти")
    public void clickEnterButton() {
        driver.findElement(enterButton).click();
    }
}