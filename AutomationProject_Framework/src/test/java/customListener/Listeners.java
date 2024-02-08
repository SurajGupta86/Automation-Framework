package customListener;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener{
	
	//Listener- To perform some actions automatically such as Test passed, test failed and screenshot should be captured.
	//ITestListener- A kind of Interface to access different methods.
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Case Passed");
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Case Failed");
	}
}
