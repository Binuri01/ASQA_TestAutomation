package LassanaFlora_POM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BaseURL{
    @FindBy(xpath = "//input[@id='firstName']")
    public WebElement NameField;

    @FindBy(xpath = "//button[contains(text(), 'Save Changes')]")
    public WebElement SaveButton;

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public void selectNameField(String newName) {
        try {
            NameField.clear();
            Thread.sleep(4000);

            NameField.sendKeys(newName);
        } catch (Exception e) {
            System.out.println("Error selecting name field: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void clickSave(){
        SaveButton.click();
    }
}
