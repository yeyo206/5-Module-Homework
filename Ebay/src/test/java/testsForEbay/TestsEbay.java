package testsForEbay;

import base.CommonAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import searchesForEbay.SearchesEbay;

public class TestsEbay extends SearchesEbay {
    SearchesEbay searchesEbay;

    @BeforeMethod
    public void initelements(){
        searchesEbay = PageFactory.initElements(driver,SearchesEbay.class);
    }
    @Test
    public void testSearchBar(){
        searchForMustangParts();
    }
    @Test
    public void testAllCategories_Toys(){
        clickToysAndHobbies();
    }
    @Test
    public void testByAgeCategories(){
        clickByAgesCatogories();
    }
    @Test
    public void testShoppingCartButton(){
        clickShoppingCar();
    }
    @Test
    public void testAllCategories_EbayMotors(){
        clickEbayMotors();
    }
}
