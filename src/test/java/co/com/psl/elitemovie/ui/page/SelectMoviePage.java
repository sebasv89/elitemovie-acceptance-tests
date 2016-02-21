package co.com.psl.elitemovie.ui.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import co.com.psl.elitemovie.ui.control.Button;
import co.com.psl.elitemovie.ui.control.Link;
import co.com.psl.elitemovie.ui.control.TextField;

public class SelectMoviePage extends AbstractPage {

	@FindBy(css = ".searchfield")
	private TextField _searchField;
	
	@FindBy(css = ".searchbtn")
	private Button _searchButton;
	
	private Link _searchResulLink;
	
	public SelectMoviePage(WebDriver driver) {
		super(driver);
	}

	public Link getSearchResulLink() {
		_searchResulLink = getMovieLinkByIndex(1);
		return _searchResulLink;
	}
	
	public Link getMovieLinkByIndex(int index) {
		_searchResulLink = new Link(getWebDriver().findElement(By.cssSelector(".movies.clearfix a:nth-child(" + index + ")")));
		return _searchResulLink;
	}

	public Button getSearchButton() {
		return _searchButton;
	}

	
	public TextField getSearchField() {
		return _searchField;
	}

	public List<Link> getAllSearchResults() 
	{
		List<WebElement> elements = getWebDriver().findElements(By.cssSelector(".movies.clearfix a"));
		List<Link> links = new ArrayList<Link>();
		
		for(WebElement element : elements)
		{
			links.add(new Link(element));
		}
		return links;
	}
}
