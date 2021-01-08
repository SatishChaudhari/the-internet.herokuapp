package javascript;

import base.BaseTests;
import org.testng.annotations.Test;

public class JavaScriptTest extends BaseTests {

    @Test (groups = {"Regression"})
    public void testScrollToTable(){
        homePage.clickLargeAndDeepDom().scrollToTable();

    }
    @Test (groups = {"Regression"})
    public void testScrollToFifthParagraph(){
        homePage.clickInfiniteScroll().scrollToParagraph(5);
    }
}
