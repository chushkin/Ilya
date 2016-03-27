package fragment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import components.common.AbstractBaseComponent;

/**
 * Created by eugene on 26.03.2016.
 */
public class BaseFragment extends AbstractBaseComponent {

    private WebElement rootElement;
    private ComponentFactory componentFactory;


    protected void setRootElement(WebElement element) {
        rootElement = element;
    }

    protected WebElement getChildElement(By locator) {
        return getRootElement().findElement(locator);
    }

    protected WebElement getRootElement() {
        return rootElement;
    }

    public boolean isVisible() {
        return getRootElement().isDisplayed();
    }

}
