package navigation;

import base.BaseTests;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTests {

    @Test (enabled = false)
    public void testNavigator(){
        homePage.clickDynamicLoading().clickExample1();
        getWindowManager().goBack();
        getWindowManager().refreshPage();
        getWindowManager().goForward();
        getWindowManager().goTo("https://google.com");
    }
    @Test
    public void testSwitchTab(){
        homePage.clickMultipleWindows().clickHere();
        getWindowManager().switchToTab("New Window");
    }
}
