package homePage;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Parameters {
	WebDriver driver=new ChromeDriver();
	String AlmosaferUrl="https://global.almosafer.com/en";
	String ExpectedDefaultLanguage="en";
	Random rand=new Random();
	String ExpectedCurrency="SAR";
	String ExpectedContact="+966554400000";
	boolean ExpectedResultForTheLogo=true;
	String ExpectedResultOfHotelsSelected="false";
	LocalDate todayDate=LocalDate.now();
	;
	int Today=todayDate.getDayOfMonth();
	int Tomorrow=todayDate.plusDays(1).getDayOfMonth();
	int TheDayAfterTomorrow=todayDate.plusDays(2).getDayOfMonth();
	
	
	String [] EnglishCities= {"Dubai","Jaddah","Riyad"};
	int RandomEnglish=rand.nextInt(EnglishCities.length);
	
	
	
	String [] ArabicCities=   { "   دبي",    "  جدة  " };
	int RandomArabic=rand.nextInt(ArabicCities.length);
	
	public void RandomSelectTheLanguageOfTheWebsite() {
		String [] URLs= {"https://global.almosafer.com/en","https://global.almosafer.com/ar"};
		int RandomUrl=rand.nextInt(URLs.length);
		driver.get(URLs[RandomUrl]);
	}
	
	public void GeneralSetup() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(AlmosaferUrl);
	
	}
}
