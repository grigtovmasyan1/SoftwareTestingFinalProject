package am.karas.TestScripts;

import am.karas.Pages.ChooseDeliveryCenter;
import am.karas.Pages.Register;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utils.ScreenshotMethod;

import java.io.IOException;

public class VerifyRegistrationTest extends Base
{
    @Test
    public void verifyRegistration() throws IOException
    {
        try
        {
            ChooseDeliveryCenter cdc = new ChooseDeliveryCenter(driver);
            Register register = new Register(driver);

            cdc.selectDeliveryCenter();

            register.clickLoginButton();
            register.registrationInfo("John","Deer","35660528877","john@yahoo.com","pass12345!","pass12345!");

            Boolean isCheckboxSelected = register.isSelected();
            if(isCheckboxSelected == false)
            {
                register.clickCheckbox();
            }
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
