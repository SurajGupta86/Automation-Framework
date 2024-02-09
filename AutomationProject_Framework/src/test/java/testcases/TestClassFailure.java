package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClassFailure {
	
	@Test
	public void FailLogin() {
		Assert.fail("Failing login test");
		System.out.println("Capture screenshot");
	}

}
