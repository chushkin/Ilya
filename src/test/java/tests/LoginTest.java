package tests;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import components.common.AbstractBaseComponent;
import pages.LoginPage;
import pages.ProductsCreatePage;

public class LoginTest extends CommonBaseTest{

	protected ProductsCreatePage productsCreatePage;
	
	protected LoginTest(){
		productsCreatePage = (ProductsCreatePage) AbstractBaseComponent.getObject(ProductsCreatePage.class);
	}
	
	@Test
	public void login(){
		loginAs("skif.samorityanin@gmail.com", "123456");
		productsCreatePage.assertCurrentPage();
		productsCreatePage.gotoHomePage();
	}
	
	@Test
	@Parameters({"username", "password"})
	public void test_2_loginWithParaeters(){
		
	}
}
