package NyTimesSearches;

import base.CommonAPI;
import base.UrlSetup;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import java.awt.*;
import java.util.List;

public class NyTimesSearches extends CommonAPI {

    @BeforeMethod
    public void nySetup() {
        setUp(UrlSetup.NyTimes);
    }

    @FindBy(xpath = "//ul[@class='css-1vxc2sl']/li[@class='css-cwdrld']") public static List<WebElement> topBarElements;
    @FindBy(xpath = "//h1") public static WebElement header;
    @FindBy(xpath = "//button[@class ='css-mgtjo2 ewfai8r0']") public static WebElement searchIcon;
    @FindBy(xpath = "//p[@class ='css-nayoou']") public static WebElement headerSearch;
    @FindBy(name = "query") public static WebElement searchBar;
    @FindBy(xpath = "//a[@class='css-1kj7lfb nytcp-opt']") public static WebElement subscribeButton;
    @FindBy(xpath = "//h1[2]") public static WebElement subscriberHeader;


    public void clickUsButton() {
        for (WebElement element : topBarElements) {
            if (element.getText().contains("U.S")) {
                element.click();
                break;
            }
        }
        Assert.assertTrue(header.getText().equalsIgnoreCase("U.S. News"));
    }

    public void clickTechButton() {
        for (WebElement element : topBarElements) {
            if (element.getText().contains("Tech")) {
                element.click();
                break;
            }
        }
        Assert.assertTrue(header.getText().contains("Technology"));
    }

    public void clickTravelButton() {
        for (WebElement element : topBarElements) {
            if (element.getText().contains("Travel")) {
                element.click();
                break;
            }
        }
        Assert.assertTrue(header.getText().contains("Travel"));
    }

    public void searchForTodaysNews() {
        searchIcon.click();
        searchBar.sendKeys("today news");
        new Actions(driver).sendKeys(Keys.ENTER).perform();
        Assert.assertTrue(headerSearch.getText().contains("results"));

    }

    public void clickSubscribeButton(){
        subscribeButton.click();
        Assert.assertTrue(subscriberHeader.getText().contains("Subscribe for $1 a week."));

    }
}
