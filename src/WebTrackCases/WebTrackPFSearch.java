package WebTrackCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import pageclasses.WebTrackNavigationPF;

public class WebTrackPFSearch {
	WebDriver driver;
	WebTrackNavigationPF WebtrackPagesearch;
	
	//WebDriver driver;
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
		WebtrackPagesearch = new WebTrackNavigationPF(driver);
		driver.get(URL);
	}

	@Test
	public void WebTrackProductSearch() {
		WebtrackPagesearch.ProductLinkclick();
		WebtrackPagesearch.ProductSearchAction("NRTEST03");
		WebtrackPagesearch.ProductSearchBtnAction();
	}
	

	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
		//driver.close();
	}
	
}


