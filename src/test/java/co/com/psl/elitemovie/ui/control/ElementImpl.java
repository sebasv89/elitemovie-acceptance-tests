package co.com.psl.elitemovie.ui.control;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;

public class ElementImpl implements Element {

	private WebElement _webElement;
	
	public ElementImpl(WebElement element) {
		_webElement = element;
	}
	
	public void clear() {
		_webElement.clear();
	}

	public void click() {
		_webElement.click();
	}

	public WebElement findElement(By arg0) {
		// TODO Auto-generated method stub
		return _webElement.findElement(arg0);
	}

	public List<WebElement> findElements(By arg0) {
		// TODO Auto-generated method stub
		return _webElement.findElements(arg0);
	}

	public String getAttribute(String arg0) {
		// TODO Auto-generated method stub
		return _webElement.getAttribute(arg0);
	}

	public String getCssValue(String arg0) {
		// TODO Auto-generated method stub
		return _webElement.getCssValue(arg0);
	}

	public Point getLocation() {
		// TODO Auto-generated method stub
		return _webElement.getLocation();
	}

	public Dimension getSize() {
		// TODO Auto-generated method stub
		return _webElement.getSize();
	}

	public String getTagName() {
		// TODO Auto-generated method stub
		return _webElement.getTagName();
	}

	public String getText() {
		// TODO Auto-generated method stub
		return _webElement.getText();
	}

	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		return _webElement.isDisplayed();
	}

	public boolean isEnabled() {
		
		return _webElement.isEnabled();
	}

	public boolean isSelected() {
		// TODO Auto-generated method stub
		return _webElement.isSelected();
	}

	public void sendKeys(CharSequence... arg0) {
		_webElement.sendKeys(arg0);
		
	}

	public void submit() {
		_webElement.submit();
	}


	public Coordinates getCoordinates() {
		return ((Locatable) _webElement).getCoordinates();
	}

	public Rectangle getRect() {
		// TODO Auto-generated method stub
		return null;
	}

	public <X> X getScreenshotAs(OutputType<X> arg0) throws WebDriverException {
		return _webElement.getScreenshotAs(arg0);
	}

}
