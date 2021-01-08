package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage {

    private WebDriver driver;

    public SecureAreaPage(WebDriver driver) {
        this.driver = driver;
    }
    private By statusAlert = By.id("flash");

    public String getAlertText(){
        return driver.findElement(statusAlert).getText();
    }


}
