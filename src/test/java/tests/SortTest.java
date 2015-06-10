package tests;

import base.BaseTest;
import core.helpers.pagehelpers.PnMainHelper;
import org.testng.annotations.*;
import pages.PnMainPage;
import pages.PnRefrigeratorsPage;

/**
 * @author Anton_Savostytskyi on 05.06.2015.
 */

public class SortTest extends BaseTest {

    @BeforeMethod(dependsOnMethods = "setupBeforeSuite")
    public void setUpConfiguration() {
        mainPage = new PnMainPage(driver);
        refrigeratorsPage = new PnRefrigeratorsPage(driver);
        mainHelper = new PnMainHelper(driver);
        refrigeratorsHelper = mainHelper.navigateToRefrigerators(mainPage);
    }

    @Test
    public void checkSortByPrice() {
        refrigeratorsHelper
                .sortRefrigeratorsByParameter(refrigeratorsPage.getSortByPriceLink())
                .checkTheSortionByPrice(refrigeratorsPage.getPriceList());
    }

    @Test
    public void checkSortByGoodsName() {
        refrigeratorsHelper
                .sortRefrigeratorsByParameter(refrigeratorsPage.getSortByNameLink())
                .checkTheSortionByName(refrigeratorsPage.getNameList());
    }

    @AfterMethod
    public void goBack() {
    }
}
