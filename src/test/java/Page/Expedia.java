package Page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Expedia {
	WebDriver driver;

	By expediaflight=By.xpath("//*[@id=\"wizardMainRegionV2\"]/div/div/div/div/ul/li[2]/a/span");
	By expedialeavingfrom=By.xpath("//*[@id=\"location-field-leg1-origin-menu\"]/div/div/div[1]/button");
	By expediawhereareyouleavingfrm=By.id("location-field-leg1-origin");
	By expediagoingto=By.xpath("//*[@id=\"location-field-leg1-destination-menu\"]/div/div/div[1]/button");
	By expediawhereareyougoingto=By.xpath("//*[@id=\"location-field-leg1-destination\"]");
	By expediatraveler=By.xpath("//*[@id=\"adaptive-menu\"]/button");
	//By expediatravelleradlt=By.xpath("//*[@id=\"adaptive-menu\"]/div/div/div/div[2]/section/div[1]/div[1]/label/span");
	By expediatraveleradult=By.xpath("//*[@id=\"adaptive-menu\"]/div/div/div/div[2]/section/div[1]/div[1]/div/button[2]");
	By expediatravelerchild=By.xpath("//*[@id=\"adaptive-menu\"]/div/div/div/div[2]/section/div[1]/div[2]/div/button[2]/span");
	By expediatravelerage=By.xpath("//*[@id=\"child-age-input-0-0\"]");
	By expediatravelerdone=By.xpath("//*[@id=\"adaptive-menu\"]/div/div/div/div[3]/button");
	By expediaeconomy=By.id("preferred-class-input-trigger");
	By expediaeconomyfirstclass=By.xpath("//*[@id=\"preferred-class-input\"]/div/div/a[4]/span");
	By expediadeparting=By.id("d1-btn");
	By expediadepartingmonth=By.xpath("//*[@id=\"wizard-flight-tab-roundtrip\"]/div[2]/div[2]/div/div/div[1]/div/div[2]/div/div[1]/div[2]/div[1]/h2");
	By expediadepartingdate=By.xpath("//*[@id=\"wizard-lx-pwa-1\"]/div[2]/div[2]/div/div/div[1]/div/div[2]/div/div[1]/div[2]/div[1]/table/tbody/tr/td/button");
	By expediadepartingarrow=By.xpath("//*[@id=\"wizard-flight-tab-roundtrip\"]/div[2]/div[2]/div/div/div[1]/div/div[2]/div/div[1]/div[1]/button[2]");
	By expediadepartingdone=By.xpath("//*[@id=\"wizard-flight-tab-roundtrip\"]/div[2]/div[2]/div/div/div[1]/div/div[2]/div/div[2]/div/button");
	By expdeiareturning=By.xpath("//*[@id=\"d2-btn\"]");
	By expediareturningmonth=By.xpath("//*[@id=\"wizard-flight-tab-roundtrip\"]/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div[2]/div[1]/h2");
	By expediareturningdate=By.xpath("//*[@id=\"wizard-flight-tab-roundtrip\"]/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div[2]/div[1]/table/tbody/tr/td/button");
	By expediareturningarrow=By.xpath("//*[@id=\"wizard-flight-tab-roundtrip\"]/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/button[2]");
	By expediareturndone=By.xpath("//*[@id=\"wizard-flight-tab-roundtrip\"]/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[2]/div/button");
	public Expedia(WebDriver driver)
	{
		this.driver=driver;
	}
	public void flights()
	{
		driver.findElement(expediaflight).click();;
		
		
	}
	public void leaving(String leavingfrm)
	{
		driver.findElement(expedialeavingfrom).click();
		driver.findElement(expediawhereareyouleavingfrm).sendKeys(leavingfrm,Keys.ENTER);
		
	}


		

	public void goingt(String goingto)
	{
		driver.findElement(expediagoingto).click();
		driver.findElement(expediawhereareyougoingto).sendKeys(goingto,Keys.ENTER);
	}
	public void traveler()
	{
		driver.findElement(expediatraveler).click();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//driver.findElement(expediatravelleradlt);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(expediatraveleradult).click();
		driver.findElement(expediatravelerchild).click();
		WebElement age=driver.findElement(expediatravelerage);
		age.click();
		Select ageelement=new Select(age);
		ageelement.selectByVisibleText("3");
		driver.findElement(expediatravelerdone).click();

	}
	public void economy()
	{
		driver.findElement(expediaeconomy).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(expediaeconomyfirstclass).click();
	}
	public void deptreturn()
	{
		driver.findElement(expediadeparting).click();;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		while(true) {
			
		WebElement month=driver.findElement(expediadepartingmonth);
		
		//driver.findElement(expediadepartingdate);
		String mon=month.getText();
		if(mon.equals("June 2023"))
		{
			System.out.println(mon);
			break;
		}
		else
		{
			driver.findElement(expediadepartingarrow).click();	

		}
	   
		}
		
		List<WebElement> dates=driver.findElements(By.xpath("//*[@id=\"wizard-flight-tab-roundtrip\"]/div[2]/div[2]/div/div/div[1]/div/div[2]/div/div[1]/div[2]/div[1]/table/tbody/tr/td/button"));
		for(WebElement day:dates)
		{
		String dayname=	day.getAttribute("data-day");
		if(dayname.equals("22")) {
			day.click();
			//driver.findElement(expediadepartingdone).click();
			System.out.println("date selected");
		}
		
		}
		driver.findElement(expediadepartingdone).click();
		}
	public void returng()
	{
		driver.findElement(expdeiareturning).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		while(true) {
			WebElement monthrtng=driver.findElement(expediareturningmonth);
			String monrt=monthrtng.getText();
			if(monrt.equals("August 2023"))
			{
				System.out.println(monrt);
				break;
			}
			else
			{
				driver.findElement(expediareturningarrow).click();	

			}
		}
		List<WebElement> datertng=driver.findElements(expediareturningdate);
		for(WebElement dayrt:datertng)
		{
		String daynamert=	dayrt.getAttribute("data-day");
		if(daynamert.equals("22")) {
			dayrt.click();
			
			System.out.println("date selected");
		}
		
		}
		driver.findElement(expediareturndone).click();
	
		}
		}

