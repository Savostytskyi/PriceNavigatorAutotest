package base;

import core.driver.DriverInitializer;
import org.openqa.selenium.WebDriver;
import core.property.PropertyReader;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

/**
 * Created by Anton_Savostytskyi on 02.06.2015.
 */

public class BaseTest {
    private static WebDriver driver;

    @BeforeMethod
    protected void setupBeforeSuite() {
        driver = DriverInitializer.getWebFactoryInstance("firefox");
        driver.manage().window().maximize();
        driver.get(PropertyReader.getInstance().getProperty("url"));
    }

    @AfterMethod
    protected void tearDown() {
        if (driver != null)
            driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }

}

