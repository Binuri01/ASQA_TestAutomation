package LassanaFlora_POM.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
public class TestNGUtilities {
//        WebDriver driver = null;
        protected BrowserFactory browserFactory;

        @BeforeMethod
        public void initializeBrowser(){
            browserFactory = BrowserFactory.getBrowserFactory();
            WebDriver driver = browserFactory.getDriver();

            driver.manage().window().maximize();
            driver.get("https://lassana.com/");
        }

        @AfterMethod
        public void closeBrowser(){
            browserFactory.closeDriver();
        }
}
