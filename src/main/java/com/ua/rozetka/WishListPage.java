package com.ua.rozetka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by mariia.dibrivna on 3/19/2018.
 */
public class WishListPage extends BasePage {
    public WishListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//img[contains(@class,'wishlist-g-i-remove-icon')]")
    private WebElement deleteWish;

    @FindBy(name = "wishlist-block-goods-item")
    private WebElement wish;

    @FindBy(xpath = ".//a[contains(@class,'wishlist-g-i-title-link')]")
    private WebElement wishProduct;

    public void deleteWish() {
        clickButton(deleteWish);
    }

    public String getProductTitle() {
        return wishProduct.getText().trim();
    }

    public boolean isProductDisplayed(){
        return wishProduct.isDisplayed();
    }
}
