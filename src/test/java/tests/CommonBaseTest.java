package tests;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

import components.common.AbstractBaseComponent;
import config.DriverSingleton;
import pages.LoginPage;

/**
 * Created by eugene on 26.03.2016.
 */
public class CommonBaseTest {

	private LoginPage loginPage;
	protected WebDriver driver = new DriverSingleton().getDriver();

	public CommonBaseTest() {
		loginPage = (LoginPage) AbstractBaseComponent.getObject(LoginPage.class);
	}

	protected void loginAs(String loginname, String password) {
		loginPage.open();
		loginPage.assertCurrentPage();
		loginPage.login(loginname, password);
	}

	@AfterMethod(alwaysRun = true)
	public void catchExceptions(ITestResult result) {
		try {

			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
			String methodName = result.getName();
			Reporter.setCurrentTestResult(result);
			if (!result.isSuccess()) {
				createScreenSelenium(methodName);
			}

		} catch (Exception e) {
			Reporter.log(e.toString());
		}
		Reporter.setCurrentTestResult(null);
		afterSuite();
	}

	private void createScreenSelenium(String methodName) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			String path = (String) ("failure_screenshots/selenium_" + methodName + "_"
					+ formater.format(calendar.getTime()) + ".png");
			FileUtils.copyFile(scrFile, new File("target/surefire-reports/" + path));
			Reporter.log("<br> <img src=" + path + " /> <br>");
			//Reporter.log("<br> <img src=..\\" + path + " /> <br>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void afterSuite() {
		try {
			if (driver != null) {
				driver.manage().deleteAllCookies();
				closeAllWindow();
			}
		} catch (Exception e) {
			afterSuiteQuit();
		}

	}

	@AfterSuite(alwaysRun = true)
	public void afterSuiteQuit() {
		if (driver != null)
			driver.quit();
		driver = null;
	}

	private void closeAllWindow() {
		int handlsSize = driver.getWindowHandles().size();
		for (int i = 1; i < handlsSize; i++) {
			driver.switchTo().window(driver.getWindowHandle()).close();
			switchToLastWindow();
		}
	}
	private void switchToLastWindow(){
		String domain = "";  
		for(String s: driver.getWindowHandles()){
			domain =s;
		}	
		driver.switchTo().window(domain);
	}
}
