package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;


public class QuickViewPage extends BasePage {

    private static Logger log = LoggerFactory.getLogger("QuickViewPage.class");

    public QuickViewPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#thumbs_list a")
    private List<WebElement> thumbsList;

    @FindBy(css = "#bigpic")
    private WebElement viewedImage;

    @FindBy(css = ".fancybox-iframe")
    private WebElement iframe;

    public QuickViewPage comparisonOfPictures() {
        switchToIframe(iframe);
        waitToBeVisible(viewedImage);
        for (WebElement element : thumbsList) {
            mouseHover(element);
            element = findElementInAnotherElement(element, "img");
            assert(getAttributeValue(element, "src").
                    equals(getAttributeValue(viewedImage, "src").replaceAll("large", "cart")));
            log.info("Image with id: " + getAttributeValue(element, "id") + " was checked");
        }
        return this;
    }


}
