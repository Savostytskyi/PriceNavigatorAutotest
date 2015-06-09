package core.helpers.pagehelpers;

import core.helpers.generalhelpers.WaitHelper;
import org.openqa.selenium.WebDriver;
import pages.PnMainPage;

/**
 * Created by Anton_Savostytskyi on 05.06.2015.
 */
public class PnMainHelper {

    private WebDriver driver;

    public PnMainHelper(WebDriver driver) {
        this.driver = driver;
    }

    public PnRefrigeratorsHelper navigateToRefrigerators(PnMainPage main) {
        WaitHelper.waitForElementIsClickable(main.getRefrigeratorsLink(), driver);
        main.clickRefrigeratorsItem();
        return new PnRefrigeratorsHelper(driver);
    }

    public PnMicrowavesHelper navigateToMicrowaves(PnMainPage main) {
        WaitHelper.waitForElementIsClickable(main.getMicrowavesLink(), driver);
        main.clickMicrowavesItem();
        return new PnMicrowavesHelper(driver);
    }

    public PnWashersHelper navigateToWashers(PnMainPage main) {
        WaitHelper.waitForElementIsClickable(main.getWashersLink(), driver);
        main.clickWashersItem();
        return new PnWashersHelper(driver);
    }

    public PnBreadMakerHelper navigateToBreadMakers(PnMainPage main) {
        WaitHelper.waitForElementIsClickable(main.getBreadMakersLink(), driver);
        main.clickBreadMakerItem();
        return new PnBreadMakerHelper(driver);
    }

    public PnAirConditionedHelper navigateAirConditioned(PnMainPage main) {
        WaitHelper.waitForElementIsClickable(main.getAirConditionedLink(), driver);
        main.getAirConditionedLink().click();
        return new PnAirConditionedHelper(driver);
    }
}
