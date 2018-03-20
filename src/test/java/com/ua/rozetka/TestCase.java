package com.ua.rozetka;

import com.ua.rozetka.business.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.ua.rozetka.util.PropertiesUtil;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

/**
 * Created by mariia.dibrivna on 3/19/2018.
 */
public class TestCase {

    private PropertiesUtil propertiesUtil = PropertiesUtil.getInstance();
    private WebDriver driver;
    private String pathToChrome = propertiesUtil.get("config.properties", "path.to.chrome.driver");
    private String url = propertiesUtil.get("config.properties", "url");

    @Before
    public void setUp() throws FileNotFoundException {
        System.setProperty("webdriver.chrome.driver", pathToChrome);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    @Test
    public void addToWishListProductWithMaxReviewsTest(){
        driver.get(url);
        User user = new User();

        MainPage mainPage = new MainPage(driver);
        mainPage.signIn(user.getLogin(), user.getPassword());
        mainPage.chooseNotebooks();

        ProductPage productPage = new ProductPage(driver);
        productPage.clickToWish();

        String expectedTitle = productPage.getProductTitle();
        productPage.goToWishList();

        WishListPage wishListPage = new WishListPage(driver);

        Assert.assertTrue(wishListPage.isProductDisplayed());
        Assert.assertEquals(expectedTitle, wishListPage.getProductTitle());
    }

    @After
    public void tearDown(){
        WishListPage wishListPage = new WishListPage(driver);
        wishListPage.deleteWish();

        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
