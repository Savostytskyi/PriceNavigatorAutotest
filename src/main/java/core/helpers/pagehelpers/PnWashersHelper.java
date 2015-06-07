package core.helpers.pagehelpers;

import core.helpers.generalhelpers.VerifyHelper;
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

    public PnWashersHelper(WebDriver driver) {
        this.driver = driver;
    }

    public PnWashersHelper checkThatFilterWorkCorrectly(PnWashersPage washersPage) {
        List<Integer> goods = new ArrayList<Integer>();
        List<Integer> filtredGoods = new ArrayList<Integer>();
        selectCorrespondingPrices(goods, washersPage);
        washersPage.clickFilterOn();
        manualFilter(goods);
        selectCorrespondingPrices(filtredGoods, washersPage);
        Assert.assertTrue(goods.containsAll(filtredGoods));
        Assert.assertTrue(goods.size() == filtredGoods.size());
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


