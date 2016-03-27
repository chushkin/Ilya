package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import fragment.HeaderFragment;

/**
 * Created by eugene on 26.03.2016.
 */
public class LoginPage extends BasePage{

	private static String PAGE_URL = "http://erp-dev.realcpt.de";///auth/login";

	@FindBy(how = How.ID, using = "email")
	private WebElement loginInput;
	
	@FindBy(how = How.ID, using = "password")
	private WebElement passwordInput;
	
	@FindBy(how = How.CSS, using = "button.button")
	private WebElement signInButton;
	
	public void login(String login, String password){
		loginInput.clear();
		loginInput.sendKeys(login);
		passwordInput.clear();
		passwordInput.sendKeys(password);
		signInButton.click();
		
	}

    @Override
    protected void setUp() {
        setUrl(PAGE_URL);
    }

   
}
