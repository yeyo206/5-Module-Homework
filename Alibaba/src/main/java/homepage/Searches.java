package homepage;

import base.CommonAPI;
import base.UrlSetup;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import java.util.List;

public class Searches extends CommonAPI {

    @BeforeMethod
    public void alibabaSetup(){
        setUp(UrlSetup.Alibaba);
    }

    @FindBy(xpath = "//div/input[@placeholder = 'One month of mega deals']")public static WebElement searchBar;
    @FindBy(xpath = "//div[@class='seb-refine-result__label']")public static WebElement resultLabel;
    @FindBy(xpath = "//div[@class='ui-searchbar-type-value']") public static WebElement searchFilter;
    @FindBy(xpath = "//div/ul[@class = 'ui-searchbar-type-options']/li") public static List<WebElement> searchFilterList;
    @FindBy(xpath = "//div/div[@class = 'en-us m-breadcrumb']") public static WebElement resultWholesaleCount;
    @FindBy(xpath = "//div[@class = 'sc-hd-category']//h3/span[text() = 'Categories']") public static WebElement categories;
    @FindBy(xpath = "//div[@class = 'header-category']//ul/li") public static WebElement categoriesLI;
    @FindBy(xpath = "//input[@class ='J-btn-search scc-t-a-search-button ui2-button ui2-button-default ui2-button-normal ui2-button-large']") public static WebElement subscribeButtom;
    @FindBy(xpath = "//div[@class ='J-error-tips scc-t-a-search-tips']") public static WebElement errorMessageForInvalidEmail;
    @FindBy(xpath = "//div[@class = 'J-hd-m-notify-tab sc-hd-hide-s sc-hd-ms-tab sc-hd-ms-order J-sc-hd-ms-order']") public static WebElement checkOrderBox;
    @FindBy(xpath = "//a[@class = 'sc-hd-ms-icon sc-hd-i-taorder-new']") public static WebElement messageForOrderButtom;

    public void searchForIphone()
    {
        searchBar.sendKeys("iphone");
        new Actions(driver).sendKeys(Keys.ENTER).perform();
        Assert.assertTrue(resultLabel.getText().contains("iphone"));
    }

    public void searchIphoneWholeSaler(){
        searchForIphone();
        searchFilter.click();
        for (WebElement element : searchFilterList
             ) {
            if (element.getText().equalsIgnoreCase("wholesaler"))
                element.click();
        }
        searchBar.click();
        new Actions(driver).sendKeys(Keys.ENTER).perform();
        Assert.assertTrue(resultWholesaleCount.getText().contains("Wholesaler") &&
                                   resultWholesaleCount.getText().contains("iphone"));
    }

    public void categoriesHoverOver(){
        new Actions(driver).clickAndHold(categories).perform();
        Assert.assertTrue(categoriesLI.isEnabled());
    }

    public void subscribeViaEmailWithBlankEmailBox(){
        subscribeButtom.click();
        Assert.assertTrue(errorMessageForInvalidEmail.isDisplayed() &&
                                   errorMessageForInvalidEmail.getText()
                                   .equalsIgnoreCase("Please enter a valid email address"));
    }

    public void orderButtom(){
        checkOrderBox.click();
        Assert.assertTrue(messageForOrderButtom.isDisplayed());
    }
}
