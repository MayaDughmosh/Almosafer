package homePage;

import java.time.Duration;

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
	
}
