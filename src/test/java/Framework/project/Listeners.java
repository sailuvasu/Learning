package Framework.project;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReport;
import resources.base;

public class Listeners extends base implements ITestListener{
	ExtentTest test;
	ExtentReports extent=ExtentReport.getExtentReport();
	//for synchronizing 
	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	
		
		test=extent.createTest(result.getMethod().getMethodName(), "verification");
		extentTest.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//test.log(Status.PASS, "test passed");
		extentTest.get().log(Status.PASS, "test passed");
	
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		WebDriver driver=null;
		String testCaseName=result.getMethod().getMethodName();
		//test.log(Status.FAIL, result.getThrowable());
		extentTest.get().log(Status.FAIL, result.getThrowable());
	
		try {
			driver=	(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		try {
			
			String path=Screenshot(testCaseName,driver);
			extentTest.get().addScreenCaptureFromPath(path, result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	extent.flush();
	}
	
	

}
