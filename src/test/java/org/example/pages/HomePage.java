package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    private static final int TIMEOUT = 3;
    private static final String HOME_PAGE_URL = "https://thinking-tester-contact-list.herokuapp.com/";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToHomePage() {
        driver.navigate().to(HOME_PAGE_URL);
    }

    private WebElement getElement(By locator) {
        waitForElementToBeVisible(locator, TIMEOUT);
        return driver.findElement(locator);
    }

    public WebElement findEmailField() {
        return getElement(By.id("email"));
    }

    public WebElement findPasswordField() {
        return getElement(By.id("password"));
    }

    public WebElement locateSubmitButton() {
        return getElement(By.id("submit"));
    }

    public void performLogin(String email, String password) {
        findEmailField().sendKeys(email);
        findPasswordField().sendKeys(password);
        locateSubmitButton().click();
    }

    public WebElement locateErrorMessage() {
        return getElement(By.id("error"));
    }

    public WebElement getContactListHeader() {
        return getElement(By.xpath("//h1[text()='Contact List']"));
    }
}
