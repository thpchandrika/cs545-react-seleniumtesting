package withpageobject.producttest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ProductListPage {

    private WebDriver driver;

    @FindBy(id = "personName")
    private WebElement personName;

    ProductListPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPersonName(){
        return personName.getText();
    }

    public void verfiyDisplayedUser(String personName){
        assertThat(getPersonName(), is(personName));
    }

}
