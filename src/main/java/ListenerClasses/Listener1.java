package ListenerClasses;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listener1 implements ITestListener{
	
	public void onTestStart(ITestResult result) {
   System.out.println(result.getName()+" Test Started");
//	    
//	   Reporter.log(result.getName()+" Test Started");
	   //Reporter.getCurrentTestResult();
	  // Reporter.log(Reporter.getCurrentTestResult()+" Test Started");
	    
	  }
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getName()+" Test Passed");
		 //Reporter.log(Reporter.getCurrentTestResult() +"  Test Passed");
		 //Reporter.getCurrentTestResult();
	  }
	
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getName()+" Test Failed");
		//Reporter.log(Reporter.getCurrentTestResult() +"  Test Failed");
		 //Reporter.getCurrentTestResult();
	  }
	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getName()+" Test Skipped");
		//Reporter.log(Reporter.getCurrentTestResult() +"  test skipped");
		 //Reporter.getCurrentTestResult();
	  }

}
