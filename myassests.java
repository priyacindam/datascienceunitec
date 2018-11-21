package seleniumdemos;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.firefox.FirefoxDriver;

public class myassests {
	public static void main(String[]args) {
    	//System.setProperty("webdriver.firefox.marionette","\"C:\\Users\\Priyanka\\Downloads\\geckodriver-v0.16.1-win64\\geckodriver.exe\"");
		//WebDriver driver = new FirefoxDriver();
		System.setProperty("webdriver.firefox.marionette","\"C:\\Users\\Priyanka\\Downloads\\geckodriver-v0.16.1-win64\\geckodriver.exe\"");
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "https://geo.argustracking.nz/";
        driver.get(baseUrl);
       
        WebElement email=driver.findElement(By.id("Email"));
        WebElement password=driver.findElement(By.id("Password"));
        email.sendKeys("priyanka@herontechnology.co.nz");
        password.sendKeys("priya1213");
        
        driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/form/div[4]/button")).click();
        driver.findElement(By.linkText("Reporting")).click();
        driver.findElement(By.xpath("/html/body/div[1]/section/div/form/fieldset/div[1]/div/div[1]/div/div[2]/img")).click();
        driver.findElement(By.cssSelector("#assetSearch_chosen > a.chosen-single > span")).click();
        driver.findElement(By.xpath("//div[@id='assetSearch_chosen']/div/ul/li[16]")).click();
        WebElement fromDate= driver.findElement(By.id("fromDate"));
        fromDate.clear();
        fromDate.sendKeys("8-Dec-2014"); 
       driver.findElement(By.id("submitBtn")).click();

     
        
       // WebElement dateBox=driver.findElement(By.id("col-md-12"));
      //dateBox.sendKeys("09102018");
       
        
        //Select select = new Select(driver.findElement(By.id("~Box A1")));
        //select.selectByValue("~Box U1");


        
       // Select dropdown1 = new Select(driver.findElement(By.xpath(“/html/body/div[1]/section/div/div[2]/form/div/div/div[1]/div”)));
        //dropdown1.selectByValue(“~Box A1”);
	}
        

}
