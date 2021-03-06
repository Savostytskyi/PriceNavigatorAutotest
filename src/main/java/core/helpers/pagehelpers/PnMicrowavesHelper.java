package core.helpers.pagehelpers;

import core.helpers.generalhelpers.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.PnMicrowavesPage;

/**
 * @author Anton_Savostytskyi on 07.06.2015.
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
        WaitHelper.delay(2000);
        return new CompareHelper(driver);
    }

    public PnMicrowavesHelper removeGoodsFromCompare(PnMicrowavesPage microwavesPage) {
        WaitHelper.waitForElements(microwavesPage.getToComparativeList(), driver);
        microwavesPage.clickAddToComperetive();
        return new PnMicrowavesHelper(driver);
    }
}
