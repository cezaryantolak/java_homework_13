package tests;

import base.Pages;
import org.junit.jupiter.api.Test;

public class ComparisonOfPicturesTest extends Pages {

    @Test
    public void shouldMatchMiniaturePictureWithMainPicture() throws InterruptedException {

        Thread.sleep(100);
        homePage.moveToBlouses();
        Thread.sleep(100);
        categoryPage.moveToPicture();
        Thread.sleep(100);
        quickViewPage.comparisonOfPictures();
    }
}
