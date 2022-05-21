package am.karas.TestScripts;

import am.karas.Pages.ChooseDeliveryCenter;
import am.karas.Pages.ClickHotDishes;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utils.ScreenshotMethod;

import java.io.IOException;
import java.time.Duration;

public class VerifySortItemsTest extends Base
{
    @Test
    public void verifySortItems()
    {
        try
        {
            ChooseDeliveryCenter cdc = new ChooseDeliveryCenter(driver);
            ClickHotDishes hd = new ClickHotDishes(driver);

            cdc.selectDeliveryCenter();

            hd.selectHotDishes();
            String actualText = hd.hotDishesText();
            String expectedText = "Hot dishes";
            Assert.assertEquals(actualText, expectedText);

            hd.clickHighPrice();
            String actualHighPrice = hd.highPriceValue();
            String expectedHighPrice = "4300 AMD";
            Assert.assertEquals(actualHighPrice,expectedHighPrice);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#\\31 9040104400002wlc0 > ins > span")));

            hd.clickLowPrice();
            String actualLowPrice = hd.lowPriceValue();
            String expectedLowPrice = "250 AMD";
            Assert.assertEquals(actualLowPrice,expectedLowPrice);
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
