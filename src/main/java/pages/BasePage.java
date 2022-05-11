package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.internal.EventFiringMouse;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.time.Duration;

public class BasePage {

    private static Logger log = LoggerFactory.getLogger("BasePage.class");
    public WebDriver driver;
    public WebDriverWait wait;
    private EventFiringMouse eventFiringMouse;
    private WebListener webListener;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(System.getProperty("waitTime"))));
        webListener = new WebListener();
        eventFiringMouse = new EventFiringMouse(driver, webListener);
    }

    public void click(WebElement element) {
        waitToBeClickable(element);
        log.info("Clicking on: " + element.getText());
        element.click();
    }

    public void mouseHover(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        Locatable item = (Locatable) element;
        Coordinates coordinates = item.getCoordinates();
        log.info("Moving mouse");
        eventFiringMouse.mouseMove(coordinates);
    }

    public void waitToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement findElementInAnotherElement(WebElement mainElement, String elementToFind) {
        return mainElement.findElement(By.cssSelector(elementToFind));
    }

    public String getAttributeValue(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }

    public void switchToIframe(WebElement element) {
        driver.switchTo().frame(element);
    }
}
