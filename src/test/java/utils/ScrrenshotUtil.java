package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScrrenshotUtil
{
    public static void CaptureScreenShoot(WebDriver driver,String testName)throws IOException
    {
        File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File dest = new File("screenshots/" + testName + ".png");

        FileUtils.copyFile(src ,dest);

        System.out.println("screenshot Saved");
    }

}
