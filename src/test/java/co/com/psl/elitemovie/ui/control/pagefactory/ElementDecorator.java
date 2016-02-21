package co.com.psl.elitemovie.ui.control.pagefactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.internal.WrapsElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler;

import co.com.psl.elitemovie.ui.control.Element;

public class ElementDecorator extends DefaultFieldDecorator {

	/* factory to use when generating ElementLocator. */
    protected ElementLocatorFactory _factory;

    /* Constructor for an ElementLocatorFactory. */
    public ElementDecorator(ElementLocatorFactory factory) {
    	super(factory);
        this._factory = factory;
    }
    
   
    @Override
    public Object decorate(ClassLoader loader, Field field) {
        if (!(WebElement.class.isAssignableFrom(field.getType()) || isDecoratableList(field))) {
            return null;
        }
        ElementLocator locator = _factory.createLocator(field);
        if (locator == null) {
            return null;
        }
        Class<?> fieldType = field.getType();
        if (WebElement.class.equals(fieldType)) {
            fieldType = Element.class;
        }

        if (WebElement.class.isAssignableFrom(fieldType)) {
        	WebElement element = super.proxyForLocator(loader, locator);
            return instantiateElement(element, fieldType);
        } else if (List.class.isAssignableFrom(fieldType)) {
            return super.proxyForListLocator(loader, locator);
        } else {
            return null;
        }
    }

    
    public boolean isDecoratableList(Field field) {
        if (!List.class.isAssignableFrom(field.getType())) {
            return false;
        }
        if (field.getAnnotation(FindBy.class) == null && field.getAnnotation(FindBys.class) == null) {
            return false;
        }
        return true;
    }

   
    /* Generate a type-parameterized locator proxy for the element in question. */
    protected WebElement proxyForLocator(ClassLoader loader, ElementLocator locator) {
        InvocationHandler handler = new LocatingElementHandler(locator);

        WebElement proxy;
        proxy = (WebElement) Proxy.newProxyInstance(
                loader, new Class[]{Element.class, WebElement.class, WrapsElement.class, Locatable.class}, handler);
        return proxy;
    }

    
    @SuppressWarnings("rawtypes")
	private Object instantiateElement(WebElement element, Class elementClass)
    {
        try
        {
            Constructor<?>[] constructors = elementClass.getConstructors();

            for (Constructor<?> constructor : constructors)
            {
                Class<?>[] parameterTypes = constructor.getParameterTypes();
                if (parameterTypes.length == 1 && parameterTypes[0].isAssignableFrom(Element.class))
                {
                    return constructor.newInstance(element);
                }

            }

            return null;
        }
        catch (InstantiationException e)
        {
            throw new RuntimeException(e);
        }
        catch (IllegalAccessException e)
        {
            throw new RuntimeException(e);
        }
        catch (InvocationTargetException e)
        {
            throw new RuntimeException(e);
        }
    }

}
