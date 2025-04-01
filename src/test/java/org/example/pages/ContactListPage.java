package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ContactListPage extends BasePage {
    private static final int TIMEOUT = 3;

    public ContactListPage(WebDriver driver) {
        super(driver);
    }

    public WebElement addButton() {
        return getElement(By.id("add-contact"));
    }

    public List<WebElement> getAllContactsByText(String text) {
        return driver.findElements(By.xpath("//td[text()='" + text + "']"));
    }

    public WebElement getContactByText(String text, int waitTime) {
        return getElement(By.xpath("//td[text()='" + text + "']"), waitTime);
    }

    private WebElement getElement(By locator) {
        waitForElementToBeVisible(locator, TIMEOUT);
        return driver.findElement(locator);
    }

    private WebElement getElement(By locator, int waitTime) {
        waitForElementToBeVisible(locator, waitTime);
        return driver.findElement(locator);
    }
}
