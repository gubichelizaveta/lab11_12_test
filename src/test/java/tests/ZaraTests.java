package tests;
import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject_model.JacketPage;
import pageobject_model.LoginPage;
import pageobject_model.ZaraHomePage;
import service.UserCreator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ZaraTests extends CommonConditions
{

    @Test
    public  void ZaraSearchWomanJeansTest()
    {
        int expected = 31;
        int expectedCount = new ZaraHomePage(driver)
                .openPage()
                .searchForJeans("woman jeans")
                .CountSearchResults();
        assertThat(expectedCount,is(expected));
       // Assert.assertTrue(expectedCount > 0, "");
    }
    @Test
    public void UserAccessTest()
    {
        User user = UserCreator.withCredentialsFromProperty();
        boolean getLogged = new LoginPage(driver)
                .openPage()
                .login(user)
                .getLogged();
        assertThat(getLogged,is(equals(true)));
    }
    @Test
    public void SearchBlackJacket()
    {
        new JacketPage(driver)
                .openPage()
                .SetUpFilters();
    }
    @Test
    public void SearchSkirtInSelectRange()
    {
        String expected = "Black | 7385/530";
        String result = new ZaraHomePage(driver)
                .openSkirtsPage()
                .SetUpMaterialsFilter()
                .getCharacteristic();
        assertThat(result,is(expected));
    }
    @Test
    public void StoreFinder()
    {
       boolean result =  new ZaraHomePage(driver)
               .openStoresFinder()
               .SetRegion("minsk")
               .ConfirmQueryForSearch();
       assertThat(result,is(true));
    }
    @Test
    public void ChangeLanguage()
    {
       String result = new ZaraHomePage(driver)
               .openStoresFinder()
               .SetRegion("minsk")
               .ChangeLng();
       assertThat(result,is("1"));
    }
}
