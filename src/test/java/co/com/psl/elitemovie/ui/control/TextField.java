package co.com.psl.elitemovie.ui.control;

import org.openqa.selenium.WebElement;

public class TextField extends ElementImpl implements Element {

	private WebElement _webElement;
	
	public TextField(WebElement element)
	{
		super(element);
		_webElement = element;
	}
	
	public void setValue(String value)
	{
		_webElement.clear();
		_webElement.sendKeys(value);
	}
	
	public void getValue()
	{
		_webElement.getAttribute("value");
	}
}
