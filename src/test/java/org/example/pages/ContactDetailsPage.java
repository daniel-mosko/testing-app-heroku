package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactDetailsPage extends BasePage {
    private static final int TIMEOUT = 3;

    public ContactDetailsPage(WebDriver driver) {
        super(driver);
    }

    private WebElement getElement(By locator) {
        waitForElementToBeVisible(locator, TIMEOUT);
        return driver.findElement(locator);
    }

    public WebElement editButton() {
        return getElement(By.id("edit-contact"));
    }

    public WebElement deleteButton() {
        return getElement(By.id("delete"));
    }

    public WebElement returnButton() {
        return getElement(By.id("return"));
    }
}
