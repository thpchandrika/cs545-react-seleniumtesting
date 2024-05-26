package withpageobject.demodotnopcommercedotcomtest;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EcommerceRegistrationTest {

    private static RegisterPage registerPage;
    private  static  WebDriver driver;

    @BeforeClass
    public  static void createWebDriver() {
        // set path to chromedriver.exe
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\SeleniumChromeDriver\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\Chandrika Thapa\\Downloads\\chrome-headless-shell-win64\\chrome-headless-shell-win64\\chrome-headless-shell.exe");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        registerPage = new RegisterPage(driver);
    }

    @AfterClass
    public static void closeTheBrowser() {
        registerPage.close();
    }

    @Test
    public void testRegister1() {
        registerPage.open();
       registerPage.clickFemale();
       registerPage.enterName("Chandrika", "Thapa");
       registerPage.enterCompany("Ekbana");
       registerPage.enterUniqueEmail();
       registerPage.enterDateOfBirth("16", "8", "1994");
       registerPage.enterPassword("Han@123");
       RegistrationResultPage registrationResultPage = registerPage.registerBtnClick();
       //Three types of waits: implicit, explicit and FluentWait; explicit and fluent is preferred
       WebDriverWait wait = new WebDriverWait(driver, 10); //explicit wait
       wait.until(ExpectedConditions.urlContains("/registerresult"));
       registrationResultPage.verifyRegistration("Your registration completed");
    }

    @Test
    public void testRegister2() {
        registerPage.open();
        registerPage.clickFemale();
        registerPage.enterName("Raman", "GC");
        registerPage.enterCompany("VErisk");
        registerPage.enterUniqueEmail();
        registerPage.enterDateOfBirth("19", "9", "1995");
        registerPage.enterPassword("Han@123");
        RegistrationResultPage registrationResultPage = registerPage.registerBtnClick();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("/registerresult"));
        registrationResultPage.verifyRegistration("Your registration completed");
    }
}
