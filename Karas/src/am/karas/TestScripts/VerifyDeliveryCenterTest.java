package am.karas.TestScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import am.karas.Pages.ChooseDeliveryCenter;
import utils.ScreenshotMethod;

public class VerifyDeliveryCenterTest extends Base
{
    @Test
    public void verifyDeliveryCenter() throws IOException
    {
        try
        {
            ChooseDeliveryCenter cdc = new ChooseDeliveryCenter(driver);

            cdc.selectDeliveryCenter();
            boolean loginExist = cdc.isLoginButtonExist();
            Assert.assertTrue(loginExist);
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