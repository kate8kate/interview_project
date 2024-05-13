package tests;
import config.ApplicationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pages.*;

import java.lang.reflect.Method;
import java.util.Arrays;

public class BaseTest {
    public static Logger logger = LoggerFactory.getLogger(BaseTest.class);
    ApplePage applePage = new ApplePage();
    ElektronikPage elektronikPage = new ElektronikPage();
    HandysSmartphonesPage handysSmartphonesPage = new HandysSmartphonesPage();
    HomePage homePage = new HomePage();
    SearchResultPage searchResultPage = new SearchResultPage();

    @BeforeSuite
    public void startBrowser() {
        ApplicationManager.init();
    }

    @AfterSuite
    public void stopBrowser() {
        ApplicationManager.tearDown();
    }

    @BeforeMethod
    public void startTest(Method method, Object[] o) {
        logger.info("Start test: " + method.getName() +
                " with data " + Arrays.asList(o));
    }

    @AfterMethod
    public void stopTest(ITestResult result) {
        if(result.isSuccess()) {
            logger.info("PASSED " + result.getMethod().getMethodName());
        } else {
            logger.error("FAILED " + result.getMethod().getMethodName());
        }
        logger.info("Stop test");
        logger.info("-------------------------------------------------------");
    }
}
