package assetreport;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class tripreport {
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
  public void testReport() throws Exception {
    driver.get(baseUrl + "/Account/Login?ReturnUrl=%2fDashboard");
    driver.findElement(By.id("Email")).clear();
    driver.findElement(By.id("Email")).sendKeys("priyanka@herontechnology.co.nz");
    driver.findElement(By.id("Password")).clear();
    driver.findElement(By.id("Password")).sendKeys("priya1213");
    driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
    driver.findElement(By.xpath("//li[4]/a/span")).click();
    driver.findElement(By.xpath("//div[@id='vehicle']/div[3]/img")).click();
    driver.findElement(By.cssSelector("#assetSearch_chosen > a.chosen-single > span")).click();
    driver.findElement(By.xpath("//div[@id='assetSearch_chosen']/div/ul/li[15]")).click();
    driver.findElement(By.id("dateRange")).click();
    driver.findElement(By.cssSelector("select.monthselect")).click();
    // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
    driver.findElement(By.xpath("//div[@id='sizzle-1542147597473']/div[2]/div[2]/table/tbody/tr/td[2]")).click();
    driver.findElement(By.xpath("//div[@id='sizzle-1542147597473']/div[2]/div[2]/table/tbody/tr[4]/td[2]")).click();
    driver.findElement(By.xpath("//button[@type='button']")).click();
    driver.findElement(By.cssSelector("#output_chosen > a.chosen-single > span")).click();
    driver.findElement(By.xpath("//div[@id='output_chosen']/div/ul/li[2]")).click();
    driver.findElement(By.cssSelector("#outputMedium_chosen > a.chosen-single > span")).click();
    driver.findElement(By.cssSelector("#outputMedium_chosen > div.chosen-drop > ul.chosen-results > li.active-result.result-selected")).click();
    driver.findElement(By.id("submitBtn")).click();
    driver.findElement(By.cssSelector("a[type=\"hidden\"]")).click();
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
