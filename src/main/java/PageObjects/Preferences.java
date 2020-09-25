package PageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Preferences {

	
	public Preferences(AppiumDriver driver) {
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='3. Preference dependencies']")
	public WebElement Dependency;
	
	@AndroidFindBy(id = "android:id/checkbox")
	public WebElement WifiCheckBox;
	
	@AndroidFindBy(xpath = "(//android.widget.RelativeLayout)[2]")
	public WebElement WifiSettings;
	
	@AndroidFindBy(className = "android.widget.EditText")
	public WebElement WifiName;
	
	@AndroidFindBy(xpath = "//android.widget.Button")
	public List<WebElement> WifiConfirm;
	
	
}
