package PageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ItemsPage {
	
public ItemsPage(AppiumDriver driver) {
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))")
	//public WebElement scrollForItems;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/productName")
	public List<WebElement> countOfProducts;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/productAddCart")
	public List<WebElement> addToCart;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
	public WebElement checkout;
}
