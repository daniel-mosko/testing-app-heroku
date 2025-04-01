package org.example.tests;

import org.example.pages.ContactDetailsPage;
import org.example.pages.ContactFormPage;
import org.example.pages.ContactListPage;
import org.example.pages.HomePage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestContactList extends TestInit {

    /**
     * Logs in to the application and navigates to the contact list page.
     *
     * @param homePage a HomePage object used to access and interact with the home page of the application
     * @param contactListPage a ContactListPage object used to interact with the contact list page
     */
    private void loginAndNavigateToContactList(HomePage homePage, ContactListPage contactListPage) {
        homePage.navigateToHomePage();
        homePage.performLogin(CORRECT_EMAIL, CORRECT_PASSWORD);
    }

    /**
     * Adds a new contact to the contact list by navigating to the add contact form,
     * filling out the contact's first name and last name, and submitting the form.
     *
     * @param contactListPage the page object representing the contact list page
     * @param contactFormPage the page object representing the contact form page
     * @param name the first name of the contact to be added
     * @param lastName the last name of the contact to be added
     */
    private void addContact(ContactListPage contactListPage, ContactFormPage contactFormPage, String name, String lastName) {
        contactListPage.addButton().click();
        contactFormPage.fillAddContactForm(name, lastName);
    }

    /**
     * Tests the functionality of adding a new contact to the contact list.
     *
     * This test performs the following steps:
     * 1. Logs in and navigates to the contact list page.
     * 2. Adds a new contact with a specified first name and last name.
     * 3. Verifies that the newly created contact is displayed in the contact list.
     *
     * The test ensures that the contact creation process works as expected and
     * the application properly displays the newly added contact in the list.
     */
    @Test
    public void addNewContactTest() {
        HomePage homePage = new HomePage(driver);
        ContactListPage contactListPage = new ContactListPage(driver);
        ContactFormPage contactFormPage = new ContactFormPage(driver);

        loginAndNavigateToContactList(homePage, contactListPage);
        addContact(contactListPage, contactFormPage, FIRST_CONTACT_NAME, FIRST_CONTACT_LAST_NAME);

        assertTrue(contactListPage.getContactByText(FIRST_CONTACT_NAME + " " + FIRST_CONTACT_LAST_NAME, 3).isDisplayed());
    }

    /**
     * Tests the functionality of editing a newly created contact in the contact list.
     *
     * This test performs the following steps:
     * 1. Logs in and navigates to the contact list page.
     * 2. Adds a new contact with a specific first and last name.
     * 3. Selects the newly created contact from the contact list.
     * 4. Edits the selected contact's first and last name.
     * 5. Confirms the changes by editing and returning from the contact details view.
     * 6. Verifies that the updated contact with the new first and last name is displayed
     *    in the contact list.
     *
     * The test ensures that the edit functionality updates the contact details correctly
     * and the application behaves as expected.
     */
    @Test
    public void editNewContactTest() {
        HomePage homePage = new HomePage(driver);
        ContactListPage contactListPage = new ContactListPage(driver);
        ContactFormPage contactFormPage = new ContactFormPage(driver);
        ContactDetailsPage contactDetailsPage = new ContactDetailsPage(driver);

        loginAndNavigateToContactList(homePage, contactListPage);
        addContact(contactListPage, contactFormPage, FIRST_CONTACT_NAME, FIRST_CONTACT_LAST_NAME);

        contactListPage.getContactByText(FIRST_CONTACT_NAME + " " + FIRST_CONTACT_LAST_NAME, 3).click();
        contactDetailsPage.editButton().click();
        contactFormPage.editContactForm(NEW_CONTACT_NAME, NEW_CONTACT_LAST_NAME);
        contactDetailsPage.editButton().click();
        contactDetailsPage.returnButton().click();

        assertTrue(contactListPage.getContactByText(NEW_CONTACT_NAME + " " + NEW_CONTACT_LAST_NAME, 3).isDisplayed());
    }

    /**
     * Tests the functionality of deleting a newly created contact from the contact list.
     *
     * This test performs the following steps:
     * 1. Logs in and navigates to the contact list page.
     * 2. Creates a new contact with the specified first and last name.
     * 3. Selects the newly created contact from the contact list.
     * 4. Deletes the contact using the delete functionality.
     * 5. Verifies that the deleted contact is no longer present in the contact list.
     *
     * The test ensures that the delete functionality removes the contact from the list
     * and that the application behaves as expected.
     */
    @Test
    public void deleteNewContactTest() {
        HomePage homePage = new HomePage(driver);
        ContactListPage contactListPage = new ContactListPage(driver);
        ContactFormPage contactFormPage = new ContactFormPage(driver);
        ContactDetailsPage contactDetailsPage = new ContactDetailsPage(driver);

        loginAndNavigateToContactList(homePage, contactListPage);
        addContact(contactListPage, contactFormPage, FIRST_CONTACT_NAME, FIRST_CONTACT_LAST_NAME);

        contactListPage.getContactByText(FIRST_CONTACT_NAME + " " + FIRST_CONTACT_LAST_NAME, 3).click();
        contactDetailsPage.deleteButton().click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

        assertEquals(0, contactListPage.getAllContactsByText(NEW_CONTACT_NAME + " " + NEW_CONTACT_LAST_NAME).size());
    }
}
