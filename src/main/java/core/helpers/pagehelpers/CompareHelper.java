package core.helpers.pagehelpers;

import core.helpers.generalhelpers.VerifyHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.util.List;

/**
 * Created by Savostytskyi Anton on 07.06.2015.
 */
public class CompareHelper {
    private WebDriver driver;

    public CompareHelper(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CompareHelper isAllPropertiesPresent(List<WebElement> properties) {
        Assert.assertTrue(VerifyHelper.verifyIsElementsPresent(properties));
        return new CompareHelper(driver);
    }

    public CompareHelper isElementsHaveCorrectColor (List<WebElement> properties) {
        Assert.assertTrue(VerifyHelper.verifyCorespondingColorOfList(properties));
        return new CompareHelper(driver);
        }
    }


