package CnnSearches;

import base.CommonAPI;
import base.UrlSetup;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import java.util.List;

public class SearchesCnn extends CommonAPI {

    @BeforeMethod
    public void cnnSetup(){
        setUp(UrlSetup.Cnn);
    }
    WebDriverWait wait;

    @FindBy(xpath = "//button[@tabindex='0']") public static WebElement searchButton;
    @FindBy(id = "header-search-bar") public static WebElement searchBar;
    @FindBy(xpath = "//div[@class ='cnn-search__results-count']") public static WebElement searchResult;
    @FindBy(xpath = "//a[@name='terms-of-use']") public static WebElement termsOfUse;
    @FindBy(xpath = "//h1[text()='CNN Terms of Use']") public static WebElement termsOfUseHeader;
    @FindBy(xpath = "//span[text()='TRENDING:  ']") public static WebElement trendingbutton;
    @FindBy(xpath = "//h1[@class='pg-headline']") public static WebElement trendingTitle;
    @FindBy(xpath = "//nav/ul[@type='collapsed']//li") public static List<WebElement> topLinksList;
    @FindBy(xpath = "//h1") public static WebElement header;

    public void checkForTodaysNews(){
        searchButton.click();
        searchBar.sendKeys("today news");
        new Actions(driver).sendKeys(Keys.ENTER).perform();
        Assert.assertTrue(searchResult.getText().contains("today news"));
    }

    public void openTermsOfUse(){
        wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.elementToBeClickable(termsOfUse));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", termsOfUse);
        Assert.assertTrue(termsOfUseHeader.getText().equals( "CNN Terms of Use"));
    }
    public void openTrendingButton(){
        trendingbutton.click();
        Assert.assertTrue(trendingTitle.isDisplayed());

    }

    public void openWorldbutton(){
        for (WebElement button : topLinksList
             ){
            if (button.getText().equalsIgnoreCase("world")){
                button.click();
                break;
            }
        }
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(header));
        Assert.assertTrue(header.getText().equalsIgnoreCase("world"));
    }

    public void openUsButton(){
        for (WebElement button : topLinksList
        ){
            if (button.getText().equalsIgnoreCase("us")){
                button.click();
                break;
            }
        }
        explicitlyWait(5).until(ExpectedConditions.visibilityOf(header));
        Assert.assertTrue(header.getText().equalsIgnoreCase("us"));
    }
}
