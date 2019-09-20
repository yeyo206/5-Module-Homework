package MiamiHeraldSearches;

import base.CommonAPI;
import base.UrlSetup;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import java.net.URL;

public class MiamiHeraldSearches extends CommonAPI {

    @BeforeMethod
    public void miamiHeraldSetup(){
        setUp(UrlSetup.MiamiHerald);
    }
    WebDriver wait;

    @FindBy(id = "search-icon") public static WebElement searchIcon;
    @FindBy(xpath = "//td/div[contains(@class, 'result')]") public static WebElement resultsCounter;
    @FindBy(name = "q") public static WebElement searchBar;
    public void SearchForTodaysNews(){
        searchIcon.click();
        searchBar.sendKeys("today news");
        new Actions(driver).sendKeys(Keys.ENTER).perform();
        Assert.assertTrue(resultsCounter.getText().contains("results"));
    }



}
