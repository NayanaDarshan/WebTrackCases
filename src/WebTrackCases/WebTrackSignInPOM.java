package WebTrackCases;

import org.testng.annotations.Test;
import page.classes.WebTrackLoginPagePOM;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class WebTrackSignInPOM {
  
	WebDriver driver;
	String URL = "http://warr-qa-bt39.solarsoft.local:8140/WebTrack/SignIn.aspx?SignOut=1";

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method");
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\jdk-13.0.1\\lib\\chromedriver.exe\\");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		driver.get(URL);
	}

	@Test
	public void WebTrackSignInPage() {
		//WebTrackLoginPagePOM.EntertextUsernamefield(driver, "Nayana");
		//WebTrackLoginPagePOM.EntertextPasswordfield(driver, "123");
		//WebTrackLoginPagePOM.SignInBtnAction(driver);
		WebTrackLoginPagePOM.ForgotPasswordLinkAction(driver);
		String PageName=driver.getTitle();
		System.out.println(PageName);
		Assert.assertEquals(PageName, "Reset Password | Web Track", "User navigate to Reset Password Page");
		
		WebTrackLoginPagePOM.EntertextResetUsernamefield(driver, "Nayana");
		WebTrackLoginPagePOM.ResetButtonClickAction(driver);
	}
	

	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
		//driver.close();
	}
	
}

  
 