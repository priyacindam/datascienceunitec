package assetreport;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class check {
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
  public void testCheck() throws Exception {
    driver.get(baseUrl + "/Account/Login?ReturnUrl=%2fDashboard");
    driver.findElement(By.id("Email")).clear();
    driver.findElement(By.id("Email")).sendKeys("priyanka@herontechnology.co.nz");
    driver.findElement(By.id("Password")).clear();
    driver.findElement(By.id("Password")).sendKeys("priya1213");
    driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
    driver.findElement(By.linkText("Fleet Management")).click();
    driver.findElement(By.id("CheckSheet")).click();
    driver.findElement(By.cssSelector("#assetSelect_chosen > a.chosen-single > span")).click();
    driver.findElement(By.xpath("//div[@id='assetSelect_chosen']/div/ul/li[11]")).click();
    driver.findElement(By.cssSelector("span.fa.fa-calendar")).click();
    driver.findElement(By.cssSelector("span.glyphicon.glyphicon-chevron-left")).click();
    driver.findElement(By.cssSelector("span.glyphicon.glyphicon-chevron-left")).click();
    driver.findElement(By.xpath("//div[@id='startDatePicker']/div/ul/li/div/div/table/tbody/tr[2]/td")).click();
    
    driver.findElement(By.cssSelector("#endDatePicker > span.input-group-addon")).click();
    driver.findElement(By.xpath("//div[@id='endDatePicker']/div/ul/li/div/div/table/tbody/tr[2]/td[2]")).click();
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
