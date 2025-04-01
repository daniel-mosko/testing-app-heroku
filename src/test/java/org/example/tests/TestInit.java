package org.example.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class TestInit {
    // Contact
    protected static final String FIRST_CONTACT_NAME = "Janko";
    protected static final String FIRST_CONTACT_LAST_NAME = "Mrkvicka";
    protected static final String NEW_CONTACT_NAME = "Jan";
    protected static final String NEW_CONTACT_LAST_NAME = "Mrkva";
    // Login
    protected static final String CORRECT_EMAIL = "tpanak876@lala.com";
    protected static final String CORRECT_PASSWORD = "tpanak123";
    protected static final String INCORRECT_EMAIL = "test@example.com";
    protected static final String INCORRECT_PASSWORD = "test";
    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
