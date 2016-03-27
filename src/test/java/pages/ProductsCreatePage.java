package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsCreatePage extends BasePage{

	private static String PAGE_URL = "http://erp-dev.realcpt.de/products/create";
	
	@FindBy(css = ".icon.fa.fa-home" )
	private WebElement homeMenu;
	
	@FindBy(css = ".sidebar-title")
	private WebElement homeSubMenu;
	
	public void gotoHomePage(){
		homeMenu.click();
		homeSubMenu.click();
	}
	
	@Override
	protected void setUp() {
		super.setUrl(PAGE_URL);
	}
}
