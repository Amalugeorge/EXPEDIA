package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class Baseclass {
	WebDriver driver;
	@BeforeClass
	public void browser()
		{
			driver=new ChromeDriver();
			driver.get("https://www.expedia.com/");
			driver.manage().window().maximize();
			
		}

}
