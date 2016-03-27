package fragment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by eugene on 26.03.2016.
 */
public class HeaderFragment extends BaseFragment {

    @FindBy(css = "div#gb")
    private WebElement root;

    private By userName = By.cssSelector("span.gb_P");
    private By notifications = By.cssSelector("span.gb_oc");

    @Override
    protected void setUp() {
        setRootElement(root);
    }

    public String getUserName() {
        return getChildElement(userName).getText();
    }

    public String getNotifications() {
        return getChildElement(notifications).getText();
    }

}
