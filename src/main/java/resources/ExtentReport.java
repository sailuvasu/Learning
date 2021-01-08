package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	public static ExtentReports extent;
	
	public static ExtentReports getExtentReport(){
		
		
		String path=System.getProperty("user.dir")+"\\Reports\\Extent\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Report");
		reporter.config().setReportName("Automation results");
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		return extent;
	}
	

}
