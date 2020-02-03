package WebTrackCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class WebtrackAdmin {
   WebDriver driver;
   String BaseURL;
   String Title;
   
 
 
  @BeforeMethod
  public void Setup() {
	 
	  System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\jdk-13.0.1\\lib\\chromedriver.exe\\");
	  driver= new ChromeDriver();
	  //declaration of URL
	  BaseURL="http://warr-qa-bt39.solarsoft.local:8140/WebTrack/SignIn.aspx?SignOut=1";
	  driver.get(BaseURL);
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
	  driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
	    
}


 
  @Test
 // @Parameters({"Username"})
 
  public void UserLogin(String Username) {
	  
	  WebElement Loginname =driver.findElement(By.id("//input[@id='PageBody_SignInControl_UserNameTextBox']"));
	  Loginname.sendKeys("Nayana");
	  
	  //Login action
	  WebElement SignBtn=driver.findElement(By.xpath("//a[contains(text(), 'Sign')]"));
	  SignBtn.click();

	  //Logout action
	  
	  Title= driver.getTitle();
	  
	  //Assert.assertEquals(, expected);  

 
	  WebElement SignOutBtn= driver.findElement(By.xpath("//a[contains(text(), 'Sign Out')]"));
	  SignOutBtn.click();
			  
	    
  }
  
  @AfterMethod
  
  public void teardown() {
	  driver.close();
	  
  }
  
 

}
