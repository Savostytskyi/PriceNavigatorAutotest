package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Anton_Savostytskyi on 05.06.2015.
 */
public class PnMainPage {
    private WebDriver driver;

    public PnMainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public final String NAVIGATE_TO_REFRIGERATORS = "//div[@class='home-page-cloud']//h1[3]//following-sibling::a[3]";

    @FindBy(xpath = NAVIGATE_TO_REFRIGERATORS)
    private WebElement refrigeratorsLink;

    public WebElement getRefrigeratorsLink() {
        return refrigeratorsLink;
    }

    public PnRefrigeratorsPage clickRefrigeratorsItem() {
        getRefrigeratorsLink().click();
        return new PnRefrigeratorsPage(driver);
    }


}
