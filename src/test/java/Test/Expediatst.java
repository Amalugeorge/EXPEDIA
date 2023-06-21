package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Page.Expedia;



public class Expediatst {
	WebDriver driver;
	@BeforeTest
	public void browser()
		{
			driver=new ChromeDriver();
			driver.get("https://www.expedia.com/");
			driver.manage().window().maximize();
			
		}

	@Test
	public void testexpedia()
	{
		Expedia ob=new Expedia(driver);
		ob.flights();
		ob.leaving("brussels");
		ob.goingt("newyork");
		ob.traveler();
		ob.economy();
		ob.deptreturn();
		ob.returng();
		}
	
}
