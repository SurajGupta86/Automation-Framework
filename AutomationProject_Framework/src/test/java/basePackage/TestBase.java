package basePackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	//Creating a gloabla variables which is public and static that can be used through out the project.
	public static WebDriver driver;
	public static Properties config = new Properties();   // Configuration properties file where the fields are stored which will be used in our script
	public static Properties OR = new Properties();       //OR properties file where the locators of the particular fields are stored.
	public static FileInputStream fis;                     // Used to read the input from the above files
	
	@BeforeSuite
	public void SetUp() throws IOException {
		
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		config.load(fis);  //config properties file is loaded
		
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		OR.load(fis);  //OR properties file is loaded
		
		//User will check the browser field's value in the config properties file and then will open the particular browser 
		//We are using config.getProperty method for taking the field value and getting the respective value which is stored in the config file
		if(config.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();	 //Initializing the chromedriver
		}
		else if(config.getProperty("browser").equalsIgnoreCase("fireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();	  //Initializing the firefoxdriver
		}
		else if(config.getProperty("browser").equalsIgnoreCase("eDge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();	      //Initializing the  edgedriver
		}
		driver.get(config.getProperty("url"));  //Opening the site on which we are going to do the testing
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicitwait")), TimeUnit.MILLISECONDS);
		
	}
	
	@AfterSuite
	public void Close() {
		driver.quit();
	}
	
}
