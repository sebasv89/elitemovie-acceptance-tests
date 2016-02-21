package co.com.psl.elitemovie.ui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import co.com.psl.elitemovie.ui.control.Button;
import co.com.psl.elitemovie.ui.control.CheckBox;

public class SelectSeatsPage extends AbstractPage {

	private static final String SEATS_CSS = ".ng-scope label[for='%s']";
	private static final String SEATS_CHECKBOX_CSS = ".ng-scope input[id='%s']";
	
	private CheckBox _seat;
	
	@FindBy(className = "btn-danger")
	private Button _cancelButton;
	
	@FindBy(className = "btn-success")
	private Button _continueButton;
	
	public SelectSeatsPage(WebDriver driver) 
	{
		super(driver);
	}
	
	public CheckBox getSeat(String seat)
	{
		String locator = String.format(SEATS_CHECKBOX_CSS, seat);
		
		WebElement checkBox = getWebDriver().findElement(By.cssSelector(locator));
		_seat = new CheckBox(checkBox);
		return _seat;
	}
	
	public CheckBox getSeatLabel(String seat)
	{
		String locator = String.format(SEATS_CSS, seat);
		WebElement checkBox = getWebDriver().findElement(By.cssSelector(locator));
		_seat = new CheckBox(checkBox);
		return _seat;
	}
	
	public Button getCancelButton() {
		return _cancelButton;
	}

	public Button getContinueButton() {
		return _continueButton;
	}
}
