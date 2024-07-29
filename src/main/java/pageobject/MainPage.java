package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private final WebDriver driver;
    public static final String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/";
    private By enterButton = By.xpath(".//div/main/section[2]/div/button[text()='Войти в аккаунт']");

    private By privateOfficeButton = By.xpath(".//div/header/nav/a/p[text()='Личный Кабинет']");

    private By constructorButton = By.xpath(".//header/nav/ul/li[1]/a/p[text()='Конструктор']");

    private By constructorName = By.xpath(".//section[1]/h1[text()='Соберите бургер']");

    private By logoStellarBurgers = By.xpath(".//header/nav/div/a");
    private By bunsChapter = By.xpath(".//span[text()='Булки']");
    private By saucesChapter = By.xpath(".//span[text()='Соусы']");
    private By fillingsChapter = By.xpath(".//span[text()='Начинки']");
    private By bunsHeader = By.xpath(".//h2[text()='Булки']");
    private By saucesHeader = By.xpath(".//h2[text()='Соусы']");
    private By fillingsHeader = By.xpath(".//h2[text()='Начинки']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Открытие главной страницы")
    public void open() {
        driver.get(MAIN_PAGE_URL);
    }
    @Step("Клик на кнопку Войти в аккаунт")
    public void clickEnterButton() {
        driver.findElement(enterButton).click();
    }
    @Step("Клик на кнопку Личный Кабинет")
    public void clickPrivateOfficeButton() {
        driver.findElement(privateOfficeButton).click();
    }
    @Step("Клик на кнопку Конструктор")
    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }
    @Step("Клик на логотип StellarBurgers")
    public void clickLogoStellarBurgers() {
        driver.findElement(logoStellarBurgers).click();
    }
    @Step("Виден ли конструктор")
    public boolean constructorIsVisible() {
        return driver.findElement(constructorName).isDisplayed();
    }
    @Step("Виден ли заголовок Булки")
    public boolean bunsHeaderIsVisible() {
        return driver.findElement(bunsHeader).isDisplayed();
    }
    @Step("Виден ли заголовок Соусы")
    public boolean saucesHeaderIsVisible() {
        return driver.findElement(saucesHeader).isDisplayed();
    }
    @Step("Виден ли заголовок Начинки")
    public boolean fillingsHeaderIsVisible() {
        return driver.findElement(fillingsHeader).isDisplayed();
    }
    @Step("Клик на раздел Булки")
    public void clickBunsChapter() {
        driver.findElement(bunsChapter).click();
    }
    @Step("Клик на раздел Соусы")
    public void clickSaucesChapter() {
        driver.findElement(saucesChapter).click();
    }
    @Step("Клик на раздел Начинки")
    public void clickFillingsChapter() {
        driver.findElement(fillingsChapter).click();
    }
}

