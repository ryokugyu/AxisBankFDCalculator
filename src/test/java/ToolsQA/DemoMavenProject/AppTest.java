package ToolsQA.DemoMavenProject;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;

import com.utilities.ReadConfigurationFile;

public class AppTest

{
	public WebDriver driver;
	
	Properties prop = ReadConfigurationFile.readConfiguration();
			
	@BeforeTest
	public void invokeBrowser() {
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		
		System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriverLocation"));
		driver = new ChromeDriver(options);
		
		driver.get(prop.getProperty("baseURL")); // get this link from settings.properties file
		driver.manage().window().maximize();
		

	}
}
