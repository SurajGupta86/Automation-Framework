package testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import basePackage.TestBase;

public class EmailSignIn extends TestBase{
	
	@Test
	public void Login() throws InterruptedException {
		driver.findElement(By.xpath(OR.getProperty("emailidpath"))).sendKeys("sg198374@gmail.com");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")).click();
		Thread.sleep(5000);
		
	}

}
