package co.com.psl.elitemovie.ui.action;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import co.com.psl.elitemovie.ui.page.SelectMoviePage;

public class SelectMoviePageBehavior {

	private SelectMoviePage _eliteMovieMainPage;
	
	private WebDriver _webDriver;
	
	public SelectMoviePageBehavior(WebDriver driver) {
		
		_webDriver = driver;
	}
	
	public void searchMovieAndSelectFirstOccurrence(String title)
	{
		getPage().getSearchField().setValue(title);
		getPage().getSearchButton().click();
		getPage().getSearchResulLink().click();
	}
	
	public void searchMovie(String title)
	{
		getPage().getSearchField().setValue(title);
		getPage().getSearchButton().click();
	}
	
	public void selectMovieByIndex(int index)
	{
		getPage().getMovieLinkByIndex(index).click();
	}
	
	public void verifyPageTitle(String title)
	{
		getPage().getTitle().getText().equals(title);
		Assert.assertEquals(getPage().getTitle().getText(), title);
	}
	
	public SelectMoviePage getPage() {
		
		if(_eliteMovieMainPage == null)
		{
			_eliteMovieMainPage = new SelectMoviePage(_webDriver);
		}
		return _eliteMovieMainPage;
	}

	public int getMoviesCount()
	{
		return getPage().getAllSearchResults().size();
	}
}
