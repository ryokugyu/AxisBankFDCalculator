package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import ConversionObjects.WebElementsObjects;

public class HomePage {
	public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void selectSeniorCitizenOption() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOf(WebElementsObjects.SeniorCitizenRadioButton));
		WebElementsObjects.SeniorCitizenRadioButton.click();
	}

	public void selectPayoutOption() {
		Select payoutTerm = new Select(WebElementsObjects.payOut);
		payoutTerm.selectByVisibleText("Monthly Payout");
	}

	public void enterDepositAmount() {
		WebElementsObjects.loanAmount.sendKeys("50000");
	}

	public void enterTimePeriod() {

		Select tenureYear = new Select(WebElementsObjects.tenureYear);
		tenureYear.selectByVisibleText("5"); // We have to select data from excel

		Select tenureMonth = new Select(WebElementsObjects.tenureMonth);
		tenureMonth.selectByVisibleText("8"); // We have to select data from excel

		WebElementsObjects.tenureDays.clear();
		WebElementsObjects.tenureDays.sendKeys("15");
	}

	public String showMaturityRate() {
		
		return WebElementsObjects.result.getText();
		
		
		/* Method to fetch all the details
		List<WebElement> res = driver.findElements(By.xpath("//*[@id=\"ctl00_Body_C022_Col00\"]/div/div[3]/div[2]/div[1]/div/article[2]/div"));
		for(WebElement e: res) {
			
			if(e.getText().equalsIgnoreCase("Rate of Interest*")) {
				System.out.println(e.getText());
				
			}
		}
		*/
	}

}
