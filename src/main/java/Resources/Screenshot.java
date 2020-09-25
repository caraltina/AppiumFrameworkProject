package Resources;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import MavenTutorial.AppiumFramework.Base;

public class Screenshot implements ITestListener {
	
	@Override
	public void onTestFailure(ITestResult result) {
		
		String s = result.getName();
		try {
			Base.getScreenShot(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
