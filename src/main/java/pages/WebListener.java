package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebListener extends AbstractWebDriverEventListener {

    private static Logger log = LoggerFactory.getLogger("Pages.WebListener.class");

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        log.info("<<<<<<<<<<beforeNavigate>>>>>>>>>>>>>"+url);
    }

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        log.info("<<<<<<<<<<afterNavigate>>>>>>>>>>>>>"+url);
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        log.info("<<<<<<<<<<beforeClick>>>>>>>>>>>>>"+element.getText());
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        log.info("<<<<<<<<<<AfterClick>>>>>>>>>>>>>");
    }

    @Override
    public void beforeGetText(WebElement element, WebDriver driver) {
    }

    @Override
    public void afterGetText(WebElement element, WebDriver driver, String text) {
    }
}
