package assetreport;

import java.util.regex.Pattern;
import org.openqa.selenium.Alert;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class pdffile {
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
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='View History'])[1]/following::span[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Asset Reporting'])[1]/following::img[2]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Select Asset / Group'])[1]/following::span[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='~Box FMA110'])[3]/following::li[1]")).click();
    driver.findElement(By.id("dateRange")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='This Month'])[1]/following::li[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Select Report Format'])[1]/following::span[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Export as Printer Friendly PDF'])[2]/following::li[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Select Output Type'])[1]/following::span[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Save as File'])[2]/following::li[1]")).click();
    driver.findElement(By.id("submitBtn")).click();
    Thread.sleep(20000);
  }
  
  
    public static FirefoxProfile FirefoxDriverProfile() throws Exception {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.download.folderList", 1);
		profile.setPreference("browser.download.manager.showWhenStarting", false);
		//profile.setPreference("browser.download.dir", downloadPath);
		profile.setPreference("browser.helperApps.neverAsk.openFile",
				"text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
"text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
		profile.setPreference("browser.helperApps.alwaysAsk.force", false);
		profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
		profile.setPreference("browser.download.manager.focusWhenStarting", false);
		profile.setPreference("browser.download.manager.useWindow", false);
		profile.setPreference("browser.download.manager.showAlertOnComplete", false);
		profile.setPreference("browser.download.manager.closeWhenDone", false);
		return profile;
	}


  //  Runtime.getRuntime().exec("\"C:\\AutoIT\\script.exe\"");

  // Robot robot=new Robot();
   // robot.delay(2000);
//
  //  robot.keyPress(KeyEvent.VK_DOWN); // press keyboard arrow key to select Save radio button	
   // robot.keyPress(KeyEvent.VK_DOWN);
//  Thread.sleep(4000);

  // robot.keyPress(KeyEvent.VK_TAB);
 //  Thread.sleep(4000);
  //  robot.keyPress(KeyEvent.VK_TAB);
    //Thread.sleep(2000);
    
     //robot.keyPress(KeyEvent.VK_ENTER);
   //robot.keyPress(KeyEvent.VK_ENTER);

 //Thread.sleep(30000)

 public static void main(String[] args) {
  	  
  	  TestListenerAdapter testla = new TestListenerAdapter();
  	  TestNG testng = new TestNG();
  	  testng.setTestClasses(new Class[] {pdffile .class});
  	  testng.run();
  	 }
	
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | win_ser_local | ]]
  

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
