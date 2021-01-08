package fileUpload;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FileUploadTests extends BaseTests {

    @Test(groups = "Smoke")
    public void testFileUpload(){
        var uploadPage = homePage.clickFileUpload();
        uploadPage.uploadFile("/Users/satesh/WebDriver_Java/resources/File_Upload_Test.xlsx");

        assertEquals(uploadPage.getUploadFiles(), "File_Upload_Test.xlsx", "Uploaded file incorrect");
    }
}
