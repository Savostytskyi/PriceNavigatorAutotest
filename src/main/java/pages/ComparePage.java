package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * @author Anton_Savostytskyi on 07.06.2015.
 */

public class ComparePage {
    private WebDriver driver;

    public final String GOODS_PROPERTIES = "//table[@class='compare']//td[position() >1]";
    public final String GOODS_TABLE_ROWS = "//table[@class='compare']//td[position() >1]//.. | //table[@class='compare']//td[position() >1]";
    public final String GOODS_TITLES = "//table[@class='compare']//th[@class='row-2']/a";

    public ComparePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = GOODS_PROPERTIES)
    private List<WebElement> goodsProperties;

    public List<WebElement> getGoodsProperties() {
        return goodsProperties;
    }

    @FindBy(xpath = GOODS_TABLE_ROWS)
    private List<WebElement> goodsTableRows;

    public List<WebElement> getGoodsTableRows() {
        return goodsTableRows;
    }

    @FindBy(xpath = GOODS_TITLES)
    private List<WebElement> goodsTitles;

    public List<WebElement> getGoodsTitles() {
        return goodsTitles;
    }
}
