package core.helpers.pagehelpers;

import core.helpers.generalhelpers.VerifyHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.PnWashersPage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Savostytskyi Anton on 07.06.2015.
 */
public class PnWashersHelper {
    private WebDriver driver;
    private static Logger logger = Logger.getLogger(PnWashersHelper.class);

    public PnWashersHelper(WebDriver driver) {
        this.driver = driver;
    }

    public PnWashersHelper checkThatFilterByPriceWorkCorrectly(PnWashersPage washersPage) {
        List<Integer> goods = new ArrayList<Integer>();
        List<Integer> filtredGoods = new ArrayList<Integer>();
        selectCorrespondingPrices(goods, washersPage);
        washersPage.clickFilterOn();
        manualFilter(goods);
        selectCorrespondingPrices(filtredGoods, washersPage);
        logger.info("Goods that corresponding prices using manual filter: "+goods.size()+" items");
        logger.info("Goods that corresponding prices adjustment using web page filter: "+filtredGoods.size()+" items");
        Assert.assertTrue(goods.containsAll(filtredGoods), "Assert that all the products with corresponded prices are selected");
        Assert.assertTrue(goods.size() == filtredGoods.size(), "Check that there are no extra items");
        return new PnWashersHelper(driver);
    }

    public void selectCorrespondingPrices(List<Integer> prices, PnWashersPage washersPage) {
        while (VerifyHelper.isElementPresent(By.xpath(washersPage.NEXT_PAGE_BUTTON), driver)) {
            addToList(prices, washersPage);
            washersPage.clickNextPageButton();
        }
        addToList(prices, washersPage);
    }

    public void addToList(List<Integer> prices, PnWashersPage washersPage) {
        for (WebElement price : washersPage.getPriceList()) {
            Integer goodsPrice = Integer.parseInt(price.getText().replaceAll("\\D", ""));
            prices.add(goodsPrice);
        }
    }

    public void manualFilter(List<Integer> prices) {
        Iterator<Integer> iteration = prices.iterator();
        while (iteration.hasNext()) {
            Integer price = iteration.next();
            if ((price < 3000) || (price > 6000)) {
                iteration.remove();
            }
        }
    }
}


