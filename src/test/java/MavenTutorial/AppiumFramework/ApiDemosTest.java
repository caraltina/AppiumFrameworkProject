package MavenTutorial.AppiumFramework;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.Preferences;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ApiDemosTest extends Base {

	@Test(dataProvider="InputData", dataProviderClass=TestData.class)
	public void ApiDemos(String input) throws IOException {
		
		service = startServer();
		AndroidDriver<AndroidElement> driver = Capabilities("ApiDemos");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		HomePage h = new HomePage(driver);
		h.Preferences.click();
		
		Preferences p = new Preferences(driver);
		p.Dependency.click();
		
		p.WifiCheckBox.click();
		
		p.WifiSettings.click();
		
		p.WifiName.sendKeys(input);
		
		p.WifiConfirm.get(1).click();
		
		service.stop();
	}
	
	
}









