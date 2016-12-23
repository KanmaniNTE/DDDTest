package temp;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReportFunction {
	public WebDriver wd=null;
	public ExtentReports report;//to generate reports
	public ExtentTest log;//store logs
@Test(priority=1)
public void googletest()
{
	wd=new FirefoxDriver();
	wd.get("https://www.google.co.in");
	report =new ExtentReports("C:\\SeleniumWorkspace\\DDDTest\\reports\\report.html");//extents report only support html format
	log=report.startTest("googletest");
	
}
@Test(priority=2)
public void yahootest()
{
	log=report.startTest("yahootest");
	wd.get("https://in.yahoo.com/");
	
}
@Test(priority=3)
public void gmailtest()
{
	log=report.startTest("gmailtest");
	wd.get("https://mvnrepository.com/artifact/com.relevantcodes/extentreports/2.41.2");
}
@AfterMethod
public void teardown(ITestResult it) throws IOException{//Itestresults will check to take screen shots of failed testcases
    
    if(it.isSuccess())
    {
    String path=takeScreenshot(it.getName());
    
    log.log(LogStatus.PASS, "testcase pass", log.addScreenCapture(path));
    }else
    {
        String path=takeScreenshot(it.getName());
        
        log.log(LogStatus.FAIL, "testcase pass", log.addScreenCapture(path));
     }
    report.endTest(log);
    report.flush();
}

public String takeScreenshot(String name) throws IOException{
   File src=((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
   File dst=new File("C:\\SeleniumWorkspace\\DDDTest\\screenshot"+name+".jpg");
   FileUtils.copyFile(src, dst);
   return dst.toString();   
}

}
