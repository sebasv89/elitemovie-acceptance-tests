package co.com.psl.elitemovie.ui.control;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Select extends ElementImpl implements Element {

	
	private WebElement _webElement;
	
	
	public Select(WebElement element) {
		super(element);
		_webElement = element;
	}
	
	public void selectByText(String text)
	{
		List<WebElement> options = _webElement.findElements(By.tagName("option"));
		
		for(WebElement option : options) 
		{
			if(option.getText().equals(text))
			{
				option.click();
				break;
			}
		}
	}

}
