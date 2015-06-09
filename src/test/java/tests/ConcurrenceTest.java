package tests;

import base.BaseTest;
import core.helpers.pagehelpers.PnMainHelper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.PnAirConditionedPage;
import pages.PnGoodsInfoPage;
import pages.PnMainPage;

/**
 * Created by Savostytskyi Anton on 09.06.2015.
 */
public class ConcurrenceTest extends BaseTest {
    @BeforeMethod(dependsOnMethods = "setupBeforeSuite")
    public void setUpConfiguration() {
        mainPage = new PnMainPage(driver);
        airConditionedPage = new PnAirConditionedPage(driver);
        mainHelper = new PnMainHelper(driver);
        goodsInfoPage = new PnGoodsInfoPage(driver);
        airConditionedHelper = mainHelper.navigateAirConditioned(mainPage);
    }

    @Test
    public void checkSortByPrice() {
        airConditionedHelper.checkThatInformationCorrect(airConditionedPage, goodsInfoPage);
    }

    @AfterMethod
    public void goBack() {
        driver.navigate().back();
    }
}
