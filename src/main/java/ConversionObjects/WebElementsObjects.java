package ConversionObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebElementsObjects {
	
	public WebDriver driver;
	
	public WebElementsObjects(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"RadioButton\"]/label[2]")
	public static WebElement SeniorCitizenRadioButton;

	@FindBy(xpath = "//*[@id=\"FdepType\"]")
	public static WebElement payOut;

	@FindBy(xpath = "//*[@id=\"loan_amount\"]")
	public static WebElement loanAmount;

	@FindBy(xpath = "//*[@id=\"tenureYear\"]")
	public static WebElement tenureYear;

	@FindBy(xpath = "//*[@id=\"tenureMon\"]")
	public static WebElement tenureMonth;

	@FindBy(xpath = "//*[@id=\"tenureDays\"]")
	public static WebElement tenureDays;

	@FindBy(xpath = "//*[@id=\"ctl00_Body_C022_Col00\"]/div/div[3]/div[2]/div[1]/div/article[2]/div/div[1]/span[2]/span")
	public static WebElement interest;

	@FindBy(xpath = "//*[@id=\"ctl00_Body_C022_Col00\"]/div/div[3]/div[2]/div[1]/div/article[2]/div")
	public static WebElement result;

}
