package org.epam.saucedemo;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @DataProvider(name = "credentialsProvider", parallel = true)
    public Object[][] credentialsProvider() {
        return new Object[][]{
                {"anyuser", "anyPassword", true, true, "Username is required"},
                {"anyuser", "anyPassword", false, true, "Password is required"},
                {"standard_user", "secret_sauce", false, false, "https://www.saucedemo.com/inventory.html"}
        };
    }

    @Test(dataProvider = "credentialsProvider")
    public void testLogin(String username, String password, boolean clearUsername, boolean clearPassword, String expected) {
        logger.info("Test with username='{}', password='{}', clearUsername={}, clearPassword={}, expected='{}', thread={}",
                username, password, clearUsername, clearPassword, expected, Thread.currentThread().getId());
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        if (clearUsername) loginPage.clearUsernameByKeys();
        if (clearPassword) loginPage.clearPasswordByKeys();
        loginPage.clickLogin();

        if (expected.startsWith("http")) {
            String currentUrl = getDriver().getCurrentUrl();
            logger.info("Current URL after login: {}", currentUrl);
            Assertions.assertThat(currentUrl).isEqualTo(expected);
        } else {
            String error = loginPage.getErrorMessage();
            logger.info("Error message: {}", error);
            Assertions.assertThat(error).contains(expected);
        }
    }
} 