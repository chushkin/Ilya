package PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends Page{

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
}
