package pages;
import config.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static tests.BaseTest.logger;
public class BasePage {
    private WebElement findElement(By by) {
        return ApplicationManager.getDriver().findElement(by);
    }

    private List<WebElement> findElements(By by) {
        return ApplicationManager.getDriver().findElements(by);
    }

    protected WebElement getElementByIndex(By by, int index) {
        return findElements(by).get(index);
    }

    protected void click(By by) {
        findElement(by).click();
    }

    protected String getText(WebElement element) {
        return element.getText();
    }

    protected void sendText(By by, String text) {
        WebElement element = findElement(by);
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public boolean isTextEqual(String actualRes, String expectedRes) {
        if(actualRes.equals(expectedRes)) {
            return true;
        } else {
            logger.info("actual result: " + actualRes +
                    " expected result: " + expectedRes);
            return false;
        }
    }

}
