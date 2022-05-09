package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends BasePage {

    private static Logger log = LoggerFactory.getLogger("HomePage.class");

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".sf-menu>li:nth-of-type(1)>a")
    private WebElement women;
    @FindBy(css = "[title=Blouses]")
    private WebElement blouses;

    public CategoryPage moveToBlouses() {
        mouseHover(women);
        click(blouses);
        return new CategoryPage(driver);
    }
}
