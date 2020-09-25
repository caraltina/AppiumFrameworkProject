package PageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MainForm {

	public MainForm(AppiumDriver driver) {
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
	public WebElement name;
	
	@AndroidFindBy(xpath = "//*[@text='Female']")
	public WebElement gender;
	
	@AndroidFindBy(id = "android:id/text1")
	public WebElement clickCountryDropdown;
	
	//@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView(text(\"Canada\"));")
	//public List<WebElement> searchCountry;
	
	@AndroidFindBy(xpath = "//*[@text='Canada']")
	public WebElement selectCountry;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
	public WebElement letShop;
	
	public WebElement getName() {
		return name;
	}
}



