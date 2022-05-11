package base;

import configuration.AppProperties;
import configuration.browser.BrowserHandler;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.WebListener;

public class TestBase {

    private static Logger log = LoggerFactory.getLogger("TestBase.class");
    protected WebDriver webDriver;
    protected static BrowserHandler browserHandler;
    private static AppProperties appProperties;
    public EventFiringWebDriver driver;
    private WebListener webListener;
    String url = "http://automationpractice.com/index.php";

    @BeforeAll
    static void beforeAll() {
        appProperties = AppProperties.getInstance();
        log.info("ENVIRONMENT SET UP PROPERLY");
    }

    @BeforeEach
    void beforeEach() {
        browserHandler = new BrowserHandler();
        webDriver = browserHandler.getDriver();
        driver = new EventFiringWebDriver(webDriver);
        webListener = new WebListener();
        driver.register(webListener);
        log.info("<<<<<DRIVER INITIALIZED>>>>>");
        driver.get(System.getProperty("appUrl"));
    }

    @AfterEach
    void tearDown() {
        webDriver.quit();
        log.info("DRIVER CLOSED PROPERLY");
    }
}
