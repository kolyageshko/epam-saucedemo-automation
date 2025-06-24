package org.epam.saucedemo;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class LoginTest extends BaseTest {

    @ParameterizedTest
    @MethodSource("org.epam.saucedemo.BaseTest#browserProvider")
    void testLoginWithEmptyCredentials(String browser) {
        logger.info("UC-1: Test Login form with empty credentials on {}", browser);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.setUsername("anyuser");
        loginPage.setPassword("anyPassword");
        loginPage.clearUsernameByKeys();
        loginPage.clearPasswordByKeys();
        loginPage.clickLogin();
        String error = loginPage.getErrorMessage();
        logger.info("Error message: {}", error);
        MatcherAssert.assertThat(error, containsString("Username is required"));
    }

    @ParameterizedTest
    @MethodSource("org.epam.saucedemo.BaseTest#browserProvider")
    void testLoginWithEmptyPassword(String browser) {
        logger.info("UC-2: Test Login form with credentials by passing Username on {}", browser);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.setUsername("anyuser");
        loginPage.setPassword("anyPassword");
        loginPage.clearPasswordByKeys();
        loginPage.clickLogin();
        String error = loginPage.getErrorMessage();
        logger.info("Error message: {}", error);
        MatcherAssert.assertThat(error, containsString("Password is required"));
    }

    @ParameterizedTest
    @MethodSource("org.epam.saucedemo.BaseTest#browserProvider")
    void testLoginWithValidCredentials(String browser) {
        logger.info("UC-3: Test Login form with valid credentials on {}", browser);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();
        String currentUrl = driver.getCurrentUrl();
        logger.info("Current URL after login: {}", currentUrl);
        MatcherAssert.assertThat(currentUrl, equalTo("https://www.saucedemo.com/inventory.html"));
    }
} 