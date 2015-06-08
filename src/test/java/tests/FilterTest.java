package tests;

import base.BaseTest;
import core.helpers.pagehelpers.PnMainHelper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.PnBreadMakerPage;
import pages.PnMainPage;
import pages.PnWashersPage;

/**
 * Created by Savostytskyi Anton on 07.06.2015.
 */
public class FilterTest extends BaseTest {


    @BeforeMethod(dependsOnMethods = "setupBeforeSuite")
    public void setUpConfiguration() {
        mainPage = new PnMainPage(driver);
        washersPage =  new PnWashersPage(driver);
        mainHelper = new PnMainHelper(driver);
        breadMakerPage = new PnBreadMakerPage(driver);

    }

    @Test
    public void checkSortByWeightAdjustment() {
        breadMakerHelper = mainHelper.navigateToBreadMakers(mainPage);
        breadMakerHelper
                .checkThatFilterByWeightAdjustmentWorkCorrectly(breadMakerPage);
    }

    @Test(dependsOnMethods = { "checkSortByWeightAdjustment" })
    public void checkSortByBrand() {
        breadMakerHelper = mainHelper.navigateToBreadMakers(mainPage);
        breadMakerHelper
                .checkThatFilterByBrandWorkCorrectly(breadMakerPage);
    }

    @Test(dependsOnMethods = { "checkSortByBrand" })
    public void checkSortByPrice() {
        washersHelper = mainHelper.navigateToWashers(mainPage);
        washersHelper
                .checkThatFilterByPriceWorkCorrectly(washersPage);
    }

    @AfterMethod
    public void goBack() {
        driver.navigate().back();
    }
}
