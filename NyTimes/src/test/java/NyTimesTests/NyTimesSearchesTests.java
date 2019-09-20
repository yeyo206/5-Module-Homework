package NyTimesTests;

import NyTimesSearches.NyTimesSearches;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NyTimesSearchesTests extends NyTimesSearches {
    NyTimesSearches nyTimesSearches;

    @BeforeMethod
    public void initElements(){
        nyTimesSearches = PageFactory.initElements(driver,NyTimesSearches.class);

    }

    @Test
    public void testUsButton(){
        clickUsButton();
    }

    @Test
    public void testTechButton(){
        clickTechButton();
    }

    @Test
    public void testTravelButton(){
        clickTravelButton();
    }

    @Test
    public void testSearchBar(){
        searchForTodaysNews();
    }
    @Test
    public void testSubscribeButton(){
        clickSubscribeButton();
    }
}
