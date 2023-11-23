package steps;

import BudapestGoPages.BGOHomePage;
import browser.BrowserType;
import browser.DriverInitializer;
import browser.Settings;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.time.Duration;
import java.util.List;

public class BudapestGoSteps  {

    WebDriver driver;
    BGOHomePage bgoHomePage;

    public BudapestGoSteps() {}


    @Before
    public void openBrowser() {
        driver = DriverInitializer.initDriver(BrowserType.CHROME_SELENIUM_MGR);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        bgoHomePage = new BGOHomePage(driver);
    }

    @Given("I open BudapestGo")
    public void iOpenBudapestGo() {
        driver.get(Settings.BASE_URL);
    }

    @Given("I click on the \"Elfogadom\" button")
    public void iAcceptCookies() {
        By cookieButton = By.xpath("//button[text()='Elfogadom']");
        driver.findElement(cookieButton).click();
    }

    @Then("The cookie pop-up disappears")
    public void theCookiePopUpDisappears() {
        By cookieButton = By.xpath("//button[text()='Elfogadom']");
        List<WebElement> elements = driver.findElements(cookieButton);
        Assertions.assertTrue(elements.isEmpty() || !elements.get(0).isDisplayed(), "Cookie popup is still visible.");
    }

    @Given("the language is set to {string}")
    public void theLanguageIsSetTo(String lang) {

        bgoHomePage.acceptCookiesIfPresent(); //If cookie pop-up would block elements it's handled.

        if(lang.equals("english")) {
            bgoHomePage.hungarianButton.click();
        }
        if(lang.equals("hungarian")) { }   //If language is Hungarian, do nothing.

        By title = By.tagName("h2");
        String titleText = driver.findElement(title).getText();
        Assertions.assertEquals("Utazástervezés", titleText, "The language is not hungarian.");

    }

    @When("I change the language to {string}")
    public void iChangeTheLanguageTo(String lang) {

        if(lang.equals("hungarian")) {
            bgoHomePage.englishButton.click();
        }
        if(lang.equals("english")) { }   //If language is English, do nothing.

        By title = By.tagName("h2");
        String titleText = driver.findElement(title).getText();
        Assertions.assertEquals("Trip Planner", titleText, "The language is not english.");
    }

    @Then("language is changed to {string}")
    public void languageIsChangedToNewPageLanguage(String lang) {
        if(lang.equals("english")) {
            bgoHomePage.hungarianButton.click();
        }
        if(lang.equals("hungarian")) { }   //If language is Hungarian, do nothing.

        By title = By.tagName("h2");
        String titleText = driver.findElement(title).getText();
        Assertions.assertEquals("Utazástervezés", titleText, "The language is not hungarian.");
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }


}
