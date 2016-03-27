package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.BasePage;
import pages.HomePage;
import pages.ProductsCreatePage;

public class CreateNewProductTest extends CommonBaseTest{
	
	private ProductsCreatePage productsCreatePage;
	private HomePage homePage;
	
	public CreateNewProductTest() {
		productsCreatePage = BasePage.getObject(ProductsCreatePage.class);
		homePage = BasePage.getObject(HomePage.class);
	}
	
	@Test
	public void test_45_create_simple_product(){
		//loginAs(loginname, password);
		productsCreatePage.gotoHomePage();
	}
	
	@Test
	public void test_45_create_simple__product(){
		//loginAs(loginname, password);
		productsCreatePage.assertCurrentPage();
		productsCreatePage.gotoHomePage();
		Assert.assertFalse(productsCreatePage.isCurrentPage(), "hdcdchdbchdhcb djncn");
		homePage.assertCurrentPage();
		homePage.getBodyText();
	}
	
	@Test
	@Parameters({"product_Name"})
	public void test_45_create_simple__product_parametrs(String productName){
		//loginAs(loginname, password);
		productsCreatePage.assertCurrentPage();
		productsCreatePage.gotoHomePage();
		Assert.assertFalse(productsCreatePage.isCurrentPage(), "hdcdchdbchdhcb djncn");
		homePage.assertCurrentPage();
		homePage.getBodyText();
	}
}
