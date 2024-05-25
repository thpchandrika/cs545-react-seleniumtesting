package withpageobject.producttest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterNamePage {

    private WebDriver driver;

    EnterNamePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "personName")
    private WebElement personName;

    @FindBy(id = "nextBtn")
    private WebElement nextBtn;

    public void open(){
        driver.get("http://localhost:3000");
    }

    public void close(){
        driver.close();
    }

    public void enterName(String name){
       personName.clear();
       personName.sendKeys(name);
    }

    public ProductListPage clickNext(){
       nextBtn.click();
       return  new ProductListPage(driver);
    }
}
