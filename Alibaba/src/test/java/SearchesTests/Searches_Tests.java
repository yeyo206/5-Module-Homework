package SearchesTests;

import homepage.Searches;
import net.bytebuddy.build.ToStringPlugin;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Searches_Tests extends Searches {
    Searches searches;

    @BeforeMethod
    public void initElements(){
        searches = PageFactory.initElements(driver, Searches.class);
    }

    @Test
    public void iphoneSearch(){
        searchForIphone();
    }
    @Test
    public void whosalerSale(){
        searchIphoneWholeSaler();
    }
    @Test
    public void hoverOverTest(){
        categoriesHoverOver();
    }
    @Test
    public void validateErrorMessageOnNullEmail(){
        subscribeViaEmailWithBlankEmailBox();
    }
}
