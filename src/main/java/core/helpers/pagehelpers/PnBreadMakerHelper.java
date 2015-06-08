package core.helpers.pagehelpers;

import core.helpers.generalhelpers.VerifyHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.PnBreadMakerPage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Anton_Savostytskyi on 08.06.2015.
 */
public class PnBreadMakerHelper {
    private WebDriver driver;
    private static Logger logger = Logger.getLogger(PnBreadMakerHelper.class);

    public PnBreadMakerHelper(WebDriver driver) {
        this.driver = driver;
    }

    public PnBreadMakerHelper checkThatFilterByBrandWorkCorrectly(PnBreadMakerPage breadMakerPage) {
        List<String> goods = new ArrayList<String>();
        List<String> filtredGoods = new ArrayList<String>();
        selectCorrespondingBrand(goods, breadMakerPage);
        breadMakerPage.clickFilterByBrandOn();
        manualFilterByBrand(goods);
        selectCorrespondingBrand(filtredGoods, breadMakerPage);
        logger.info("Goods that corresponding brand using manual filter: "+goods.size()+" items");
        logger.info("Goods that corresponding brang using web page filter: "+filtredGoods.size()+" items");
        Assert.assertTrue(goods.containsAll(filtredGoods), "Assert that all the products of this brand are selected");
        Assert.assertTrue(goods.size() == filtredGoods.size(), "Check that there are no extra items");
        return new PnBreadMakerHelper(driver);
    }

    public PnBreadMakerHelper checkThatFilterByWeightAdjustmentWorkCorrectly(PnBreadMakerPage breadMakerPage) {
        List<String> goods = new ArrayList<String>();
        List<String> filtredGoods = new ArrayList<String>();
        selectCorrespondingWeight(goods, breadMakerPage);
        breadMakerPage.clickFilterByWeightAdjustment();
        manualFilterByWeightAdjustment(goods);
        selectCorrespondingWeight(filtredGoods, breadMakerPage);
        logger.info("Goods that corresponding weight adjustment using manual filter: "+goods.size()+" items");
        logger.info("Goods that corresponding weight adjustment using web page filter: "+filtredGoods.size()+" items");
        Assert.assertTrue(goods.containsAll(filtredGoods), "Assert that all the products with weight adjustment are selected");
        Assert.assertTrue(goods.size() == filtredGoods.size(), "Check that there are no extra items");
        return new PnBreadMakerHelper(driver);
    }

    public void selectCorrespondingBrand(List<String> parameters, PnBreadMakerPage breadMakerPage) {
        while (VerifyHelper.isElementPresent(By.xpath(breadMakerPage.NEXT_PAGE_BUTTON), driver)) {
            addToBrandList(parameters, breadMakerPage);
            breadMakerPage.clickNextPageButton();
        }
        addToBrandList(parameters, breadMakerPage);
    }

    public void addToBrandList(List<String> brands, PnBreadMakerPage breadMakerPage) {
        for (WebElement brand : breadMakerPage.getNameList()) {
            String goodsPrice = brand.getText();
            brands.add(goodsPrice);
        }
    }

    public void selectCorrespondingWeight(List<String> parameters, PnBreadMakerPage breadMakerPage) {
        while (VerifyHelper.isElementPresent(By.xpath(breadMakerPage.NEXT_PAGE_BUTTON), driver)) {
            addToWeightList(parameters, breadMakerPage);
            breadMakerPage.clickNextPageButton();
        }
        addToWeightList(parameters, breadMakerPage);
    }

    public void addToWeightList(List<String> weights, PnBreadMakerPage breadMakerPage) {
        for (WebElement weight : breadMakerPage.getDescriptionList()) {
            String goodsPrice = weight.getText();
            weights.add(goodsPrice);
        }
    }



    public void manualFilterByBrand(List<String> brands) {
        Iterator<String> iteration = brands.iterator();
        while (iteration.hasNext()) {
            String brand = iteration.next();
            if (!brand.contains("Gorenje")) {
                iteration.remove();
            }
        }
    }

    public void manualFilterByWeightAdjustment(List<String> waights) {
        Iterator<String> iteration = waights.iterator();
        while (iteration.hasNext()) {
            String waight = iteration.next();
            if (!waight.contains("Регулировка веса")) {
                iteration.remove();
            }
        }
    }
}
