package homePage;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class myTestCases {

	WebDriver driver=new ChromeDriver();
	String AlmosaferUrl="https://global.almosafer.com/en";
	String ExpectedDefaultLanguage="en";
	Random rand=new Random();
	@BeforeTest 
	public void mySetup() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(AlmosaferUrl);
		driver.findElement(By.cssSelector(".sc-jTzLTM.hQpNle.cta__button.cta__saudi.btn.btn-primary")).click();
	}
	
	@Test (priority=1)
	public void checkTheDefaultlanguageIsEnglishTest() {
		String ActualDefaultLanguage=driver.findElement(By.tagName("html")).getAttribute("Lang");
		Assert.assertEquals(ActualDefaultLanguage, ExpectedDefaultLanguage);
		
	}
	@Test (priority=2)
	public void checkTheDefaultCurrencyIsSAR() {
		String ExpectedCurrency="SAR";
		WebElement Currency=driver.findElement(By.xpath("//button[@data-testid='Header__CurrencySelector']"));
	String ActualCurrency=	Currency.getText();
	Assert.assertEquals(ActualCurrency, ExpectedCurrency);
		
	}
	@Test (priority =3)
	public void checkTheContactNumber() {
		String ExpectedContact="+966554400000";
		String ActualContact=driver.findElement(By.tagName("strong")).getText();
		Assert.assertEquals(ActualContact, ExpectedContact);
	}
	@Test (priority=4)
	public void checkQtafflogo() {
		boolean ExpectedResultForTheLogo=true;
		WebElement Footer=driver.findElement(By.tagName("footer"));
		WebElement logo=Footer.findElement(By.cssSelector(".sc-fihHvN.eYrDjb")).findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-ekulBa.eYboXF"));
		boolean TheActualResultForLogo=logo.isDisplayed();
		Assert.assertEquals(TheActualResultForLogo, ExpectedResultForTheLogo);
		
		
	}
	@Test (priority=5)
	public void CheckHotelSearchTabNotSelected() {
		String ExpectedResultOfHotelsSelected="false";
		WebElement HotelsTab=driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		String ActualResult=HotelsTab.getAttribute("aria-selected");
		Assert.assertEquals(ActualResult, ExpectedResultOfHotelsSelected);
	}
	
	@Test (priority=6)
	public void CheckDepature()
	{
		LocalDate todayDate=LocalDate.now();
		;
		int Today=todayDate.getDayOfMonth();
		int Tomorrow=todayDate.plusDays(1).getDayOfMonth();
		int TheDayAfterTomorrow=todayDate.plusDays(2).getDayOfMonth();
	
	
List <WebElement> depatureAndArrivalDates=driver.findElements(By.className("LiroG"));

String ActualDepatureDate=depatureAndArrivalDates.get(0).getText();

String ActualArrivalDate=depatureAndArrivalDates.get(1).getText();
	
int ActualDepatureDateAsInt=Integer.parseInt(ActualDepatureDate);
int ActualArivalDateAsInt=Integer.parseInt(ActualArrivalDate);

Assert.assertEquals(ActualDepatureDateAsInt, Tomorrow);
Assert.assertEquals(ActualArivalDateAsInt, TheDayAfterTomorrow);

	
		
		
	}
	@Test (priority =7)
	public void RandomlyChangeTheLanguage() {
		String [] URLs= {"https://global.almosafer.com/en","https://global.almosafer.com/ar"};
		int RandomUrl=rand.nextInt(URLs.length);
		driver.get(URLs[RandomUrl]);
	}
	
	
	
	
}
