package tests;

import base.BaseTest;
import core.helpers.pagehelpers.PnMainHelper;
import core.helpers.pagehelpers.PnRefrigeratorsHelper;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.PnMainPage;
import pages.PnRefrigeratorsPage;

/**
 * Created by Anton_Savostytskyi on 05.06.2015.
 */
public class SortTest extends BaseTest {


    @BeforeMethod(dependsOnMethods = "setupBeforeSuite")
    public void setUpConfiguration() {
        mainHelper = new PnMainHelper(driver);
        refrigeratorsHelper = new PnRefrigeratorsHelper(driver);

        mainPage = new PnMainPage(driver);
        refrigeratorsPage = new PnRefrigeratorsPage(driver);
    }

    @Test
    public void checkSortByPrice() {
        mainPage.clickRefrigeratorsItem();
    }

}
