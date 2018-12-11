package testngpack;

import java.util.regex.Pattern;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class geofence {
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
  public void test1() throws Exception {
    driver.get("https://geo.argustracking.nz/Account/Login?ReturnUrl=%2fDashboard");
    driver.findElement(By.id("Email")).clear();
    driver.findElement(By.id("Email")).sendKeys("priyanka@herontechnology.co.nz");
    driver.findElement(By.id("Password")).clear();
    driver.findElement(By.id("Password")).sendKeys("priya1213");
    driver.findElement(By.xpath("//form[@action='/Account/Login']")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Please sign into the Argus Hub'])[1]/following::button[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Security Integration'])[1]/following::span[1]")).click();
    driver.findElement(By.id("addGeofenceButton")).click();
    driver.findElement(By.id("map-input")).click();
    driver.findElement(By.id("map-input")).clear();
    driver.findElement(By.id("map-input")).sendKeys("parnell");
    Thread.sleep(2000);
    List<WebElement> autoSuggestions=driver.findElement(By.className("sbsb_b")).findElements(By.tagName("li"));
    for (WebElement suggestions : autoSuggestions) {
        if (suggestions.getText().equals("Parnell Road, Remuera, Auckland, New Zealand")) {
            suggestions.click();
            Thread.sleep(3000);
            break;
        }
    }
    driver.findElement(By.id("openCircle")).click();
    driver.findElement(By.id("modalLatitude")).click();
    driver.findElement(By.id("modalLatitude")).clear();
    driver.findElement(By.id("modalLatitude")).sendKeys("20");
    driver.findElement(By.id("modalLatitude")).sendKeys(Keys.DOWN);
    driver.findElement(By.id("modalLatitude")).clear();
   // driver.findElement(By.id("modalLatitude")).sendKeys("2020");
   // driver.findElement(By.id("modalLatitude")).sendKeys(Keys.DOWN);
 //   driver.findElement(By.id("modalLatitude")).clear();
    driver.findElement(By.id("modalLatitude")).sendKeys("20");
    driver.findElement(By.id("modalLongitude")).click();
    driver.findElement(By.id("modalLongitude")).clear();
    driver.findElement(By.id("modalLongitude")).sendKeys("20");
    driver.findElement(By.id("modalCircleRadius")).click();
   driver.findElement(By.id("modalCircleRadius")).clear();
    driver.findElement(By.id("modalCircleRadius")).sendKeys("60");
    Thread.sleep(2000);

    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Radius in meters'])[1]/following::button[1]")).click();
    driver.findElement(By.id("geofenceName")).click();
    driver.findElement(By.id("geofenceName")).clear();
    driver.findElement(By.id("geofenceName")).sendKeys("parnell");
    Thread.sleep(2000);

    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Apply to Geofence Groups'])[1]/following::div[4]")).click();
    driver.findElement(By.id("saveGeofence")).click();
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
}
