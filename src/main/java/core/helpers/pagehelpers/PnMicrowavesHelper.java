package core.helpers.pagehelpers;

import core.helpers.generalhelpers.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.PnMicrowavesPage;
import pages.PnRefrigeratorsPage;

/**
 * Created by Savostytskyi Anton on 07.06.2015.
 */
public class PnMicrowavesHelper {
    private WebDriver driver;

    public PnMicrowavesHelper(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CompareHelper navigateToComparePage(PnMicrowavesPage microwavesPage) {
        WaitHelper.waitForElements(microwavesPage.getToComparativeList(), driver);
        microwavesPage.clickAddToComperetive();
        WaitHelper.waitForElementIsClickable(microwavesPage.getRedirectToComparative(), driver);
        microwavesPage.clickRedirectToCompare();
        return new CompareHelper(driver);
    }

    public PnMicrowavesHelper removeGoodsFromCompare(PnMicrowavesPage microwavesPage) {
        WaitHelper.waitForElements(microwavesPage.getToComparativeList(), driver);
        microwavesPage.clickAddToComperetive();
        return new PnMicrowavesHelper(driver);
    }
}
