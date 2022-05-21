package am.karas.TestScripts;

import am.karas.Pages.AddMoreItemsToCart;
import am.karas.Pages.CheckSingleItemInCart;
import am.karas.Pages.ChooseDeliveryCenter;
import am.karas.Pages.SearchFood;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utils.ScreenshotMethod;

import java.io.IOException;

public class VerifyAddMoreItemsToCartTest extends Base
{
    @Test
    public void verifyAddMoreItemsToCart()
    {
        try
        {
            ChooseDeliveryCenter deliveryCenter = new ChooseDeliveryCenter(driver);
            SearchFood sf = new SearchFood(driver);
            AddMoreItemsToCart addMoreFood = new AddMoreItemsToCart(driver);
            CheckSingleItemInCart checkCart = new CheckSingleItemInCart(driver);

            deliveryCenter.selectDeliveryCenter();
            deliveryCenter.isLoginButtonExist();

            sf.clickSearch();
            sf.enterFoodName("Potato");
            String actualText = sf.getConfirmationText();
            String expectedText = "Potato";
            Assert.assertEquals(actualText, expectedText);

            addMoreFood.addFirsItem();
            addMoreFood.addMoreItems();

            checkCart.clickFoodCart();
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    @AfterMethod
    public void takeScreenshotOnFailure(ITestResult testResult) throws IOException
    {
        if(testResult.getStatus() == ITestResult.FAILURE)
        {
            ScreenshotMethod.takeScreenshot("D:\\QATesting\\FailedTestingScreenshots", driver, "screenshot");
        }
    }
}
