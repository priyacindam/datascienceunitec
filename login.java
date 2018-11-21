package seleniumdemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
	
	public class login {
		
		public static void main(String[]args) {
	    	//System.setProperty("webdriver.firefox.marionette","\"C:\\Users\\Priyanka\\Downloads\\geckodriver-v0.16.1-win64\\geckodriver.exe\"");
			//WebDriver driver = new FirefoxDriver();
			System.setProperty("webdriver.firefox.marionette","\"C:\\Users\\Priyanka\\Downloads\\geckodriver-v0.16.1-win64\\geckodriver.exe\"");
			WebDriver driver = new FirefoxDriver();
			String baseUrl = "https://geo.argustracking.nz/";
	        driver.get(baseUrl);
	        WebElement email=driver.findElement(By.id("Email"));
	        WebElement password=driver.findElement(By.id("Password"));
	        email.sendKeys("priyanka@herontechnology.co.nz");
	        password.sendKeys("priya1213");
	        driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/form/div[4]/button")).click();
	        


		}

}
