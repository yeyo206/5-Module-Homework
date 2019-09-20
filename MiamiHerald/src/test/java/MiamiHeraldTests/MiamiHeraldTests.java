package MiamiHeraldTests;

import MiamiHeraldSearches.MiamiHeraldSearches;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MiamiHeraldTests extends MiamiHeraldSearches {
    MiamiHeraldSearches miamiHeraldSearches;

    @BeforeMethod
    public void initElements(){
            miamiHeraldSearches = PageFactory.initElements(driver,MiamiHeraldSearches.class);
    }
    @Test
    public void testSearchBar(){
        SearchForTodaysNews();
    }


}
