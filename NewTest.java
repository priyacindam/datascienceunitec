package testngpack;

import org.testng.annotations.Test;

import java.util.regex.Pattern;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.testng.ITestContext;
import org.testng.TestListenerAdapter;
import org.testng.annotations.*;

import junit.textui.TestRunner;

import org.testng.TestNG;

import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class NewTest {
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
    driver.findElement(By.cssSelector("div.report-icon > img")).click();
    driver.findElement(By.cssSelector("#assetSearch_chosen > a.chosen-single > span")).click();

    driver.findElement(By.xpath("//div[@id='assetSearch_chosen']/div/ul/li[15]")).click();
    driver.findElement(By.id("dateRange")).click();

    

    driver.findElement(By.xpath("//div[3]/div/ul/li[8]")).click();
    driver.findElement(By.id("submitBtn")).click();


	WebDriverWait wait = new WebDriverWait(driver, 5);
	Thread.sleep(20000);
  }

	 public static void main(String[] args) {
	  
	  TestListenerAdapter testla = new TestListenerAdapter();
	  TestNG testng = new TestNG();
	  testng.setTestClasses(new Class[] {NewTest .class});
	  testng.run();
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