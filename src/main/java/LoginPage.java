import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;

        new WebDriverWait(driver,5).
                until(ExpectedConditions.titleIs("Mail.Ru: почта, поиск в интернете, новости, игры"));
    }


    @FindBy(id = "mailbox:submit")
    private WebElement signInButton;

    @FindBy(id = "mailbox:login")
    private WebElement userName;

    @FindBy(id = "mailbox:password")
    private WebElement passwordField;

    public MessangesPage clickSignIn(){
        signInButton.click();
        return new MessangesPage(driver);
    }

    public LoginPage typeUserName(String username){
        userName.sendKeys(username);
        return this;
    }

    public LoginPage typePassword(String password){
        passwordField.sendKeys(password);
        return this;
    }

    public MessangesPage register(String username,String password){
        this.typeUserName(username);
        this.typePassword(password);
        this.clickSignIn();
        return new MessangesPage(driver);
    }
}
