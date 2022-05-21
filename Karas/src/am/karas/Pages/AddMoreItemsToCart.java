package am.karas.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddMoreItemsToCart
{
        @FindBy(css="#\\31 8042703520002xls0-cm > div > div > div.prod-qty-btn > div > i.material-icons.increment.hvr-pop")
        private WebElement increment;
        @FindBy(xpath="//button[contains(@data-id,'18042703520002xls0')]")
        private WebElement firstItem;
        @FindBy(xpath="//button[contains(@data-id,'18042505290002xls0')]")
        private WebElement secondItem;
        @FindBy(xpath="//button[contains(@data-id,'18053004390002mgx0')]")
        private WebElement thirdItem;
        public AddMoreItemsToCart(WebDriver driver)
        {
            PageFactory.initElements(driver, this);
        }
        public void addFirsItem()
        {
            increment.click();
            firstItem.click();
        }
        public void addMoreItems()
        {
            secondItem.click();
            thirdItem.click();
        }
}
