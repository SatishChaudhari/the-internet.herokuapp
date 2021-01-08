package dropdown;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropDownTests extends BaseTests {

    @Test (groups = "Smoke")
    public void testSelectOption(){
        var dropdownPage = homePage.clickDropDown();

        String option = "Option 1";
        dropdownPage.selectFromDropDown(option);
        var selectedOptions = dropdownPage.getSelectedOptions();
        Assert.assertEquals(selectedOptions.size(), 1, "Incorrect number of selection");
        Assert.assertTrue(selectedOptions.contains(option), "Option not selected");
    }
}
