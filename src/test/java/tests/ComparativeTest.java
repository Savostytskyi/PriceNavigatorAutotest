package tests;

import base.BaseTest;
import core.helpers.pagehelpers.PnMainHelper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ComparePage;
import pages.PnMainPage;
import pages.PnMicrowavesPage;

/**
 * @author Anton_Savostytskyi on 07.06.2015.
 */

public class ComparativeTest extends BaseTest {

    @BeforeMethod(dependsOnMethods = "setupBeforeSuite")
    public void setUpConfiguration() {
        mainPage = new PnMainPage(driver);
        microwavePage =  new PnMicrowavesPage(driver);
        mainHelper = new PnMainHelper(driver);
        comparePage = new ComparePage(driver);
        microwaveHelper = mainHelper.navigateToMicrowaves(mainPage);
        compareHelper = microwaveHelper.navigateToComparePage(microwavePage);
    }

   @Test
    public void checkSortByPrice() {
        compareHelper
                .isGoodsAdded(comparePage.getGoodsTitles(), microwaveHelper)
                .isAllPropertiesPresent(comparePage.getGoodsProperties())
                .isElementsHaveCorrectColor(comparePage.getGoodsTableRows());
    }

    @AfterMethod
    public void goBack() {
        driver.navigate().back();
        microwaveHelper.removeGoodsFromCompare(microwavePage);
        driver.navigate().back();
    }

}

