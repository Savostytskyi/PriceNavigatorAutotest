package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by Savostytskyi Anton on 08.06.2015.
 */
public class PnAirConditionedPage {
    private WebDriver driver;

    public final String CONDITIONERS_NAME = "(//div[@class='name']//a)[position()<6]";
    public final String CONDITIONERS_DESCRIPTION = "(//div[@class='description'])[position()<6]";

    public PnAirConditionedPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = CONDITIONERS_NAME)
    private List<WebElement> conditionersNames;

    public List<WebElement> getConditionersNames() {
        return conditionersNames;
    }

    @FindBy(xpath = CONDITIONERS_DESCRIPTION)
    private List<WebElement> conditionersDescription;

    public List<WebElement> getConditionersDescription() {
        return conditionersDescription;
    }

}
