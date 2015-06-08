package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by Anton_Savostytskyi on 08.06.2015.
 */
public class PnBreadMakerPage {
    private WebDriver driver;

    public final String NAME_LIST = "//div[@class='name']//a";
    public final String NEXT_PAGE_BUTTON = "(//ul[@class='pager']//li[@class='pager-next']/a)[1]";
    public final String FILTER_BY_BRAND = "(//div[@class='is_empty_items']/a[7])[1]";
    public final String FILTER_BY_WEIGHT_ADJUSTMENT = "(//div[@class='is_empty_items']/a[2])[8]";
    public final String DESCRIPTION_LIST = "//div[@class='item']//div[@class='description']";

    public PnBreadMakerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = NAME_LIST)
    private List<WebElement> nameList;

    public List<WebElement> getNameList() {
        return nameList;
    }

    @FindBy(xpath = DESCRIPTION_LIST)
    private List<WebElement> descriptionList;

    public List<WebElement> getDescriptionList() {
        return descriptionList;
    }

    @FindBy(xpath = NEXT_PAGE_BUTTON)
    private WebElement nextPageButton;

    public WebElement getNextPageButton() {
        return nextPageButton;
    }

    @FindBy(xpath = FILTER_BY_BRAND)
    private WebElement byBrandFilter;

    public WebElement getByBrandFilter() {
        return byBrandFilter;
    }

    @FindBy(xpath = FILTER_BY_WEIGHT_ADJUSTMENT)
    private WebElement byWeightAdjustmentFilter;

    public WebElement getByWeightAdjustmentFilter() {
        return byWeightAdjustmentFilter;
    }

    public PnBreadMakerPage clickNextPageButton() {
        getNextPageButton().click();
        return new PnBreadMakerPage(driver);
    }

    public  PnWashersPage clickFilterByBrandOn () {
        getByBrandFilter().click();
        return new PnWashersPage(driver);
    }

    public  PnWashersPage clickFilterByWeightAdjustment () {
        getByWeightAdjustmentFilter().click();
        return new PnWashersPage(driver);
    }
}
