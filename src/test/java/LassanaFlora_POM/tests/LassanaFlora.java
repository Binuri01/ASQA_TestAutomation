package LassanaFlora_POM.tests;

import LassanaFlora_POM.pages.*;
import LassanaFlora_POM.utilities.ExcelTestDataProvider;
import LassanaFlora_POM.utilities.ExcelTestDataRow;
import LassanaFlora_POM.utilities.TestNGUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class LassanaFlora extends TestNGUtilities {

    @Test(dataProvider = "testData")
    public void searchGifts(ExcelTestDataRow testData) throws InterruptedException {
        BaseURL url = PageFactory.initElements(browserFactory.getDriver(), BaseURL.class);
        HomePage HomePage = url.loadUrl();
        Thread.sleep(2000);

        LoginPage loginPage = HomePage.selectLoginButton();
        loginPage.enterUsername(testData.getUsername());
        Thread.sleep(2000);
        loginPage.enterPassword(testData.getPassword());
        Thread.sleep(2000);
        HomePage homepage = loginPage.clickLogin();
        Thread.sleep(4000);

        homepage.selectCategory();
        Thread.sleep(2000);
        GiftsPage giftsPage = homepage.selectGifts();
        Thread.sleep(4000);

        giftsPage.scrollPage(browserFactory.getDriver(), 0, 500);
        Thread.sleep(4000);
        giftsPage.selectGift();
        Thread.sleep(2000);
        giftsPage.addToCart();
        Thread.sleep(2000);
        giftsPage.viewCart();
        Thread.sleep(4000);
    }

    @Test(dataProvider = "testData")
    public void searchFlowers(ExcelTestDataRow testData) throws InterruptedException {
        BaseURL url = PageFactory.initElements(browserFactory.getDriver(), BaseURL.class);
        HomePage HomePage = url.loadUrl();
        Thread.sleep(2000);

        LoginPage loginPage = HomePage.selectLoginButton();
        loginPage.enterUsername(testData.getUsername());
        Thread.sleep(2000);
        loginPage.enterPassword(testData.getPassword());
        Thread.sleep(2000);
        HomePage homepage = loginPage.clickLogin();
        Thread.sleep(4000);

        homepage.selectCategory();
        Thread.sleep(2000);
        FlowerPage flowerPage = homepage.selectFlowers();
        Thread.sleep(4000);

        flowerPage.scrollPage(browserFactory.getDriver(), 0, 500);
        Thread.sleep(5000);
        flowerPage.selectFilters();
        Thread.sleep(2000);
        flowerPage.filterPrice();
        Thread.sleep(2000);
        flowerPage.selectPriceRange();
        Thread.sleep(4000);
    }

    @Test(dataProvider = "testData")
    public void editAccount(ExcelTestDataRow testData) throws InterruptedException {
        BaseURL url = PageFactory.initElements(browserFactory.getDriver(), BaseURL.class);
        HomePage HomePage = url.loadUrl();
        Thread.sleep(2000);

        LoginPage loginPage = HomePage.selectLoginButton();
        loginPage.enterUsername(testData.getUsername());
        Thread.sleep(2000);
        loginPage.enterPassword(testData.getPassword());
        Thread.sleep(2000);
        HomePage homepage = loginPage.clickLogin();
        Thread.sleep(4000);

        AccountPage accountPage = homepage.selectAccount();
        Thread.sleep(4000);

        accountPage.selectNameField("Malsha");
        Thread.sleep(3000);

        accountPage.scrollPage(browserFactory.getDriver(), 0, 500);
        Thread.sleep(2000);
        accountPage.clickSave();
        Thread.sleep(5000);

        assertUpdatedAccountName(accountPage, "Malsha");
    }

    private void assertUpdatedAccountName(AccountPage accountPage, String newName) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(browserFactory.getDriver(), Duration.ofSeconds(10));
        WebElement updatedNameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("firstName")));
        Assert.assertEquals(newName, updatedNameField.getAttribute("value"));
    }


    @DataProvider(name = "testData")
    public Object[] provideTestData() throws Exception {
        List<ExcelTestDataRow> testDataList = ExcelTestDataProvider.getData();
        return testDataList.toArray(new Object[testDataList.size()]);
    }
}