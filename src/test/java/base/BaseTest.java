package base;

import core.driver.DriverInitializer;
import core.helpers.pagehelpers.PnMainHelper;
import core.helpers.pagehelpers.PnRefrigeratorsHelper;
import core.property.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.PnMainPage;
import pages.PnRefrigeratorsPage;

/**
 * Created by Anton_Savostytskyi on 02.06.2015.
 */

public class BaseTest {
    protected WebDriver driver;

    protected PnMainPage mainPage;
    protected PnRefrigeratorsPage refrigeratorsPage;

    protected PnMainHelper mainHelper;
    protected PnRefrigeratorsHelper refrigeratorsHelper;


    @BeforeMethod
    protected void setupBeforeSuite() {
        driver = DriverInitializer.getWebFactoryInstance("firefox");
        driver.manage().window().maximize();
        driver.get(PropertyReader.getInstance().getProperty("test.url"));
    }

    @AfterMethod
    protected void tearDown() {
        if (driver != null)
            driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

}

