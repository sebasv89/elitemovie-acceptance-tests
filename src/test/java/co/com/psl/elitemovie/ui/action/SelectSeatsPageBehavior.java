package co.com.psl.elitemovie.ui.action;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import co.com.psl.elitemovie.ui.page.SelectSeatsPage;

public class SelectSeatsPageBehavior {

	private WebDriver _webDriver;
	
	private SelectSeatsPage _selectSeatsPage;
	
	public SelectSeatsPageBehavior(WebDriver driver) {
		_webDriver = driver;
	}
	
	public SelectSeatsPage getPage()
	{
		if(_selectSeatsPage == null)
		{
			_selectSeatsPage = new SelectSeatsPage(_webDriver);
		}
		return _selectSeatsPage;
	}
	
	public void selectSeats(List<String> seats)
	{
		
		for(String seat : seats)
		{
			Actions actions = new Actions(_webDriver);
			actions.click(getPage().getSeatLabel(seat));
			actions.perform();
		}
		
		getPage().getContinueButton().click();
	}
	
	
	public void verifySeats(List<String> seats)
	{
		
		for(String seat : seats)
		{
			Assert.assertFalse(getPage().getSeat(seat).isEnabled());
		}
	}
	
	public void verifySeatsSelected(List<String> seats)
	{
		
		for(String seat : seats)
		{
			getPage().getSeat(seat);
		}
	}

	public void cancelOperation() 
	{
		getPage().getCancelButton().click();
	}
}
