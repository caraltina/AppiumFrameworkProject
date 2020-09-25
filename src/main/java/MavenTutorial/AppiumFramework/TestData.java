package MavenTutorial.AppiumFramework;

import org.testng.annotations.DataProvider;

public class TestData {

	@DataProvider(name = "InputData")
	public Object[][] getDataForEditField()
	{
		//two sets of data 1. alphabets 2. Alphanumeric
		Object[][] obj = new Object[][] {
			
			{"Hello"}, {"Hello@1990"}
		};
		return obj;
	}
	
}

