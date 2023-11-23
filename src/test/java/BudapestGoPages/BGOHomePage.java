package BudapestGoPages;
import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class BGOHomePage extends BasePage{
    public BGOHomePage(WebDriver driver) {
        super(driver);
    }

  //  @FindBy(xpath = "//*[@id=\"toolbar\"]/div[1]/a[1]")
    //WebElement pageTitle;

    @FindBy(xpath = "//span[@title='hungarian']")
    public WebElement hungarianButton;

    @FindBy(xpath = "//span[@title='english']")
    public WebElement englishButton;



    public void acceptCookiesIfPresent() {
        List<WebElement> cookieButtons = driver.findElements(By.xpath("//button[text()='Elfogadom']"));
        if (!cookieButtons.isEmpty()) {
            cookieButtons.get(0).click();
        }
    }



}
