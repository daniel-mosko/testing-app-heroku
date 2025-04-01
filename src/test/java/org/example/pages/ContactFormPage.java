package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactFormPage extends BasePage {
    private static final int TIMEOUT = 3;

    public ContactFormPage(WebDriver driver) {
        super(driver);
    }

    private WebElement getElement(By locator) {
        waitForElementToBeVisible(locator, TIMEOUT);
        return driver.findElement(locator);
    }

    public WebElement firstNameInput() {
        return getElement(By.id("firstName"));
    }

    public WebElement lastNameInput() {
        return getElement(By.id("lastName"));
    }

    public WebElement submitButton() {
        return getElement(By.id("submit"));
    }

    public void fillAddContactForm(String name, String lastName) {
        fillContactForm(name, lastName);
        submitButton().click();
    }

    public void editContactForm(String name, String lastName) {
        fillContactForm(name, lastName);
        submitButton().click();
    }

    private void fillContactForm(String name, String lastName) {
        handleInputField(firstNameInput(), name);
        handleInputField(lastNameInput(), lastName);
    }

    private void handleInputField(WebElement inputField, String value) {
        inputField.click();
        inputField.clear();
        inputField.click();
        inputField.clear();
        inputField.sendKeys(value);
    }
}
