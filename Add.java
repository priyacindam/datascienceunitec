package testngpack;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Add {
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
  public void testIng() throws Exception {
	 
	  group();
	  geofence();
	  
  }
	  public void group() throws Exception {
    driver.get(baseUrl + "/Account/Login?ReturnUrl=%2fDashboard");
    driver.findElement(By.id("Email")).clear();
    driver.findElement(By.id("Email")).sendKeys("priyanka@herontechnology.co.nz");
    driver.findElement(By.id("Password")).clear();
    driver.findElement(By.id("Password")).sendKeys("priya1213");
    driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
    driver.findElement(By.xpath("//li[9]/a/span")).click();
    driver.findElement(By.id("VehicleGroups")).click();
    driver.findElement(By.id("createVehicleGroupBtn")).click();
    driver.findElement(By.id("vehicleGroupName")).click();
    driver.findElement(By.id("vehicleGroupName")).clear();
    driver.findElement(By.id("vehicleGroupName")).sendKeys("treack");
    Thread.sleep(2000);
    driver.findElement(By.id("createOrEditBtn")).click();
    Thread.sleep(2000);
    
  }
  
  public void geofence() throws Exception {
    driver.findElement(By.id("createGeofenceGroupBtn")).click();
    driver.findElement(By.id("geofenceGroupName")).click();
    driver.findElement(By.id("geofenceGroupName")).clear();
    driver.findElement(By.id("geofenceGroupName")).sendKeys("testing");
    Thread.sleep(2000);
    driver.findElement(By.id("geoCreateOrEditBtn")).click();
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
