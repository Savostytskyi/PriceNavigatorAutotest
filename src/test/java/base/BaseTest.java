package base;

import core.driver.DriverInitializer;
import core.helpers.pagehelpers.*;
import core.property.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import pages.*;

/**
 * Created by Anton_Savostytskyi on 02.06.2015.
 */

public class BaseTest {
    protected WebDriver driver;

    protected PnMainPage mainPage;
    protected PnRefrigeratorsPage refrigeratorsPage;
    protected PnMicrowavesPage microwavePage;
    protected ComparePage comparePage;
    protected PnWashersPage washersPage;

    protected PnMainHelper mainHelper;
    protected PnRefrigeratorsHelper refrigeratorsHelper;
    protected PnMicrowavesHelper microwaveHelper;
    protected CompareHelper compareHelper;
    protected PnWashersHelper washersHelper;


    @BeforeMethod
    protected void setupBeforeSuite() {
        driver = DriverInitializer.getWebFactoryInstance("ie");
        driver.manage().window().maximize();
        driver.get(PropertyReader.getInstance().getProperty("test.url"));
    }

    @AfterSuite
    protected void tearDown() {
        if (driver != null)
            driver.quit();
    }
}

