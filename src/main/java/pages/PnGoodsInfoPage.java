package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by Savostytskyi Anton on 08.06.2015.
 */
public class PnGoodsInfoPage {
    private WebDriver driver;

    public final String ALL_GOODS_INFO = "//div[@class='row']//span[2]";

    public PnGoodsInfoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ALL_GOODS_INFO)
    private List<WebElement> goodsInfo;

    public List<WebElement> getGoodsInfo() {
        return goodsInfo;
    }

}
