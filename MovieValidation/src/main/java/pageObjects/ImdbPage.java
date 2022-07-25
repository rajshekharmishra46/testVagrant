package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ImdbPage {
	
	public WebDriver driver;
	
	
	public ImdbPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}
	
	By movieReleaseDateIMDb = (By.xpath("//section[contains(@class,'kUbSjY')]//section[@data-testid='Details']//a[text()='Release date']/parent::li//a[contains(@class,'list-content-item')]"));
	
	By movieOriginCountryIMDb = (By.xpath("//section[contains(@class,'kUbSjY')]//section[@data-testid='Details']//*[text()='Country of origin']/parent::li//a"));
	
	public WebElement getMovieReleaseDateIMDb() {
		return driver.findElement(movieReleaseDateIMDb);
	}
	
	public WebElement getMovieOriginCountryIMDb() {
		return driver.findElement(movieOriginCountryIMDb);
	}

	
}
