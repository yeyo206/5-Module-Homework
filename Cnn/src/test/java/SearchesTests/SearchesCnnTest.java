package SearchesTests;

import CnnSearches.SearchesCnn;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchesCnnTest extends SearchesCnn {
    SearchesCnn searchesCnn;

    @BeforeMethod
    public void initElements(){
        searchesCnn = PageFactory.initElements(driver,SearchesCnn.class);
    }
    @Test
    public void testTodayNews()
    {
        checkForTodaysNews();
    }

    @Test
    public void testTermsOfUse()
    {
        openTermsOfUse();
    }

    @Test
    public void testTrendingButton()
    {
        openTrendingButton();
    }
    @Test
    public void testWorldButton()
    {
        openWorldbutton();
    }
    @Test
    public void testUsButton()
    {
        openUsButton();
    }
}
