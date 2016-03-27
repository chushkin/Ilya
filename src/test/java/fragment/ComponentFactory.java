package fragment;

import org.openqa.selenium.WebElement;

/**
 * Created by eugene on 26.03.2016.
 */
public class ComponentFactory {

    public static  <T extends BaseFragment> T createFragment(WebElement rootElement, Class<T> type) {
        T instance = createFragment(type);
        instance.setRootElement(rootElement);
        return instance;
    }

    public static  <T extends BaseFragment> T createFragment(Class<T> type) {
        try {
            return type.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {

        }
        throw new IllegalStateException("Unable to create an instance of class " + type.getSimpleName());
    }


}
