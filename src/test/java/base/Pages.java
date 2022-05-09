package base;

import org.junit.jupiter.api.BeforeEach;
import pages.CategoryPage;
import pages.HomePage;
import pages.QuickViewPage;

public class Pages extends TestBase {

    public HomePage homePage;
    public CategoryPage categoryPage;
    public QuickViewPage quickViewPage;

    @BeforeEach
    public void testSetup() {
        homePage = new HomePage(webDriver);
        categoryPage = new CategoryPage(webDriver);
        quickViewPage = new QuickViewPage(webDriver);
    }

}
