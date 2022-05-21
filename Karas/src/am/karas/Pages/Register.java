package am.karas.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Register
{
    @FindBy(css="body > div.container-main.home-page > header > div > div.header-right > div > a.login.categories-button-shopping-cart > div")
    private WebElement login;
    @FindBy(name="signup.firstname")
    private WebElement fName;
    @FindBy(name="signup.lastname")
    private WebElement lName;
    @FindBy(name="signup.phone")
    private WebElement phone;
    @FindBy(name ="signup.email")
    private WebElement email;
    @FindBy(name="signup.password")
    private WebElement pass;
    @FindBy(name="signup.passwordreply")
    private WebElement rePass;
    @FindBy(css="body > div.container-main.home-page > div > div.padding > div > div.col-md-6 > div > div.b.ui-checkbox > div")
    private WebElement checkBox;
    public Register(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }
    public void clickLoginButton()
    {
        login.click();
    }
    public void registrationInfo (String firstName, String lastName, String phoneNum, String emailAdd, String pass1, String pass2)
    {
        fName.sendKeys(firstName);
        lName.sendKeys(lastName);
        phone.sendKeys(phoneNum);
        email.sendKeys(emailAdd);
        pass.sendKeys(pass1);
        rePass.sendKeys(pass2);
    }
    public boolean isSelected()
    {
        return checkBox.isSelected();
    }
    public void clickCheckbox()
    {
        checkBox.click();
    }
}
