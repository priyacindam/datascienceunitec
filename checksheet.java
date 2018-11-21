package assetreport;


import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class checksheet {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUntitledTestCase() throws Exception {
    driver.get("https://geo.argustracking.nz/Account/Login?ReturnUrl=%2fDashboard");
    driver.findElement(By.id("Email")).clear();
    driver.findElement(By.id("Email")).sendKeys("priyanka@herontechnology.co.nz");
    driver.findElement(By.id("Password")).clear();
    driver.findElement(By.id("Password")).sendKeys("priya1213");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Please sign into the Argus Hub'])[1]/following::button[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Driver Behaviour'])[1]/following::span[1]")).click();
    driver.findElement(By.id("CheckSheet")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Filter by Asset'])[1]/following::span[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='~Desk FMB110'])[3]/following::li[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Start Date'])[1]/following::span[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Start Date'])[1]/following::th[1]")).click();
    driver.findElement(By.id("startDatePicker")).sendKeys("May 15, 2018");
    Thread.sleep(5000);   
    
  //  driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sa'])[1]/following::td[9]")).click();
    //driver.findElement(By.id("tbEndDate")).click();
    //driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='End Date'])[1]/following::span[2]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sa'])[1]/following::td[10]")).click();
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
