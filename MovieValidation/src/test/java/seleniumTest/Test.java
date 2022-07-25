package seleniumTest;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;


import pageObjects.GooglePage;
import pageObjects.ImdbPage;
import pageObjects.WikipediaPage;
import resources.Base;

public class Test extends Base{
	
	public WebDriver driver;
	
	
	
	 
	@BeforeTest
	public void initialize() throws IOException {
		driver =initializeDriver();
		}

@org.testng.annotations.Test(dataProvider="getData")
	public void valiadteMatch(String movieName) throws InterruptedException {
	

	driver.get(prop.getProperty("url"));
	GooglePage gp = new GooglePage(driver);
	input(gp.getGoogleSearchTextBox(), movieName+" movie wikipedia");
	pressEnter();
	
	clickElement(gp.getWikiPediaLink(0));
	
	WikipediaPage Wiki = new WikipediaPage(driver);
	String movieReleaseDateWiki = Wiki.getMovieReleaseDateWiki().getText();
	String movieOriginCountryWiki = Wiki.getMovieOriginCountryWiki().getText();
	
	driver.get(prop.getProperty("url"));
	input(gp.getGoogleSearchTextBox(),movieName+" movie imdb");
	pressEnter();

	clickElement(gp.getIMDbLink(0));
	
	ImdbPage IMDb = new ImdbPage(driver);
	String movieReleaseDateIMDb = IMDb.getMovieReleaseDateIMDb().getText();
	String movieOriginCountryIMDb = IMDb.getMovieOriginCountryIMDb().getText();
	
ArrayList<String> wikiDate = new ArrayList<String>();
ArrayList<String> imdbDate = new ArrayList<String>();

String[] arr1 = movieReleaseDateWiki.split("\\(")[0].split(" ");
for(String s:arr1) {
	if(s.contains(","))
		wikiDate.add(s.split(",")[0]);
	else
		wikiDate.add(s);
}
	

String[] arr2 = movieReleaseDateIMDb.split("\\(")[0].split(" "); 
for(String s:arr2) {
	if(s.contains(","))
		imdbDate.add(s.split(",")[0]);
	else
	imdbDate.add(s);
}	
	
	Assert.assertTrue(wikiDate.containsAll(imdbDate) && imdbDate.containsAll(wikiDate), "Movie release date are not same at both sources");
	Assert.assertTrue(movieOriginCountryWiki.equals(movieOriginCountryIMDb),"Movie origin country are not same at both sources");
}

@AfterTest
public void closeDriver() {
	driver.quit();
	
}
@DataProvider
public Object[][] getData()
{
	Object[][] data=new Object[1][1];
	data[0][0]="Pushpa: The Rise";
	
	return data;
	
}

}
