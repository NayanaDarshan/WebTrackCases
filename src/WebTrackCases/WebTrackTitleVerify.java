package WebTrackCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class WebTrackTitleVerify {

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
	public void VerifyHomePage() {
		System.out.println("The test method");

		WebElement Username = driver.findElement(By.xpath("//input[@id='PageBody_SignInControl_UserNameTextBox']"));
		Username.sendKeys("Nayana");

		WebElement SignBtn = driver.findElement(By.xpath("//a[@id='PageBody_SignInControl_SignInButton']"));
		SignBtn.click();

		String Page_Name = driver.getTitle();
		System.out.println(Page_Name);

		Assert.assertEquals(Page_Name, "Branch Selection | Web Track");
		System.out.println("The user is navigated to right Page");

		driver.findElement(By.xpath("//a[contains(text(), 'Sign Out')]"));
	}

	@Test(dependsOnMethods = { "VerifyHomePage" })
	public void VerifyCartPage() throws InterruptedException {
		WebElement Username1 = driver.findElement(By.xpath("//input[@id='PageBody_SignInControl_UserNameTextBox']"));
		Username1.sendKeys("Nayana");

		WebElement SignBtn1 = driver.findElement(By.xpath("//a[@id='PageBody_SignInControl_SignInButton']"));
		SignBtn1.click();

		WebElement CartLink = driver.findElement(By.xpath("//a[contains(text(), 'Items in basket')]"));
		CartLink.click();

		WebDriverWait wait = new WebDriverWait(driver, 30);

		WebElement Visibletext = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Items in your basket')] ")));

		// Empty the contents

		System.out.println("Empty button clicking.....");
		WebElement Btndisplay = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='PageBody_EmptyCartButtonTop']")));

		WebElement EmptyBtn = driver.findElement(By.xpath("//a[@id='PageBody_EmptyCartButtonTop']"));
		EmptyBtn.click();

		// Get the text of popup

		String Popuptext = driver.switchTo().alert().getText();
		System.out.println(Popuptext);

		driver.switchTo().alert().dismiss();
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
		driver.close();
	}

}
