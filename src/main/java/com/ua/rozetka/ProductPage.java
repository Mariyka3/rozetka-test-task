package com.ua.rozetka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by mariia.dibrivna on 3/20/2018.
 */
public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "towishlist")
    private WebElement toWishList;

    @FindBy(xpath = ".//a[contains(@class,'wishlist-link-count')]")
    private WebElement enterToWishList;

    @FindBy(name = "close")
    private WebElement close;

    @FindBy(xpath = ".//h1[@class = 'detail-title']")
    private WebElement productTitle;

    public String getProductTitle() {
        return productTitle.getText().trim();
    }

    public void clickToWish() {
        clickButton(toWishList);
    }

    public void goToWishList() {
        if (close.isDisplayed()) {
            clickButton(close);
            clickButton(enterToWishList);
        } else {
            clickButton(enterToWishList);
        }
    }
}
