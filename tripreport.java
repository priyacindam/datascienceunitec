package assetreport;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class tripreport {
  private WebDriver driver;
   private String baseUrl;
   
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  
  
 

  
  @Parameters("browser")

  @BeforeClass
  public void setUp(String browser) throws Exception {
	  {
		  try
		  {
	  
	  if (browser.equalsIgnoreCase("Firefox")) {
	        driver = new FirefoxDriver();
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	        driver.manage().window().maximize();




	    }  if (browser.equalsIgnoreCase("Chrome")) {
		      System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		         driver = new ChromeDriver();
		         driver.manage().window().maximize();

		          driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		          }
  }

		  catch (WebDriverException e)

          {

                 System.out.println("Browser not found" +e.getMessage());

          }

		  baseUrl = "https://geo.argustracking.nz/";
          driver.get(baseUrl);

         
	  }
  }
  @Test

  public void testReport() throws Exception {
  
	  driver.get("https://geo.argustracking.nz/Account/Login?ReturnUrl=%2fDashboard");
	    driver.findElement(By.id("Email")).clear();
	    driver.findElement(By.id("Email")).sendKeys("priyanka@herontechnology.co.nz");
	    driver.findElement(By.id("Password")).clear();
	    driver.findElement(By.id("Password")).sendKeys("priya1213");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Please sign into the Argus Hub'])[1]/following::button[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='View History'])[1]/following::span[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Asset Reporting'])[1]/following::img[2]")).click();
	    Thread.sleep(500);
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Select Asset / Group'])[1]/following::span[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='~Box FMA110'])[3]/following::li[1]")).click();
	    driver.findElement(By.id("dateRange")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='This Month'])[1]/following::li[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Select Report Format'])[1]/following::span[1]")).click();
	  driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Export as Printer Friendly PDF'])[2]/following::li[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Select Output Type'])[1]/following::span[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Save as File'])[2]/following::li[1]")).click();
	    driver.findElement(By.id("submitBtn")).click();
	    Thread.sleep(5000);
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
