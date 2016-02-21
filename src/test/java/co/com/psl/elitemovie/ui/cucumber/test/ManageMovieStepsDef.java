package co.com.psl.elitemovie.ui.cucumber.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import co.com.psl.elitemovie.ui.test.EliteMovieTest;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ManageMovieStepsDef extends EliteMovieTest {


	@Given("^The User enters into the application$")
	public void The_User_enters_into_the_application() throws Throwable 
	{
		init();
	}

	@When("^Enters into \"([^\"]*)\" section$")
	public void Enters_into_section(String title) throws Throwable 
	{
		getSelectMoviePageBehavior().verifyPageTitle(title);
	}

	@When("^Select the number (\\d+) choice of the results$")
	public void Select_the_number_choice_of_the_results(int index) throws Throwable 
	{
		getWebDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		getSelectMoviePageBehavior().selectMovieByIndex(index);
	}

	@Then("^The Actual and future functions must be displayed.$")
	public void The_Actual_and_future_functions_must_be_displayed() throws Throwable 
	{
		Date date = new Date();
		getSelectSchedulePageBehavior().verifyShowTimes(date);
	}

	@When("^Search movie \"([^\"]*)\"$")
	public void Search_movie(String movieTitle) throws Throwable 
	{
		getSelectMoviePageBehavior().searchMovie(movieTitle);
	}

	@Then("^(\\d+) movies must be displayed$")
	public void movies_must_be_displayed(int count) throws Throwable 
	{
		 Assert.assertEquals(getSelectMoviePageBehavior().getMoviesCount(), count);
	}

	@When("^Select showtime \"([^\"]*)\"$")
	public void Select_showtime(String time) throws Throwable 
	{
		getSelectSchedulePageBehavior().selectShowTime(time);
	}

	@When("^Select numbers of seats \"([^\"]*)\"$")
	public void Select_numbers_of_seats(String seatsNumber) throws Throwable 
	{
	    getSelectSchedulePageBehavior().selectSeats(seatsNumber);
	}

	@When("^Select the seats in room$")
	public void Select_the_seats_in_room(DataTable seatPosition) throws Throwable 
	{
		List<String> seats = new ArrayList<String>();
		List<List<String>> data = seatPosition.raw();
		String seat = data.get(1).get(0) + "," + data.get(1).get(1); 
		seats.add(seat);
		
		getSelectSeatsPageBehavior().selectSeats(seats);
	}

	@Then("^The success message should be displayed \"([^\"]*)\"$")
	public void The_success_message_should_be_displayed(String message) throws Throwable 
	{
		String confirmMessage = getConfirmationPageBehavior().getReservationMessage();
		Assert.assertEquals(confirmMessage, message, "Seats selected message");
	}

	@After
	public void afterClassManageMovieStepsDef()
	{
		super.close();
	}
	
}
