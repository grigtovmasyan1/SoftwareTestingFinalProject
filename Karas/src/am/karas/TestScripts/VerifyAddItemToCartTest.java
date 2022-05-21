package am.karas.TestScripts;

import am.karas.Pages.ChooseDeliveryCenter;
import am.karas.Pages.SearchFood;
import am.karas.Pages.AddItemToCart;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utils.ScreenshotMethod;
import java.io.IOException;

public class VerifyAddItemToCartTest extends Base
{
    @Test
    public void verifyAddItemToCart() throws IOException
    {
        try {
                ChooseDeliveryCenter cdc = new ChooseDeliveryCenter(driver);
                SearchFood sf = new SearchFood(driver);
                AddItemToCart slf = new AddItemToCart(driver);

                cdc.selectDeliveryCenter();
                cdc.isLoginButtonExist();

                sf.clickSearch();
                sf.enterFoodName("pizza");

                String actualText = sf.getConfirmationText();
                String expectedText = "pizza";
                Assert.assertEquals(actualText, expectedText);

                slf.addFoodToFoodCart();
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

