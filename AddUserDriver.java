package testngpack;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AddUserDriver {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://geo.argustracking.nz/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUser() throws Exception {
	  driver.get(baseUrl + "/Account/Login?ReturnUrl=%2fDashboard");
	    driver.findElement(By.id("Email")).clear();
	    driver.findElement(By.id("Email")).sendKeys("priyanka@herontechnology.co.nz");
	    driver.findElement(By.id("Password")).clear();
	    driver.findElement(By.id("Password")).sendKeys("priya1213");
	    driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
    driver.get(baseUrl + "/Geofences");
    driver.findElement(By.xpath("//li[9]/a/span")).click();
    driver.findElement(By.id("UsersAndDrivers")).click();
    driver.findElement(By.linkText("Add")).click();
  //  driver.findElement(By.id("Name")).clear();
   // driver.findElement(By.id("Name")).sendKeys("priyanka@herontechnology.co.nz");
  ////  driver.findElement(By.id("Password")).clear();
  //  driver.findElement(By.id("Password")).sendKeys("priya1213");
 driver.findElement(By.id("userProfileDropdown")).click();
    new Select(driver.findElement(By.id("userProfileDropdown"))).selectByVisibleText("Compliance");
    driver.findElement(By.cssSelector("option[value=\"Compliance\"]")).click();
    driver.findElement(By.id("FirstName")).click();
    driver.findElement(By.id("FirstName")).clear();
    driver.findElement(By.id("FirstName")).sendKeys("priyanka");
    driver.findElement(By.id("LastName")).clear();
    driver.findElement(By.id("LastName")).sendKeys("heron");
    driver.findElement(By.id("Email")).clear();
    driver.findElement(By.id("Email")).sendKeys("priyankaheron1@herontechnology.co.nz");
    driver.findElement(By.id("SMSNumber")).clear();
    driver.findElement(By.id("SMSNumber")).sendKeys("02246200522");
    driver.findElement(By.id("Title")).click();
    driver.findElement(By.id("Title")).clear();
    driver.findElement(By.id("Title")).sendKeys("tester");
    driver.findElement(By.id("Location")).click();
    driver.findElement(By.id("Location")).clear();
    driver.findElement(By.id("Location")).sendKeys("Auckland");
    driver.findElement(By.id("CostCentre")).click();
    driver.findElement(By.id("CostCentre")).clear();
    driver.findElement(By.id("CostCentre")).sendKeys("0000");
    driver.findElement(By.id("DriversLicense")).click();
    driver.findElement(By.id("DriversLicense")).clear();
    driver.findElement(By.id("DriversLicense")).sendKeys("460052612");
    driver.findElement(By.id("LicenceClass")).click();
    driver.findElement(By.id("LicenceClass")).clear();
    driver.findElement(By.id("LicenceClass")).sendKeys("2222");
    driver.findElement(By.cssSelector("button.btn.btn-info")).click();
    Thread.sleep(2000);
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
