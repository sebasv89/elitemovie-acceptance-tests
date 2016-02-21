package co.com.psl.elitemovie.ui.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import co.com.psl.elitemovie.EliteMovieCleanDataUtils;
import cucumber.api.java.After;

public class SelectMovieTest extends EliteMovieTest { 
	
	@BeforeClass
	public void selectMovieTestBeforeClass()
	{
		getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void testSelectMovie() {
		
		getSelectMoviePageBehavior().selectMovieByIndex(1);
		
		getSelectSchedulePageBehavior().scheduleMovie("2017-03-02 18:00", "1");
		
		List<String> seats = new ArrayList<String>();
		seats.add("3,8");
		
		getSelectSeatsPageBehavior().selectSeats(seats);
		getConfirmationPageBehavior().formatReservationMessage(seats);
		
		String uiMessage = getConfirmationPageBehavior().getReservationMessage();
		
		// Create expected message.
		String expectedMessage = getConfirmationPageBehavior().formatReservationMessage(seats);
		
		Assert.assertEquals(uiMessage, expectedMessage, "Confirmation message");
		
		getConfirmationPageBehavior().getPage().getEndButton().click();
		
		// After transaction verification.
		getSelectMoviePageBehavior().selectMovieByIndex(1);
		getSelectSchedulePageBehavior().scheduleMovie("2017-03-02 18:00", "1");
		getSelectSeatsPageBehavior().verifySeats(seats);
	}


	@After
	public void cleanUp() throws IOException {
		EliteMovieCleanDataUtils.cleanAll();
	}


}
