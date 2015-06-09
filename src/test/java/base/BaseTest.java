package base;

import core.driver.DriverInitializer;
import core.helpers.pagehelpers.*;
import core.property.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.io.IOException;

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
    protected PnBreadMakerPage breadMakerPage;
    protected PnAirConditionedPage airConditionedPage;
    protected PnGoodsInfoPage goodsInfoPage;

    protected PnMainHelper mainHelper;
    protected PnRefrigeratorsHelper refrigeratorsHelper;
    protected PnMicrowavesHelper microwaveHelper;
    protected CompareHelper compareHelper;
    protected PnWashersHelper washersHelper;
    protected PnBreadMakerHelper breadMakerHelper;
    protected PnAirConditionedHelper airConditionedHelper;
    protected PnGoodsInfoHelper goodsInfoHelper;


    @BeforeMethod
    protected void setupBeforeSuite() {
        driver = DriverInitializer.getWebFactoryInstance("ie");
        driver.manage().window().maximize();
        driver.get(PropertyReader.getInstance().getProperty("test.url"));
    }

    @AfterSuite
    protected void tearDown() throws IOException, InterruptedException {
        if (driver != null) {
            if (((RemoteWebDriver) driver).getCapabilities().getBrowserName().toLowerCase().equals("firefox")) {
                Runtime.getRuntime().exec("taskkill /F /IM firefox.exe");
                Thread.sleep(5000);
                Runtime.getRuntime().exec("taskkill /F /IM plugin-container.exe");
                Runtime.getRuntime().exec("taskkill /F /IM WerFault.exe");
            } else driver.quit();
        }
    }
}

