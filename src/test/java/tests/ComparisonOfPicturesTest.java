package tests;

import base.Pages;
import org.junit.jupiter.api.Test;

public class ComparisonOfPicturesTest extends Pages {

    @Test
    public void shouldMatchMiniaturePictureWithMainPicture() {

        homePage.moveToBlouses();
        categoryPage.moveToPicture();
        quickViewPage.comparisonOfPictures();
    }
}
