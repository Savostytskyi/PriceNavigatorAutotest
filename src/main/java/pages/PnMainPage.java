package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Anton_Savostytskyi on 08.06.2015.
 */
public class PnMainPage {
    private WebDriver driver;

    public PnMainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public final String NAVIGATE_TO_REFRIGERATORS = "//div[@class='home-page-cloud']//h1[3]//following-sibling::a[3]";
    public final String NAVIGATE_TO_MICROWAVES = "//div[@class='home-page-cloud']//h1[3]//following-sibling::a[6]";
    public final String NAVIGATE_TO_WASHERS = "//div[@class='home-page-cloud']//h1[3]//following-sibling::a[4]";
    public final String NAVIGATE_TO_BREADMAKERS = "//div[@class='home-page-cloud']//h1[3]//following-sibling::a[9]";
    public final String NAVIGATE_TO_AIRCONDITIONED = "//div[@class='home-page-cloud']//h1[3]//following-sibling::a[1]";

    @FindBy(xpath = NAVIGATE_TO_REFRIGERATORS)
    private WebElement refrigeratorsLink;

    public WebElement getRefrigeratorsLink() {
        return refrigeratorsLink;
    }

    @FindBy(xpath = NAVIGATE_TO_MICROWAVES)
    private WebElement microwavesLink;

    public WebElement getMicrowavesLink() {
        return microwavesLink;
    }

    @FindBy(xpath = NAVIGATE_TO_WASHERS)
    private WebElement washersLink;

    public WebElement getWashersLink() {
        return washersLink;
    }

    @FindBy(xpath = NAVIGATE_TO_BREADMAKERS)
    private WebElement breadMakersLink;

    public WebElement getBreadMakersLink() {
        return breadMakersLink;
    }

    @FindBy(xpath = NAVIGATE_TO_AIRCONDITIONED)
    private WebElement airConditionedLink;

    public WebElement getAirConditionedLink() {
        return airConditionedLink;
    }

    public PnMicrowavesPage clickMicrowavesItem() {
        getMicrowavesLink().click();
        return new PnMicrowavesPage(driver);
    }

    public PnRefrigeratorsPage clickRefrigeratorsItem() {
        getRefrigeratorsLink().click();
        return new PnRefrigeratorsPage(driver);
    }

    public PnWashersPage clickWashersItem() {
        getWashersLink().click();
        return new PnWashersPage(driver);
    }

    public PnBreadMakerPage clickBreadMakerItem() {
        getBreadMakersLink().click();
        return new PnBreadMakerPage(driver);
    }


}
