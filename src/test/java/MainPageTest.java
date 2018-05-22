
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class MainPageTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUp(){
       // System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://mail.ru/");
        loginPage = PageFactory.initElements(driver,LoginPage.class);
    }

    @Test
    public void test(){
       MessangesPage messangesPage = loginPage.register("xodak2009", "Backd00r");
       LetterPage letterPage = messangesPage.clickPreparedLetter();
       String theme = letterPage.getLetterSubject();
       String sender = letterPage.getLetterSender();
       String content = letterPage.getLetterContent();
       Assert.assertEquals("Тема письма не совпадает","Fwd: вакансия в CSI", theme);
       Assert.assertEquals("Отправитель письма не совпадает","игорь скоробогатый <stronginaheart@gmail.com>", sender);
       Assert.assertEquals("Содержание письма не совпадает","ТЗ для QA\n.pdf", content);
       letterPage.clickSignUp();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
