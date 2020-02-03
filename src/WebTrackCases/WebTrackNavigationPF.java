package WebTrackCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTrackNavigationPF {

	WebDriver driver;

	@FindBy(xpath = "//a[contains(text(), 'Products')]")
	WebElement Productslink;

	@FindBy(id = "PageHeader_SearchBar_SearchTextBox")
	WebElement SearchProductTextfield;

	@FindBy(id = "PageHeader_SearchBar_SearchButton")
	WebElement ProductSearchBtn;

	public WebTrackNavigationPF(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	public void ProductSearchAction(String productname) {
		SearchProductTextfield.sendKeys(productname);
	}

	public void ProductSearchBtnAction() {
		ProductSearchBtn.click();
	}

	public void ProductLinkclick() {

		Productslink.click();
	}
}