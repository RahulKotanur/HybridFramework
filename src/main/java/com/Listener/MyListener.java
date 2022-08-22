package com.Listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Base.BaseClass;
import com.Utility.DriverUtils;
import com.aventstack.extentreports.Status;

public class MyListener extends BaseClass implements ITestListener{

	public void onTestStart(ITestResult result) {
		test=report.createTest(result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test case passed with name"+result.getName());
	}

	public void onTestFailure(ITestResult result){
		String path=DriverUtils.getScreenShot(result.getName());
		test.log(Status.FAIL, "Test case failed with name"+result.getName());
		test.addScreenCaptureFromPath(path);
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "Test case skipped with name"+result.getName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context) {
		log.info("Test suite ready for exicution");
		
	}

	public void onFinish(ITestContext context) {
		
		log.info("Test suite is successfully Exicuted");
		report.flush();
	}

}
