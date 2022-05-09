package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CategoryPage extends BasePage {

    private static Logger log = LoggerFactory.getLogger("CategoryPage.class");

    public CategoryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".product_img_link img")
    private WebElement productImage;

    @FindBy(css = "a.quick-view")
    private WebElement quickViewButton;

    public QuickViewPage moveToPicture() {
        mouseHover(productImage);
        click(quickViewButton);
        return new QuickViewPage(driver);
    }


}
