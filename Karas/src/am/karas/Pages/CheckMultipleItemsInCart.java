package am.karas.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckMultipleItemsInCart
{
    @FindBy(xpath="//a[contains(@href,'mashed-potatoes')]")
    private WebElement itemOneName;
    @FindBy(xpath="//a[contains(@href,'fried-potatoes')]")
    private WebElement itemTwoName;
    @FindBy(xpath="//a[contains(@href,'khachapuri-with-potatoes')]")
    private WebElement itemThreeName;
    @FindBy(css="body > div.container-main.home-page > div > div.padding.checkout-cont.ng-scope > div:nth-child(4) > div > div:nth-child(1) > div.col-md-10 > table > tbody > tr:nth-child(2) > td.ui-right.col-xs-3.col-sm-2.total.price-padding.ng-binding > span")
    private WebElement removeItem;
    public CheckMultipleItemsInCart(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }
    public String getOrderOneName()
    {
        return itemOneName.getText();
    }
    public String getOrderTwoName()
    {
        return itemTwoName.getText();
    }
    public String getOrderThreeName()
    {
        return  itemThreeName.getText();
    }
    public void clickRemove()
    {
        removeItem.click();
    }

    public boolean itemTwoExist()
    {
        return itemTwoName.isDisplayed();
    }
}
