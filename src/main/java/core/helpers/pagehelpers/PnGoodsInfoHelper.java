package core.helpers.pagehelpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.PnGoodsInfoPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Anton_Savostytskyi on 08.06.2015.
 */
public class PnGoodsInfoHelper {
    private WebDriver driver;

    public PnGoodsInfoHelper(WebDriver driver) {
        this.driver = driver;
    }

    public List<String> getFullDescription(PnGoodsInfoPage goodsInfoPage) {
        List<String> info = new ArrayList<String>();
        for (WebElement property: goodsInfoPage.getGoodsInfo()) {
            info.addAll(Arrays.asList(property.getText().toLowerCase().replaceAll("\\p{P}", "").split(" ")));
        }

        return info;
    }
}
