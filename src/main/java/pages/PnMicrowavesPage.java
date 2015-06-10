package pages;

import core.helpers.generalhelpers.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

/**
 * @author Anton_Savostytskyi on 07.06.2015.
 */

public class PnMicrowavesPage {
    private WebDriver driver;

    public final String ADD_TO_COMPARATIVE = "(//div[@class='compare-links']//span[1])[position() < 3]";
    public final String TO_COMPARATIVE_REDIRECT = "(//span[@class='compare_redirect_link']//a)[1]";

    public PnMicrowavesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ADD_TO_COMPARATIVE)
    private List<WebElement> toComparativList;

    public List<WebElement> getToComparativeList() {
        return toComparativList;
    }

    @FindBy(xpath = TO_COMPARATIVE_REDIRECT)
    private WebElement redirectToComparative;

    public WebElement getRedirectToComparative() {
        return redirectToComparative;
    }

    public PnMicrowavesPage clickAddToComperetive() {
        getToComparativeList().get(0).click();
        WaitHelper.waitForElementIsClickable(getToComparativeList().get(1), driver);
        getToComparativeList().get(1).click();
        return new PnMicrowavesPage(driver);
    }

    public ComparePage clickRedirectToCompare() {
        getRedirectToComparative().click();
        return new ComparePage(driver);
    }
}
