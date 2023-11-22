package steps;

import browser.BrowserType;
import browser.DriverInitializer;
import browser.Settings;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class siteSetupSteps {

WebDriver driver;


@Before
    public void openBrowser(){
    driver = DriverInitializer.initDriver(BrowserType.CHROME_SELENIUM_MGR);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}

@Given("I open the site https://go.bkk.hu")
public void openWebsite(){driver.get(Settings.BASE_URL);}


@Given("I click on the \"Elfogadom\" button")
public void iAcceptCookies() {
    By cookieButton = By.xpath("//button[text()='Elfogadom']");
    driver.findElement(cookieButton).click();
}










@After
    public void closeBrowser() {
        driver.quit();
    }

}
