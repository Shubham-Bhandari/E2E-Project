 package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Base {
	public WebDriver driver;
	public Properties prop;
	
	
	public static ExtentSparkReporter htmlReporter = new ExtentSparkReporter("./Report/extent.html");
	public static ExtentReports extent = new ExtentReports();
	public static ExtentTest logger1;
	public static ExtentTest logger2;
	
	public WebDriver initializeDriver() throws Throwable
	{
		extent.attachReporter(htmlReporter); 
		prop= new Properties();
		FileInputStream fs= new FileInputStream("D://Selenium Projects//E2EProject//src//main//java//resources//data.properties");
		prop.load(fs);
		
		String browserName=prop.getProperty("browser");
		System.out.println(browserName);
		
		
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","D://Selenium Jar Files//chromedriver.exe");
			driver= new ChromeDriver();
			driver.manage().window().maximize();
			
		}
	
		else if (browserName.equals("firefox"))
		{
			driver= new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	
	public static String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException
	{TakesScreenshot ts=(TakesScreenshot) driver;
	File source =ts.getScreenshotAs(OutputType.FILE);
	String destinationFile = System.getProperty("user.dir")+"/reports/"+testCaseName+".png";
	File destination= new File(destinationFile);
	
	
	try
	{
	FileUtils.copyFile(source, destination);
	}
	catch (Exception e)
	{
		
	}
	return destinationFile;
	
	
	}

}
