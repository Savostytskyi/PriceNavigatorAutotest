package core.helpers.pagehelpers;

import core.helpers.generalhelpers.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.PnAirConditionedPage;
import pages.PnGoodsInfoPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Savostytskyi Anton on 08.06.2015.
 */
public class PnAirConditionedHelper {

    private WebDriver driver;

    public PnAirConditionedHelper(WebDriver driver) {
        this.driver = driver;
    }

    public PnAirConditionedHelper getShortInfo(PnAirConditionedPage airConditionedPage) {
        WaitHelper.waitForElements(airConditionedPage.getConditionersDescription(), driver);
        for (WebElement description: airConditionedPage.getConditionersDescription()) {
            System.out.println(description.getText());
        }
        return new PnAirConditionedHelper(driver);
    }

    public PnGoodsInfoHelper getFullDescription(PnAirConditionedPage airConditionedPage) {
        WaitHelper.waitForElements(airConditionedPage.getConditionersNames(), driver);
        for (WebElement description: airConditionedPage.getConditionersNames()) {
            description.click();
            new PnGoodsInfoHelper(driver);
        }
        return new PnGoodsInfoHelper(driver);
    }

    public void checkThatInformationCorrect (PnAirConditionedPage airConditionedPage, PnGoodsInfoPage goodsInfoPage) {
        List<String> shortInfo = new ArrayList<String>();
        List<String> fullInfo = new ArrayList<String>();
        WaitHelper.waitForElements(airConditionedPage.getConditionersDescription(), driver);
        WaitHelper.waitForElements(airConditionedPage.getConditionersDescription(), driver);
        for (int i=0; i< airConditionedPage.getConditionersNames().size(); i++) {
            shortInfo.addAll(Arrays.asList(airConditionedPage.getConditionersDescription().get(i).getText().toLowerCase().replaceAll("\\p{P}", "").split(" ")));
            shortInfo.remove("помещение");
            fullInfo.addAll(goToFullDescription(airConditionedPage.getConditionersNames().get(i), goodsInfoPage).getFullDescription(goodsInfoPage));
            driver.navigate().back();
        }
      //  System.out.println(shortInfo);
      //  System.out.println(fullInfo);
        Assert.assertTrue(fullInfo.containsAll(shortInfo));
    }

    public PnGoodsInfoHelper goToFullDescription(WebElement goodsName, PnGoodsInfoPage goodsInfoPage) {
        goodsName.click();
        return new PnGoodsInfoHelper(driver);
    }
}