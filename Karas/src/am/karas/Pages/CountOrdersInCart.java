package am.karas.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CountOrdersInCart
{
    @FindBy(css ="body > div.container-main.home-page > div > div.padding.checkout-cont.ng-scope > div:nth-child(4) > div > div:nth-child(1) > div.col-md-10 > table > tfoot > tr > td.ui-center.col-xs-2.col-sm-1.b.black.ng-binding")
    private WebElement countOrder;
    public CountOrdersInCart(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }
    public String getNumberOfItems()
    {
        return countOrder.getText();
    }
}
