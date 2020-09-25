package MavenTutorial.AppiumFramework;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Base {

	
	public AppiumDriverLocalService service;
	public static AndroidDriver<AndroidElement> driver;
	
	public AppiumDriverLocalService startServer() {
		
		boolean flag = checkIfServerIsRunning(4723);
		if(!flag) {
		//Start Appium Server
		service = AppiumDriverLocalService.buildDefaultService();
		service.start();
		}
		return service;
	}
	
	public static boolean checkIfServerIsRunning(int port) {
		
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		} catch (IOException e) {
			//If control comes here, then it means that the port is in it use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}
	
	//start emulator
	/* public static void startEmulator() throws IOException, InterruptedException {
		
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\java\\Emulator\\emulator.bat");
		Thread.sleep(6000);
	} */
	
	
	public static AndroidDriver<AndroidElement> Capabilities(String appName) throws IOException{
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\MavenTutorial\\AppiumFramework\\global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		prop.get(appName);
		
		
		// TODO Auto-generated method stub
		File f = new File("src");
		//File fs = new File(f,"General-Store.apk");
		File fs = new File(f,(String) prop.get(appName));
		
		DesiredCapabilities cap = new DesiredCapabilities();
		String emulator = (String) prop.get("device");
		//String emulator = System.getProperty("deviceName");//open emulator by maven command
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, emulator ); //open the emulator
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2"); //to access uiautomator2 elements of android
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath()); //open the app
	    driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);//connection to the server
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	} 
	
	public static void getScreenShot(String s) throws IOException {
		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(srcFile, new File("C:\\Users\\tina_\\Screenshots\\"+s+".png"));
		FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+"\\"+s+".png"));
	}
}
