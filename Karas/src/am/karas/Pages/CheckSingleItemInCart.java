package am.karas.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckSingleItemInCart
{
    @FindBy(css="body > div.container-main.home-page > header > div > div.header-right > div > a:nth-child(3) > i")
    private WebElement clickFoodCartIcon;

    @FindBy(css="#header_search > i")
    private WebElement searchIcon;
    @FindBy(xpath="//a[contains(@href,'pizza-karas-30cm')]")
    private WebElement itemName;
    public CheckSingleItemInCart(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }
    public void clickFoodCart()
    {
        clickFoodCartIcon.click();
    }

    public String getOrderName()
    {
        return itemName.getText();
    }
}
