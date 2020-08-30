import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AltimetricUICoding {

	public static void main(String[] args) {
		
		//Open Browser
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SUDHANSHU\\Downloads\\chromedriver_win32_v84\\chromedriver.exe");
		   WebDriver driver=new ChromeDriver();
		   driver.manage().window().maximize();
		   driver.get("https://www.cheapair.com/");
		   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		   driver.findElement(By.cssSelector("#tripTypeContainer > div > label:nth-child(2) > span.tgl-btn")).click();
		   driver.findElement(By.cssSelector("#to1")).sendKeys("Patna");
		   driver.findElement(By.xpath("#ui-id-30 > a > span")).click();
		   
      // Select date from calender and search
		   
		   driver.findElement(By.cssSelector("#to1")).click();
		   driver.findElement(By.cssSelector("#dates > span")).click();
		   driver.findElement(By.cssSelector("#datePickerContainer > div")).click();
		   driver.findElement(By.xpath("//*[@id=\"datePickerContainer\"]/div/div[2]/table/tbody/tr[3]/td[2]/a")).click();
		   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		   driver.findElement(By.cssSelector("#fltSearchForm > button")).click();
		   
		   
		   driver.findElement(By.cssSelector("#signUpForm > div.fltactmdl-signup-form-reg > span")).click();
		   
		   //Sort Price List
		   
		   List<WebElement> price=driver.findElements(By.cssSelector("#flightsResultsApp"));
		   
		   List<String> prices=new ArrayList<String>();
		   
		   for (WebElement e : price)
		   {
		       prices.add(e.getText());
		   }

		   // make a copy of the list
		   List<String> sortedPrices = new ArrayList<String>(prices);

		   // sort the list
		   Collections.sort(sortedPrices);

		   // true if the prices are sorted
		   System.out.println(sortedPrices.equals(prices));
		   
		   //Select tickets from the sorted list
		   
		   sortedPrices.get(0);
		   driver.findElement(By.cssSelector("#AI0 > div.fltrt-opt.flight-result-shell.flight-result-shell--with-3-columns > div.fltrt-opt-fares.flight-result-shell__fares-region.flight-result-shell__fares-region--with-3-columns > ol > li:nth-child(1) > div.btnfare.btn.withsub")).click();
		   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		   
		   
		   WebElement date=driver.findElement(By.cssSelector("#flightReviewTarget > div > div > div > div > div:nth-child(2) > div > div.card__CardHeaderStyled-ftm6kp-1.dkTXWn.src__Box-sc-1sbtrzs-0.hWjQTp > div > div.src__Box-sc-1sbtrzs-0.fsZetV"));
		   
		   //Verify date in next page
		   
		   System.out.println(date.equals("15"));
		   
		   //Screenshot of last page
		   
		    ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		   
	
			
		   
		   //Exit Browser
		   
		   driver.quit();
	

		   
		   

	}

}
