package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import fragment.HeaderFragment;

/**
 * Created by eugene on 26.03.2016.
 */
public class HomePage extends BasePage {

    @FindBy(css = "body")
    private WebElement body;


    private static String PAGE_URL = "www.google.com";

    @Override
    protected void setUp() {
        setUrl(PAGE_URL);
    }

    public String getBodyText() {
        return body.getText();
    }


    public HeaderFragment getHeaderFragment() {
        return new HeaderFragment();
    }


}
