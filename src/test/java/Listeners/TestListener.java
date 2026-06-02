package Listeners;

import base.BaseTest;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ScrrenshotUtil;

public class TestListener implements ITestListener
{

    @Override
    public void onTestFailure(
            ITestResult result
    )
    {
        try{
            ScrrenshotUtil.CaptureScreenShoot(
             BaseTest.driver
            ,result.getName());
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
