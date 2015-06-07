package core.helpers.pagehelpers;

import com.google.common.collect.Ordering;
import core.helpers.generalhelpers.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.PnRefrigeratorsPage;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anton_Savostytskyi on 05.06.2015.
 */
public class PnRefrigeratorsHelper {
    private WebDriver driver;
    public PnRefrigeratorsHelper(WebDriver driver) {
        this.driver = driver;
    }

    public PnMainHelper navigateToMainPage(PnRefrigeratorsPage refrigerators) {
        WaitHelper.waitForElementVisible(refrigerators.getToMainPageLink(), driver);
        refrigerators.clickBackToMainPage();
        return new PnMainHelper(driver);
    }

    public PnRefrigeratorsHelper sortRefrigeratorsByParameter(WebElement parameter) {
        WaitHelper.waitForElementIsClickable(parameter, driver);
        parameter.click();
        return new PnRefrigeratorsHelper(driver);
    }

    public PnRefrigeratorsHelper checkTheSortionByPrice(List<WebElement> detail) {
        List <Integer> price = new ArrayList<Integer>();
            for(WebElement element: detail) {
            price.add(Integer.parseInt(element.getText().replaceAll("\\D", "")));
        }
        Assert.assertTrue(Ordering.natural().isOrdered(price));
        return new PnRefrigeratorsHelper(driver);
    }

    public PnRefrigeratorsHelper checkTheSortionByName(List<WebElement> detail) {
        List <String> name = new ArrayList<String>();
            for(WebElement element: detail) {
            name.add(element.getText());
        }
        Assert.assertTrue(Ordering.natural().isOrdered(name));
        return new PnRefrigeratorsHelper(driver);
    }
}
