package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;
    private By enterHeader = By.xpath(".//h2[text()='Вход']");
    private By emailField = By.xpath(".//div/form/fieldset[1]/div/div/input[@name='name']");
    private By passwordField = By.xpath(".//div/form/fieldset[2]/div/div/input[@name='Пароль']");
    private By enterButton = By.xpath(".//button[text()='Войти']");

    private final String email;
    private final String password;
    public LoginPage(WebDriver driver, String email, String password) {
        this.driver = driver;
        this.email = email;
        this.password = password;
    }
    @Step("Виден ли заголовок Вход")
    public boolean loginPageIsVisible() {
        return driver.findElement(enterHeader).isDisplayed();
    }
    @Step("Авторизация")
    public void authorization() {
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }
    @Step("Клик на кнопку Войти")
    public void clickEnterButton() {
        driver.findElement(enterButton).click();
    }
}
