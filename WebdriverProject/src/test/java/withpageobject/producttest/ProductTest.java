package withpageobject.producttest;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class ProductTest {

    private WebDriver driver;

    private static EnterNamePage enterNamePage;

    private static ProductListPage productListPage;

    @Before
    public void createWebDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\SeleniumChromeDriver\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\Chandrika Thapa\\Downloads\\chrome-headless-shell-win64\\chrome-headless-shell-win64\\chrome-headless-shell.exe");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        enterNamePage = new EnterNamePage(driver);
    }

    @AfterClass
    public static void closeTheBrowser() {
        enterNamePage.close();
    }

    @Test
    public void shouldShowNameInProductList(){
        enterNamePage.open();
        enterNamePage.enterName("Chandrika");
        productListPage = enterNamePage.clickNext();
        productListPage.verfiyDisplayedUser("Chandrika");
    }
}
