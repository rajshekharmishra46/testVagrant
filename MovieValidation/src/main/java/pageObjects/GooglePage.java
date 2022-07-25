package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GooglePage {
	public WebDriver driver;
	By googleSearchTextBox=(By.xpath("//input[@name='q']"));
	By wikiPediaLink = (By.xpath("//a //*[contains(text(),'Wikipedia')]"));
	By imdbLink = (By.xpath("//a //*[contains(text(),'IMDb')]"));
	
	
	public GooglePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getGoogleSearchTextBox()
	{
		return driver.findElement(googleSearchTextBox);
	}
	
	public WebElement getWikiPediaLink(int n) {
		return driver.findElements(wikiPediaLink).get(n);
	}
	List<WebElement> list =new ArrayList<WebElement>();
	public WebElement getIMDbLink(int n) {
		list =driver.findElements(imdbLink);
		return list.get(n);
	}
	

}
