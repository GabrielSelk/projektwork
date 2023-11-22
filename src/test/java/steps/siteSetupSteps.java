package steps;

import browser.BrowserType;
import browser.DriverInitializer;
import browser.Settings;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class siteSetupSteps {

    WebDriver driver;

    @Before
    public void openBrowser() {
        driver = DriverInitializer.initDriver(BrowserType.CHROME_SELENIUM_MGR);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Given("I open the site {string}")
    public void iOpenTheSite(String arg0) {
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
        ;
        List<WebElement> elements = driver.findElements(cookieButton);
        Assertions.assertTrue(elements.isEmpty() || !elements.get(0).isDisplayed(), "Cookie popup is still visible.");
    }

    @Given("the language is set to {string}")
    public void theLanguageIsSetTo(String arg0) {
    }

    @When("I change the language to {string}")
    public void iChangeTheLanguageTo(String arg0) {
    }

    @And("I change the language back to {string}")
    public void iChangeTheLanguageBackTo(String arg0) {
    }

    @Then("language is changed to <newPageLanguage>")
    public void languageIsChangedToNewPageLanguage() {
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}
