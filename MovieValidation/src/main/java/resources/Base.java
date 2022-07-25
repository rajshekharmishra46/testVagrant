package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
//import org.apache.commons.io.FileUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;

public class Base {

	public  WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException
	{
		
	prop= new Properties();
	String currentUsersHomeDir = System.getProperty("user.dir");
	FileInputStream fis=new FileInputStream(currentUsersHomeDir + File.separator +"src\\main\\java\\resources\\data.properties");

	prop.load(fis);
	String browserName=prop.getProperty("browser");
	System.out.println(browserName);

	if(browserName.equals("chrome"))
	{
		 System.setProperty("webdriver.chrome.driver", currentUsersHomeDir + File.separator+"Drivers\\chromedriver.exe");
		driver= new ChromeDriver();
			//execute in chrome driver
		
	}
	else if (browserName.equals("firefox"))
	{
		 
		//firefox code
	}
	else if (browserName.equals("IE"))
	{
//		IE code
	}

	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;


	}
	public void input(WebElement el,String value)
	{
		el.sendKeys(value);
	}
	public void pressEnter() {
		Actions a = new Actions(driver);
		a.keyDown(Keys.ENTER).build().perform();
	}
	public void clickElement(WebElement el) {
		el.click();
	}

	
}
