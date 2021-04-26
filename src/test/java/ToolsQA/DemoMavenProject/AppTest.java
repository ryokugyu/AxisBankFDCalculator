package ToolsQA.DemoMavenProject;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.utilities.ReadConfigurationFile;
import PageClasses.HomePage;

public class AppTest

{
	public WebDriver driver;
	
	Properties prop = ReadConfigurationFile.readConfiguration();
	HomePage home = new HomePage(driver);;
	
	@BeforeTest
	public void invokeBrowser() {
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		
		System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriverLocation"));
		driver = new ChromeDriver(options);
		
		driver.get(prop.getProperty("baseURL")); // get this link from settings.properties file
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test(priority=0)
	public void testAxisFDCalculator() throws Exception {
		home.selectSeniorCitizenOption();
		home.selectPayoutOption();
		home.enterDepositAmount();
		home.enterTimePeriod();
		Assert.assertEquals(home.showMaturityRate(), "6.50%");;
	}
	
	@AfterTest
	public void closeDriver()
	{
		driver.close();
	}
	
}
