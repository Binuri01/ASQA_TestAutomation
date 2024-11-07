package LassanaFlora_POM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class BaseURL {
        WebDriver driver = null;
        public BaseURL(WebDriver driver){
            this.driver = driver;
        }
        public HomePage loadUrl(){
            driver.get("https://www.lassana.com/");
            return  PageFactory.initElements(driver, HomePage.class);
        }

        public void scrollPage(WebDriver driver, int x, int y){
            new Actions(driver).scrollByAmount(x, y).perform();
        }
}
