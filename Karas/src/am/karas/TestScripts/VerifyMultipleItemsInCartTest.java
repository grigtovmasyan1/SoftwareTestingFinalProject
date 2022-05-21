package am.karas.TestScripts;

import am.karas.Pages.*;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utils.ScreenshotMethod;

import java.io.IOException;

public class VerifyMultipleItemsInCartTest extends Base
{
    @Test
    public void verifyMultipleItemsInCart()
    {
        try
        {
            ChooseDeliveryCenter cdc = new ChooseDeliveryCenter(driver);
            SearchFood sf = new SearchFood(driver);
            AddMoreItemsToCart addItems = new AddMoreItemsToCart(driver);
            CheckSingleItemInCart checkSingleItem = new CheckSingleItemInCart(driver);
            CheckMultipleItemsInCart foodsInCart = new CheckMultipleItemsInCart(driver);

            cdc.selectDeliveryCenter();
            cdc.isLoginButtonExist();
            sf.clickSearch();
            sf.enterFoodName("potato");

            addItems.addFirsItem();
            addItems.addMoreItems();

            checkSingleItem.clickFoodCart();

            String firstOrder = foodsInCart.getOrderOneName();
            String expectedFirstOrder = "Mashed potatoes";
            Assert.assertEquals(firstOrder,expectedFirstOrder);

            String secondOrder = foodsInCart.getOrderTwoName();
            String expectedSecondOrder = "Fried potatoes";
            Assert.assertEquals(secondOrder,expectedSecondOrder);

            String thirdOrder = foodsInCart.getOrderThreeName();
            String expectedThirdOrder = "Khachapuri with potatoes";
            Assert.assertEquals(thirdOrder,expectedThirdOrder);
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
