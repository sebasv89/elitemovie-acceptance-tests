package co.com.psl.elitemovie.ui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import co.com.psl.elitemovie.ui.control.Button;

public class ConfirmationPage extends AbstractPage {
	
	@FindBy(className = "btn-success")
	private Button _endButton;

	public ConfirmationPage(WebDriver driver) {
		super(driver);
	}

	public Button getEndButton() 
	{
		return _endButton;
	}
	
	
	public String getSussesMessage()
	{
		return getWebDriver().findElement(By.className("alert-success")).getText();
	}

}
