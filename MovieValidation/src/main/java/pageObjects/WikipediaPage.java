package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WikipediaPage {
	public WebDriver driver;
	public WikipediaPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}
	By movieReleaseDateWiki0=(By.xpath("//table/tbody/tr/th/div[text()='Release date']/ancestor::tr/td//li"));
	By movieReleaseDateWiki1=(By.xpath("//table/tbody/tr/th/div[text()='Release date']/ancestor::tr/td"));
	By movieOriginCountryWiki = (By.xpath("//table/tbody/tr/th[text()='Country']/following-sibling::td"));
	
	public WebElement getMovieReleaseDateWiki() {
		try {
		return driver.findElement(movieReleaseDateWiki0);
	}
		catch(Exception e) {
			return driver.findElement(movieReleaseDateWiki1);
		}
	}
	public WebElement getMovieOriginCountryWiki() {
		return driver.findElement(movieOriginCountryWiki);
	}
}
