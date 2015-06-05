package core.helpers.generalhelpers;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * Created by Anton_Savostytskyi on 02.06.2015.
 */
public class WaitHelper {

    public static final int HALF_SECOND_DELAY = 500;
    public static final int SECOND_DELAY = 1000;
    public static final int SMALL_DELAY = 5000;
    public static final int MIDDLE_DELAY = 15000;
    public static final int LONG_DELAY = 30000;

    public static boolean waitForElement(WebElement webElement, int milliseconds, WebDriver driver) {
        for (int i = 0; i < milliseconds; i += HALF_SECOND_DELAY) {
            driver.manage().timeouts().implicitlyWait(HALF_SECOND_DELAY, TimeUnit.MILLISECONDS);
            try {
                if (webElement.isDisplayed()) {
                    return true;
                } else {
                    delay(HALF_SECOND_DELAY);
                }
            } catch (NoSuchElementException e) {
            } finally {
                driver.manage().timeouts().implicitlyWait(MIDDLE_DELAY, TimeUnit.MILLISECONDS);
            }
        }
        return false;
    }

    public static boolean waitForElementIsClickable(WebElement webElement, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, SMALL_DELAY);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        } catch (ElementNotVisibleException ex) {
            return false;
        }
    }

    public static boolean waitForElementVisible(WebElement webElement, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, SMALL_DELAY);
        try {
            wait.until(ExpectedConditions.visibilityOf(webElement));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        } catch (ElementNotVisibleException ex) {
            return false;
        }
    }

    public static boolean waitForElements(List<WebElement> listWebElements, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, SMALL_DELAY);
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(listWebElements));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        } catch (ElementNotVisibleException ex) {
            return false;
        }
    }

    public static void delay(int sec) {
        try {
            Thread.sleep(sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
