package LassanaFlora_POM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GiftsPage extends BaseURL{
    @FindBy(xpath = "//img[@class='carouselItemImage']")
    public WebElement Item;

    @FindBy(xpath = "//span[contains(text(), 'ADD TO CART')]")
    public WebElement Cart;

    @FindBy(xpath = "//img[@id='headerRightShopCartIcon']")
    public WebElement CartIcon;

    public void selectGift(){
        Item.click();
    }

    public void addToCart(){
        Cart.click();
    }

    public void viewCart(){
        CartIcon.click();
    }

    public GiftsPage(WebDriver driver) {
        super(driver);
    }
}
