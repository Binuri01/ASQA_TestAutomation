package LassanaFlora_POM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseURL{

        @FindBy(xpath = "//div[contains(text(), 'Account')]")
        public WebElement LoginButton;

        @FindBy(xpath = "//span[contains(text(), 'Categories')]")
        public WebElement Category;

        @FindBy(xpath = "//p[contains(text(), 'Gifts')]")
        public WebElement Gifts;

        @FindBy(xpath = "//p[contains(text(), 'Flowers')]")
        public WebElement Flowers;

        @FindBy(xpath = "//div[contains(text(), 'Binuri')]")
        public WebElement Account;

        public HomePage(WebDriver driver) {
            super(driver);
        }

    public LoginPage selectLoginButton() throws InterruptedException {
            System.out.println("Before login");
            LoginButton.click();
            Thread.sleep(2000);
            System.out.println("After login");
            return PageFactory.initElements(driver, LoginPage.class);
    }

    public void selectCategory(){
            Category.click();
    }

    public GiftsPage selectGifts(){
            Gifts.click();
            return PageFactory.initElements(driver, GiftsPage.class);
    }

    public FlowerPage selectFlowers(){
        Flowers.click();
        return PageFactory.initElements(driver, FlowerPage.class);
    }

    public AccountPage selectAccount(){
            Account.click();
            return PageFactory.initElements(driver, AccountPage.class);
    }

}
