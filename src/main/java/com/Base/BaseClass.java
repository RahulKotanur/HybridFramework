package com.Base;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.Utility.PropertiesUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {
	public static WebDriver driver=null;
	public static Logger log=Logger.getLogger(BaseClass.class);
	public static ExtentReports report=null;
	public static ExtentTest test=null;
	public static ExtentSparkReporter spark=null;
	
	public static void initialization() throws Exception
	{
		log.info("Reading a browser");
		String browser=PropertiesUtils.readProperties("browser");
		if(browser.equals("chrome"));
		{
			System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
			driver=new ChromeDriver();
		}
		/*
		 * if(browser.equals("firefox")); { System.setProperty("webdriver.gecko.driver",
		 * "D:/geckodriver.exe"); driver=new FirefoxDriver(); }
		 */
		driver.manage().window().maximize();
		driver.get(PropertiesUtils.readProperties("url"));
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	public static void reportinit()
	{
	report=new ExtentReports();
	spark=new ExtentSparkReporter(System.getProperty("user.dir")+"/target/ExtentReport.html");
	report.attachReporter(spark);
	}
}

