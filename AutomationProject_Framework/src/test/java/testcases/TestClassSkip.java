package testcases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestClassSkip {
	
	@Test
	public void isskip() {
		throw new SkipException("Skipping test case");
		
	}

}
