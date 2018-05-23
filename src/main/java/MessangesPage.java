import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessangesPage {
    private WebDriver driver;

    public MessangesPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;

        new WebDriverWait(driver,5).
                until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[@class = 'b-nav__item__text b-nav__item__text_unread']"),
                        "Входящие"));
    }

    public LetterPage clickPreparedLetter(String theme) {
        String templateXpath = "//a[@data-subject = '%s']";
        driver.findElement((By.xpath(String.format(templateXpath,theme)))).click();;
        return new LetterPage(driver);
    }

}
