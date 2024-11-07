package LassanaFlora_POM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlowerPage extends BaseURL{

    public FlowerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[contains(text(), 'Show Filters')]")
    public WebElement Filters;

    @FindBy(xpath = "//div[@class='lv-filters-img']/img[@alt='filterclose']")
    public WebElement Price;

    @FindBy(xpath = "//input[@id='lv-custom-checkbox-2']")
    public WebElement PriceRange;

    public void selectFilters() throws InterruptedException {
        Thread.sleep(2000);
        Filters.click();
    }

    public void filterPrice() throws InterruptedException {
        Thread.sleep(2000);
        Price.click();
    }

    public void selectPriceRange(){
        PriceRange.click();
    }

}
