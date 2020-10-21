package store;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pageObjects.LandingPage;
import resources.Base;

public class HomePage extends Base {
	
	
	ExtentTest logger;
	
	
	
	
	


	@BeforeTest
	public void initialize() throws Throwable {
		
		logger1=extent.createTest("loginTest");
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		

	}

	@Test
	public void Login() throws Throwable {

		LandingPage lp = PageFactory.initElements(driver, LandingPage.class);
		lp.loginTest();

	}
	
	@AfterMethod
	public void teardown(ITestResult result) throws IOException {
		if (ITestResult.FAILURE == result.getStatus()) 
		{
			String temp = Base.getScreenShotPath(result.getName(), driver);
			logger.fail(result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
	}

	@AfterTest
	public void teardown() {
		
		driver.close();
	}
}

