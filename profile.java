package testngpack;

import java.util.regex.Pattern;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class profile {
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
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Dashboard'])[1]/following::span[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='All assets'])[2]/following::b[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='~Box U1'])[3]/following::li[1]")).click();
    Thread.sleep(2000);
  
    driver.findElement(By.linkText("Profile")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("/html/body/div[1]/section/div/div/div/form/fieldset[1]/div/div[2]/div/div/div/div[1]/div/div[3]/input")).click();

	  //Thread.sleep(2000);
	  StringSelection ss = new StringSelection("\"C:\\Users\\Priyanka\\Documents\\index.jpg\"");
	 Thread.sleep(2000);
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);
	  driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Images'])[1]/following::input[4]")).sendKeys("\"C:\\download.jpg\"");
	Thread.sleep(5000);
	Robot robot = new Robot();
	  robot.keyPress(KeyEvent.VK_CONTROL);	
	  robot.keyPress(KeyEvent.VK_V);
	  robot.keyRelease(KeyEvent.VK_V);
	  robot.keyRelease(KeyEvent.VK_CONTROL);
	  robot.keyPress(KeyEvent.VK_ENTER);
	  robot.keyRelease(KeyEvent.VK_ENTER);
	   Thread.sleep(2000);
	   driver.findElement(By.xpath("/html/body/div[1]/section/div/div/div/form/fieldset[1]/div/div[1]/div[7]/div/input")).click();
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
