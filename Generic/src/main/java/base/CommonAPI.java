package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;

import java.util.concurrent.TimeUnit;

public class CommonAPI {

    public static WebDriver driver = null;

    @BeforeMethod
    public void setUp(@Optional("http://www.alibaba.com/") String url){
        System.setProperty("webdriver.chrome.driver" , "/Users/mac/IdeaProjects/framework/drivers/chromedriver 3");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(25,TimeUnit.SECONDS);
        driver.get(url);
    }

    @AfterMethod
    public void cleanUp(){
        driver.quit();
    }
    public WebDriverWait explicitlyWait (int timeOut){
        return new WebDriverWait(driver,timeOut);
    }


}
