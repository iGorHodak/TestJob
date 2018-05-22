import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LetterPage {
    private WebDriver driver;

    public LetterPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;

        new WebDriverWait(driver,5).
                until(ExpectedConditions.titleIs("Почта Mail.Ru"));
    }


    @FindBy(xpath = "//div[@class='b-letter__head__subj__text']")
    private WebElement letterSubject;

    @FindBy(xpath = "//span[@class='b-contact-informer-target js-contact-informer']")
    private WebElement letterSender;

    @FindBy(xpath = "//div[@class='attachlist__thumb']")
    private WebElement letterContent;

    @FindBy(id = "PH_logoutLink")
    private WebElement signUpButton;

    public LoginPage clickSignUp() {
        signUpButton.click();
        return new LoginPage(driver);
    }

    public String getLetterSubject(){
        return letterSubject.getText();
    }

    public String getLetterSender(){
        return letterSender.getText();
    }

    public String getLetterContent(){
        return letterContent.getText();
    }
}
