package org.epam.saucedemo;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

public class LoginTest extends BaseTest {

    static Stream<Arguments> credentialsProvider() {
        return Stream.of(
            Arguments.of("anyuser", "anyPassword", true, true, "Username is required"),
            Arguments.of("anyuser", "anyPassword", false, true, "Password is required"),
            Arguments.of("standard_user", "secret_sauce", false, false, "https://www.saucedemo.com/inventory.html")
        );
    }

    @ParameterizedTest
    @MethodSource("credentialsProvider")
    void testLogin(String username, String password, boolean clearUsername, boolean clearPassword, String expected) {
        logger.info("Test with username='{}', password='{}', clearUsername={}, clearPassword={}, expected='{}', thread={}",
                username, password, clearUsername, clearPassword, expected, Thread.currentThread().getId());
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        if (clearUsername) loginPage.clearUsernameByKeys();
        if (clearPassword) loginPage.clearPasswordByKeys();
        loginPage.clickLogin();

        if (expected.startsWith("http")) {
            String currentUrl = driver.getCurrentUrl();
            logger.info("Current URL after login: {}", currentUrl);
            MatcherAssert.assertThat(currentUrl, equalTo(expected));
        } else {
            String error = loginPage.getErrorMessage();
            logger.info("Error message: {}", error);
            MatcherAssert.assertThat(error, containsString(expected));
        }
    }
} 