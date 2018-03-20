package com.ua.rozetka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by mariia.dibrivna on 3/19/2018.
 */
public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "signin")
    private WebElement signInLink;

    @FindBy(name = "login")
    private WebElement loginInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(name = "auth_submit")
    private WebElement submitButton;

    @FindBy(name = "profile")
    private WebElement profileName;

    @FindBy(xpath = ".//a[contains(@href, 'computers-notebooks')]")
    private WebElement notebookCategory;

    @FindBy(xpath = ".//p[@class = 'pab-h3']/a[contains(@href, 'notebooks')]")
    private WebElement notebooksItem;

    @FindBy(xpath = ".//a[contains(@href,'price=10000-12999')]")
    private WebElement priceFilter10000;

    @FindBy(xpath = ".//span[@class='g-rating-reviews']")
    private List<WebElement> allRatingReviews;

    @FindBy(xpath = ".//div[@class = 'g-i-tile-i-title clearfix']")
    private List<WebElement> allProducts;


    public void signIn(String login, String password) {
        clickButton(signInLink);
        sendKeys(loginInput, login);
        sendKeys(passwordInput, password);
        clickButton(submitButton);
        waitUntilElementIsVisible(profileName);
    }

    public void chooseNotebooks() {
        clickButton(notebookCategory);
        clickButton(notebooksItem);
        clickButton(priceFilter10000);
        clickButton(productWithMaxReviews());
    }

    private WebElement productWithMaxReviews() {
        int max = 0;
        int index = 0;
        for (int i = 0; i < allRatingReviews.size(); i++) {
            int number = returnNumber(allRatingReviews.get(i).getText());
            if (number > max) {
                max = number;
                index = i;
            }
        }
        return allProducts.get(index);
    }

    private int returnNumber(String str) {
        String answer = "0";
        char[] quantity = str.toCharArray();
        for (int i = 0; i < quantity.length; i++) {
            Character num = (Character) quantity[i];
            if (Character.isDigit(num)) {
                answer += quantity[i];
            }
        }
        return Integer.parseInt(answer);
    }
}
