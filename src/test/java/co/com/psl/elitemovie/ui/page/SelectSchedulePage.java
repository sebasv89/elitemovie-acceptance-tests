package co.com.psl.elitemovie.ui.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import co.com.psl.elitemovie.ui.control.Button;
import co.com.psl.elitemovie.ui.control.ElementImpl;
import co.com.psl.elitemovie.ui.control.Select;

public class SelectSchedulePage extends AbstractPage {

	@FindBy(id = "showTime")
	private Select _selectTime;
	
	@FindBy(name = "seats")
	private Select _selectSeats;
	
	@FindBy(css = ".btn.btn-success")
	private Button _continueButton;
	
	@FindBy(css = ".btn.btn-danger")
	private Button _cancelButton;
	
	public Select getSelectSeats() {
		return _selectSeats;
	}

	public SelectSchedulePage(WebDriver driver) {
		super(driver);
	}
	
	public Select getSelectTime() {
		return _selectTime;
	}
	
	public void selectTime(String text)
	{
		_selectTime.selectByText(text);
	}
	
	public void selectSeats(String seats)
	{
		_selectSeats.selectByText(seats);
	}

	public Button getContinueButton() {
		return _continueButton;
	}

	public ElementImpl getCancelButton() {
		return _cancelButton;
	}
	
}
