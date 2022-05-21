package am.karas.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddItemToCart
{
    @FindBy(css="#\\31 8062502570002nep0-cm > div > a > div > img")
    private WebElement clickFoodImage;
    @FindBy(id="addButton")
    private WebElement clickAdd;
    public AddItemToCart(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }
    public void addFoodToFoodCart()
    {
        clickFoodImage.click();
        clickAdd.click();
    }
}
