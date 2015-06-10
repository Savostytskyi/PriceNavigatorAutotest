package core.helpers.generalhelpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import static org.testng.util.Strings.isNullOrEmpty;

/**
 * @author Anton_Savostytskyi on 02.06.2015.
 */
public class VerifyHelper {

    public static boolean verifyIsElementPresent (WebElement element) {
        if ((element != null) && (element.isDisplayed()) && (!isNullOrEmpty(element.getText())))
            return true;
        else return false;
    }

    public static boolean verifyIsElementsPresent (List<WebElement> elements) {
        for(WebElement element: elements) {
           if (!verifyIsElementPresent(element)) return false;
        }
        return true;
    }

    public static boolean verifyCorespondingColor(WebElement row, WebElement firstProperty, WebElement secondProperty) {
        if (firstProperty.getText().equals(secondProperty.getText())) {
            if (row.getAttribute("class").equals("different"))
                return false;
        } else if (!firstProperty.getText().equals(secondProperty.getText())) {
            if (!row.getAttribute("class").equals("different"))
                return false;
        }
        return true;
    }

    public static boolean verifyCorespondingColorOfList (List<WebElement> properties) {
        for (int i=0; i< properties.size()-3; i=i+3) {
            if (!verifyCorespondingColor(properties.get(i), properties.get(i+1), properties.get(i+2)))
            return false;
        }
        return true;
    }

   public static boolean isElementPresent(By by, WebDriver driver) {
        return !driver.findElements(by).isEmpty();
    }
}

