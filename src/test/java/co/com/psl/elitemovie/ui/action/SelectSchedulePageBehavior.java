package co.com.psl.elitemovie.ui.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import co.com.psl.elitemovie.ui.page.SelectSchedulePage;

public class SelectSchedulePageBehavior {

	private WebDriver _webDriver;
	
	private SelectSchedulePage _selectschedulePage;
	
	public SelectSchedulePageBehavior(WebDriver driver) 
	{
		_webDriver = driver;
	}
	
	public void scheduleMovie(String time, String seatsNumber)
	{
		selectShowTime(time);
		selectSeats(seatsNumber);
	}
	
	public void selectShowTime(String time)
	{
		getPage().selectTime(time);
	}
	
	public void selectSeats(String seatsNumber)
	{
		getPage().selectSeats(seatsNumber);
		getPage().getContinueButton().click();
	}
	
	/*
	 * Get showTimes from UI and format them to dates to compare.
	 */
	public List<Date> getShowTimes()
	{
		
		String[] showTimes = getPage().getSelectTime().getText().split("\n");
		
		List<Date> dates = new ArrayList<Date>();
		for(String showTime : showTimes)
		{
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm");
			try 
			{
				Date parsedDate = formatter.parse(showTime);
				dates.add(parsedDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		return dates;
	}
	
	public SelectSchedulePage getPage()
	{
		if(_selectschedulePage == null)
		{
			_selectschedulePage = new SelectSchedulePage(_webDriver);
		}
		return _selectschedulePage;
	}
	
	
	public void verifyShowTimes(Date actualDate) throws InterruptedException
	{
		List<Date> showTimeDates = getShowTimes();
		
		for(Date date : showTimeDates)
		{
			Assert.assertTrue(date.after(actualDate), "Show time date is not after actual date");
		}
		
	}

	public void cancelOperation() 
	{
		getPage().getCancelButton().click();
	}
}
