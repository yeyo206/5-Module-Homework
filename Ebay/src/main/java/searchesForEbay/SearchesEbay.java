package searchesForEbay;

import base.CommonAPI;
import base.UrlSetup;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class SearchesEbay extends CommonAPI {

    @BeforeMethod
    public void ebaySetup(){
        setUp(UrlSetup.Ebay);
    }
    WebDriverWait wait;

    @FindBy(id = "gh-ac") public static WebElement searchBar;
    @FindBy(xpath = "//h1[@class='srp-controls__count-heading']") public static WebElement testSearchBar;
    @FindBy(id = "gh-cat") public static WebElement allCategoriesDropDown;
    @FindBy(xpath = "//h1") public static WebElement header;
    @FindBy(id = "gh-btn") public static WebElement searchButton;
    @FindBy(xpath = "//section[@id='w2-w3']/ul/li") public static List<WebElement> byAgesCatgories;

    public void searchForMustangParts(){
        searchBar.sendKeys("mustang parts");
        new Actions(driver).sendKeys(Keys.ENTER).perform();
        Assert.assertTrue(testSearchBar.getText().contains("mustang parts"));
    }

    public void clickToysAndHobbies(){
        Select select = new Select(allCategoriesDropDown);
        select.selectByVisibleText("Toys & Hobbies");
        searchButton.click();
        explicitlyWait(5).until(ExpectedConditions.visibilityOf(header));
        Assert.assertTrue(header.getText().equalsIgnoreCase("Toys & Hobbies"));
    }

    public void clickByAgesCatogories(){
        clickToysAndHobbies();
        for (WebElement element : byAgesCatgories) {
            if  (element.getText().contains("1-2 Years")) {
                element.click();
                break;
            }
        }
        explicitlyWait(5).until(ExpectedConditions.visibilityOf(header));
        Assert.assertTrue(header.getText().contains("1-2 Years"));
    }

}
