package org.example.tests;

import org.example.pages.HomePage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestLogin extends TestInit {

    private void performAndValidateLogin(HomePage homePage, String email, String password, boolean isSuccessful) {
        homePage.navigateToHomePage();
        homePage.performLogin(email, password);
        if (isSuccessful) {
            assertTrue(homePage.getContactListHeader().isDisplayed());
        } else {
            assertTrue(homePage.locateErrorMessage().isDisplayed());
        }
    }

    @Test
    public void loginValidTest() {
        HomePage homePage = new HomePage(driver);
        performAndValidateLogin(homePage, CORRECT_EMAIL, CORRECT_PASSWORD, true);
    }

    @Test
    public void loginInvalidTest() {
        HomePage homePage = new HomePage(driver);
        performAndValidateLogin(homePage, INCORRECT_EMAIL, INCORRECT_PASSWORD, false);
    }
}
