package withpageobject.demodotnopcommercedotcomtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage{

    private WebDriver driver;

    @FindBy(id = "gender-female")
    private WebElement genderFemale;

    @FindBy(id = "FirstName")
    private WebElement firstName;

    @FindBy(id = "LastName")
    private WebElement lastName;

    @FindBy(name = "DateOfBirthDay")
    private WebElement dateOfBirthDay;

    @FindBy(name = "DateOfBirthMonth")
    private WebElement dateOfBirthMonth;

    @FindBy(name = "DateOfBirthYear")
    private WebElement dateOfBirthYear;


    @FindBy(id = "Email")
    private WebElement email;


    @FindBy(id = "Company")
    private WebElement company;

    @FindBy(id = "Password")
    private WebElement password;

    @FindBy(id = "ConfirmPassword")
    private WebElement confirmPassword;

    @FindBy(id = "register-button")
    private WebElement registerButton;

    public  void clickFemale(){
        genderFemale.click();
    }

    public void enterName(String firstName, String lastName){
        this.firstName.click();
        this.firstName.sendKeys(firstName);
        this.lastName.click();
        this.lastName.sendKeys(lastName);
    }

    public void enterCompany(String company){
        this.company.click();
        this.company.sendKeys(company);
    }

    public  void enterUniqueEmail(){
       this.email.clear();
       this.email.sendKeys(createUniqueEmail());
    }

    public void enterDateOfBirth(String day, String month, String year){
        new Select(dateOfBirthDay).selectByValue(day);
        new Select(dateOfBirthMonth).selectByValue(month);
        new Select(dateOfBirthYear).selectByValue(year);
    }

    private String createUniqueEmail() {
        String email = "@gmail.com";
        String name = "frank" + createRandomNumber();
        return name + email;
    }

    public void enterPassword(String password){
        this.password.clear();
        this.password.sendKeys(password);
        this.confirmPassword.clear();
        this.confirmPassword.sendKeys(password);
    }

    public  RegistrationResultPage registerBtnClick(){
        registerButton.click();
        return  new RegistrationResultPage(driver);
    }

    private int createRandomNumber() {
        return (int) (Math.random() * 5000 + 1);
    }


    RegisterPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void open(){
        driver.get("https://demo.nopcommerce.com/register");
    }

    public void close(){
        driver.close();
    }
}
