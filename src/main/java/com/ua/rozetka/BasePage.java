package com.ua.rozetka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by mariia.dibrivna on 3/19/2018.
 */
public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void clickButton(WebElement button) {
        button.click();
    }

    protected void sendKeys(WebElement webElement, String text) {
        webElement.clear();
        webElement.sendKeys(text);
    }

    public void waitUntilElementIsVisible(WebElement webElement) {
        try {
            new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(webElement));
        } catch (org.openqa.selenium.StaleElementReferenceException e) {
            new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(webElement));
        }
    }
}
