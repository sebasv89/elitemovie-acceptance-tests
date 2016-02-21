package co.com.psl.elitemovie.ui.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import co.com.psl.elitemovie.ui.control.Label;
import co.com.psl.elitemovie.ui.control.pagefactory.ElementFactory;

public abstract class AbstractPage extends ElementFactory {
	
	private WebDriver _webDriver;

	public AbstractPage(WebDriver driver) {
		_webDriver = driver;
		super.initElements(driver, this);
	}

	@FindBy(tagName = "h1")
	private Label _pageTitle;
	
	public Label getTitle() {
		return _pageTitle;
	}

	public WebDriver getWebDriver() {
		return _webDriver;
	}
}
