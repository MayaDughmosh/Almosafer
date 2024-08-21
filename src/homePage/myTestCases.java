package homePage;




import java.time.LocalDate;
import java.util.List;


import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;


import org.openqa.selenium.support.ui.Select;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class myTestCases extends Parameters {
	

	

	
	@BeforeTest 
	public void mySetup() {
		GeneralSetup();
	WebElement GreenButton=	driver.findElement(By.cssSelector(".sc-jTzLTM.hQpNle.cta__button.cta__saudi.btn.btn-primary"));
			GreenButton.click();
	}
	
	@Test (priority=1)
	public void checkTheDefaultlanguageIsEnglishTest() {
		String ActualDefaultLanguage=driver.findElement(By.tagName("html")).getAttribute("Lang");
		Assert.assertEquals(ActualDefaultLanguage, ExpectedDefaultLanguage);
		
	}
	@Test (priority=2)
	public void checkTheDefaultCurrencyIsSAR() {
		
		String  ActualCurrency=driver.findElement(By.xpath("//button[@data-testid='Header__CurrencySelector']")).getText();
	
	Assert.assertEquals(ActualCurrency, ExpectedCurrency);
		
	}
	@Test (priority =3)
	public void checkTheContactNumber() {
		
		String ActualContact=driver.findElement(By.tagName("strong")).getText();
		Assert.assertEquals(ActualContact, ExpectedContact);
	}
	@Test (priority=4)
	public void checkQtafflogo() {
		
		WebElement Footer=driver.findElement(By.tagName("footer"));
		WebElement logo=Footer.findElement(By.cssSelector(".sc-fihHvN.eYrDjb")).findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-ekulBa.eYboXF"));
		boolean TheActualResultForLogo=logo.isDisplayed();
		Assert.assertEquals(TheActualResultForLogo, ExpectedResultForTheLogo);
		
		
	}
	@Test (priority=5)
	public void CheckHotelSearchTabNotSelected() {
			String ActualResult=driver.findElement(By.id("uncontrolled-tab-example-tab-hotels")).getAttribute("aria-selected");
		Assert.assertEquals(ActualResult, ExpectedResultOfHotelsSelected);
	}
	
	@Test (priority=6)
	public void CheckDepature()
	{
		
	
	
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
		RandomSelectTheLanguageOfTheWebsite();
	}
	@Test (priority=8)
	public void FillHotelTab() {
	
	
		WebElement HotelsTab=driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		HotelsTab.click();
		
		
		WebElement SearchHotelsInput=driver.findElement(By.cssSelector(".sc-phbroq-2.uQFRS.AutoComplete__Input "));
		
		
		String WebsiteUrl=driver.getCurrentUrl();
		if (WebsiteUrl.contains("ar"))
		{
			SearchHotelsInput.sendKeys(ArabicCities[RandomArabic]);
			
		} else {
			SearchHotelsInput.sendKeys(EnglishCities[RandomEnglish]);
		}
			
		WebElement ListOfLocations=driver.findElement(By.cssSelector(".sc-phbroq-4.gGwzVo.AutoComplete__List "));
		
		WebElement FirstResult=ListOfLocations.findElements(By.tagName("li")).get(1);
		FirstResult.click();
	}
	 @Test (priority=9)
	 public void RandomlySelectTheNumberOfVistor() {
		 WebElement SelectorOfTheVistor=driver.findElement(By.xpath( " //select[@data-testid='HotelSearchBox__ReservationSelect_Select']"));
		 
		 Select select=new Select(SelectorOfTheVistor);
		 
		 int RandomIndex=rand.nextInt(2);
		 select.selectByIndex(RandomIndex);
		 
		 
		 
		 WebElement SearchButton=driver.findElement(By.xpath("//button[@data-testid='HotelSearchBox__SearchButton']"));
		 SearchButton.click();
		 
	 }
	


//	 @Test (priority=10)
	//	public void CheckThePageFullyLoaded( )    throws InterruptedException    {
		//	boolean ExpectedResult=true;
	//		Thread.sleep(10000);
//	String   Results=driver.findElement(By.xpath("//span[@data-testid='HotelSearchResult_resultsFoundCount']")).getText();
	//		
	//	boolean   finished=Results .contains(  "       وجدنا    ")|| Results.contains("found");
	//	Assert.assertEquals(finished,ExpectedResult);
			
	//	}
	
	
}
