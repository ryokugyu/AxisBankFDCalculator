package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import ConversionObjects.WebElementsObjects;

public class HomePage {

	public void selectSeniorCitizenOption(WebDriver driver) {
		WebElementsObjects.SeniorCitizenRadioButton.click();
	}

	public void selectPayoutOption(WebDriver driver) {
		WebElementsObjects.payOut.click();
	}

	public void enterDepositAmount(WebDriver driver) {
		WebElementsObjects.loanAmount.sendKeys("50000");
	}

	public void enterTimePeriod(WebDriver driver) {

		Select tenureYear = new Select(WebElementsObjects.tenureYear);
		tenureYear.selectByVisibleText("5"); // We have to select data from excel

		Select tenureMonth = new Select(WebElementsObjects.tenureMonth);
		tenureMonth.selectByVisibleText("8"); // We have to select data from excel

		WebElementsObjects.tenureDays.clear();
		WebElementsObjects.tenureDays.sendKeys("15");
	}

	public void showMaturityRate(WebDriver driver) {
		System.out.println("The maturity amount is: " + WebElementsObjects.result.getText());
		
		
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
