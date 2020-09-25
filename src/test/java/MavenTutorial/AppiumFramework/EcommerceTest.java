package MavenTutorial.AppiumFramework;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.CheckOutPage;
import PageObjects.ItemsPage;
import PageObjects.MainForm;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;
import static org.testng.Assert.assertEquals;




public class EcommerceTest extends Base{

	@Test
	public void totalValidation() throws InterruptedException, IOException
	
	{
		service = startServer();
		AndroidDriver<AndroidElement> driver = Capabilities("GeneralStoreApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//main page
		MainForm mp = new MainForm(driver);
		mp.getName().sendKeys("My Name");
		//driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("My Name");
		driver.hideKeyboard();
		mp.gender.click();
		mp.clickCountryDropdown.click();
		
		Utilities u = new Utilities(driver);
		u.scrollCountry("Canada");
		//driver.findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Canada\"));");   
		mp.selectCountry.click();
		mp.letShop.click();
		
		//second page
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))"));
		ItemsPage ip = new ItemsPage(driver);
		int count = ip.countOfProducts.size();
		
		for(int i=0; i<count; i++)
		{
				ip.addToCart.get(i).click();
		}
		
		ip.checkout.click();
		Thread.sleep(4000);
		
		//optimized code checkout page
		CheckOutPage cop = new CheckOutPage(driver);
		int countCartItems = cop.countCartItems.size();
		double sumOfProducts = 0;
		
		for(int j=0; j<countCartItems; j++) {
			
			String amount1 = cop.amountOfItem.get(j).getText();
			double amount = getAmount(amount1);
			sumOfProducts = sumOfProducts + amount;
		}
		
		System.out.println("The sum of both the products is " +sumOfProducts);
		
		String total = cop.totalAmount.getText();
		String newTotal = total.substring(1);
		Double totalPrice = Double.parseDouble(newTotal);
		System.out.println("The total amount in the cart " +totalPrice);
	
		service.stop();
		//Assert.assertEquals(sumOfProducts, totalPrice);
			
		/*-----------------Mobile gestures-------------*/
		//tap
	/*	WebElement checkbox = driver.findElementByClassName("android.widget.CheckBox");
	    TouchAction t = new TouchAction(driver);
		t.tap(tapOptions().withElement(element(checkbox))).perform();
		
		//LongPress
		WebElement terms = driver.findElementByXPath("//*[@text='Please read our terms of conditions']");
		t.longPress(longPressOptions().withElement(element(terms)).withDuration(ofSeconds(2))).release().perform();
		driver.findElementById("android:id/button1").click();
		driver.findElementById("com.androidsample.generalstore:id/btnProceed").click();
		*/
		}

	
	@BeforeTest
	public void killAllNodes() throws IOException, InterruptedException {
		
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
	}
	
	public static double getAmount(String value) {
		
		value = value.substring(1);
		Double totalOfShoePair = Double.parseDouble(value);
		return totalOfShoePair;
		
	} 
}