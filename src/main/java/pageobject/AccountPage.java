package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {
    private final WebDriver driver;
    private By profileLink = By.xpath(".//a[@href='/account/profile']");
    private By logoutButton = By.xpath(".//ul/li[3]/button[text()='Выход']");

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Видна ли ссылка на профиль")
    public boolean accountPageProfileLinkIsVisible() {
        return driver.findElement(profileLink).isDisplayed();
    }
    @Step("Выход из профиля")
    public void clickLogout() {
        driver.findElement(logoutButton).click();
    }
}
