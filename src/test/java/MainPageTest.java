
import org.junit.*;
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
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://mail.ru/");
        loginPage = PageFactory.initElements(driver,LoginPage.class);
    }

    @Test
    public void test(){
       MessangesPage messangesPage = loginPage.register("xodak2009", "Backd00r");
       LetterPage letterPage = messangesPage.clickPreparedLetter("Fwd: вакансия в CSI");

       String theme = letterPage.getLetterSubject();
       String sender = letterPage.getLetterSender();
       String content = letterPage.getLetterContent();

       try {
           Assert.assertEquals( "Fwd: вакансия в CSI", theme);
           Assert.assertEquals("игорь скоробогатый <stronginaheart@gmail.com>", sender);
           Assert.assertEquals("ТЗ для QA\n.pdf", content);
       }catch (ComparisonFailure e){
           System.out.println(e.getMessage());
           }

       letterPage.clickSignUp();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
