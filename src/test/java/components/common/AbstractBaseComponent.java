package components.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import config.DriverSingleton;
import fragment.BaseFragment;

/**
 * Created by eugene on 26.03.2016.
 */
public class AbstractBaseComponent {

    protected AbstractBaseComponent() {
    }

    private DriverSingleton driverSingleton = new DriverSingleton();

//    public static class Factory {
//
//        public static AbstractBaseComponent getObject() {
//            AbstractBaseComponent page = new AbstractBaseComponent();
//            page.initialize();
//            page.setUp();
//            return page;
//        }
//    }

    protected void initialize() {
        PageFactory.initElements(getDriver(), this);
    }

    protected void setUp() {

    }

    protected WebDriver getDriver() {
        return driverSingleton.getDriver();
    }
    
    public static  <T extends AbstractBaseComponent> T getObject(Class<T> type) {
        T instance = createObject(type);
        instance.initialize();
        instance.setUp();
        return instance;
    }

    public static  <T extends AbstractBaseComponent> T createObject(Class<T> type) {
        try {
            return type.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {

        }
        throw new IllegalStateException("Unable to create an instance of class " + type.getSimpleName());
    }



}
