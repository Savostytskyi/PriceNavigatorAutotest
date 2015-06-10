package core.helpers.generalhelpers;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * @author Anton_Savostytskyi on 02.06.2015.
 */

public class WaitHelper {

    public static final int SMALL_DELAY = 5000;
    public static final int MIDDLE_DELAY = 15000;
    private static Logger logger = Logger.getLogger(WaitHelper.class);

    public static void waitForElementIsClickable(WebElement webElement, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, SMALL_DELAY);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
        } catch (NoSuchElementException e) {
            logger.error("No such element with tag name: "+webElement.getTagName());
        } catch (ElementNotVisibleException ex) {
            logger.error("Element not visible with tag name: "+webElement.getTagName());
        }
    }

    public static void waitForElementVisible(WebElement webElement, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, SMALL_DELAY);
        try {
            wait.until(ExpectedConditions.visibilityOf(webElement));
        } catch (NoSuchElementException e) {
            logger.error("No such element with tag name: "+webElement.getTagName());
        } catch (ElementNotVisibleException ex) {
            logger.error("Element not visible with tag name: "+webElement.getTagName());
        }
    }

    public static void waitForElements(List<WebElement> listWebElements, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, MIDDLE_DELAY);
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(listWebElements));
        } catch (NoSuchElementException e) {
            logger.error("No such elements");
        } catch (ElementNotVisibleException ex) {
            logger.error("Elements not visible");
        }
    }

    public static void delay(int sec) {
        try {
            Thread.sleep(sec);
        } catch (InterruptedException e) {
            logger.error("Elements not visible");
        }
    }
}

