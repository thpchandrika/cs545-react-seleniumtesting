package withpageobject.demodotnopcommercedotcomtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RegistrationResultPage {

    private WebDriver driver;

    RegistrationResultPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "div.result")
    private WebElement registrationResult;

    public String getRegistrationResult(){
        return registrationResult.getText();
    }

    public void verifyRegistration(String expected){
        assertThat(getRegistrationResult(), is(expected));
    }
}
