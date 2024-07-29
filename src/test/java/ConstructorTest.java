import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageobject.MainPage;

import java.util.concurrent.TimeUnit;

import static driver.Driver.createWebDriver;
import static org.junit.Assert.assertTrue;

public class ConstructorTest {

    private WebDriver driver;

    @Before
     public void setUp() {
        driver = createWebDriver();
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
    }

    @Test
    @DisplayName("Перейти к разделу о соусах")
    public void successPassToSaucesChapter() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.open();
        objMainPage.clickSaucesChapter();
        assertTrue(objMainPage.saucesHeaderIsVisible());
    }

    @Test
    @DisplayName("Перейти к разделу о начинках")
    public void successPassToFillingsChapter() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        MainPage objMainPage = new MainPage(driver);
        objMainPage.open();
        objMainPage.clickFillingsChapter();
        assertTrue(objMainPage.fillingsHeaderIsVisible());
    }

    @Test
    @DisplayName("Перейти к разделу о булочках")
    public void successPassToBunsChapter() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        MainPage objMainPage = new MainPage(driver);
        objMainPage.open();
        objMainPage.clickFillingsChapter();
        objMainPage.clickBunsChapter();
        assertTrue(objMainPage.bunsHeaderIsVisible());
    }

    @After
    public void after() {
        driver.quit();
    }
}
