package co.com.psl.elitemovie.ui.control.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class ElementFactory extends PageFactory {
    /* Initializes a page factory from a class with a template of Elements. */
    public static void initElements(WebDriver driver, Object page) {
            PageFactory.initElements(
                new ElementDecorator(
                    new DefaultElementLocatorFactory(driver)), page);
    }
}