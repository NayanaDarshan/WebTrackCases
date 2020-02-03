package WebTrackCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebTrackLoginPagePOM {
	
	public static WebElement element = null;
	
	public static WebElement UsernameTextbox(WebDriver driver) {
	    element= driver.findElement(By.id("PageBody_SignInControl_UserNameTextBox"));
		return element;
		
	}
	
	public static void EntertextUsernamefield(WebDriver driver, String data) {
	
		element =UsernameTextbox(driver);
		element.sendKeys(data);
}
	
	

	public static WebElement PasswordTextbox(WebDriver driver) {
	    element= driver.findElement(By.id("PageBody_SignInControl_PasswordTextBox"));
		return element;
		
	}
	
	public static void EntertextPasswordfield(WebDriver driver, String data1) {
	
		element =PasswordTextbox(driver);
		element.sendKeys(data1);
}
	
	public static WebElement SignInBtn( WebDriver driver) {
		element = driver.findElement(By.xpath("//span[contains(text(),'Sign In')]"));
		return element;
		
	}
	public static void SignInBtnAction(WebDriver driver) {
		element = SignInBtn(driver);
		element.click();
		
	}
	
	public static WebElement ForgotPasswordLinkIdentify( WebDriver driver) {
	 element= driver.findElement(By.xpath("//a[contains(text(), 'Forgot your')]"));
	 return element;
	
	}
	
	
	public static void ForgotPasswordLinkAction(WebDriver driver) {
		element= ForgotPasswordLinkIdentify(driver);
		element.click();
	}
	
	public static WebElement ResetUsernameTextbox(WebDriver driver) {
	    element= driver.findElement(By.id("PageBody_UserNameTextBox"));
		return element;
		
	}
	
	public static void EntertextResetUsernamefield(WebDriver driver, String data) {
	
		element =ResetUsernameTextbox(driver);
		element.sendKeys(data);
}
	
	public static WebElement ResteButtonIdentify( WebDriver driver) {
		
		element= driver.findElement(By.xpath("//span[contains(text(),'Reset Password')]"));
		return element;
	}
	
	public static void ResetButtonClickAction( WebDriver driver) {
		element=ResteButtonIdentify(driver);
		element.click();
	}
}


