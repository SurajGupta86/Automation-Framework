package testcases;

import static org.testng.Assert.*;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class assertClass {

	ChromeDriver driver = new ChromeDriver();

	SoftAssert softassert = new SoftAssert();

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // explicit wait

	@Test(priority = 1, groups="Sanity")
	public void Openbrowser() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Suraj Gupta\\Downloads\\Drivers\\chromedriver.exe");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // implicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // explicit wait
		driver.get("https://demoqa.com/");

		String actualtitle = driver.getTitle();
		String expectedtitle = "DEMOQA";
		Assert.assertEquals(expectedtitle, actualtitle); // Using Assertion for matching 2 strings.
		System.out.println("The text matches"); // If 2 strings are matched then this string is executed
	}

	@Test(priority = 2)
	public void verifytext() {

		boolean verify = driver.findElement(By.xpath("//img[@src='/images/Toolsqa.jpg']")).isDisplayed();
		Assert.assertTrue(verify, "The text is present"); // Checking whther the the above element is displayed on the
															// page
		System.out.println("The link is present"); // If the element is present then only it will run
	}

	@Test(priority = 3)
	public void softassert() {

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h5[text()='Elements']"))).click();
		driver.findElement(By.xpath("//span[text()='Text Box']")).click();

		boolean verifytextbox = driver.findElement(By.id("userName")).isDisplayed();
		softassert.assertTrue(verifytextbox);

		driver.findElement(By.id("userName")).sendKeys("Suru...");

		softassert.assertAll();
	}

	@Test(groups="Smoke")
	public void softAssert() {
		driver.navigate().to("https://www.browserstack.com/");
		String getActualTitle = driver.getTitle();
		Boolean verifyTitle = driver.getTitle()
				.equalsIgnoreCase("Most Reliable App & Cross Browser Testing Platform | BrowserStack");
		softassert.assertEquals(getActualTitle, "Most Reliable App & Cross Browser Testing Platform | BrowserStack");  //True
		softassert.assertNotEquals(getActualTitle, "Most Reliable App & Cross Browser Testing Platform | BrowserStack");  //False
		softassert.assertNull(verifyTitle); //False
		softassert.assertNotNull(verifyTitle);  //True
		softassert.assertTrue("BrowserStack".equals("Browserstack"), "First soft assert failed");  //False
		softassert.assertFalse("BrowserStack".equals("BrowserStack"), "Second soft assert failed");  //False
		softassert.assertAll();
	}
}
