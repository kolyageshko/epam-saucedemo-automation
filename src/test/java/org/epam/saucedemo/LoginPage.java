package org.epam.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private final WebDriver driver;

    private final By usernameInput = By.xpath("//input[@data-test='username']");
    private final By passwordInput = By.xpath("//input[@data-test='password']");
    private final By loginButton = By.xpath("//input[@data-test='login-button']");
    private final By errorMessage = By.xpath("//h3[@data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://www.saucedemo.com/");
    }

    public void setUsername(String username) {
        driver.findElement(usernameInput).clear();
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void setPassword(String password) {
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clearUsername() {
        driver.findElement(usernameInput).clear();
    }

    public void clearPassword() {
        driver.findElement(passwordInput).clear();
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public String getErrorMessage() {
        WebElement error = driver.findElement(errorMessage);
        return error.isDisplayed() ? error.getText() : "";
    }

    public void clearUsernameByKeys() {
        WebElement username = driver.findElement(usernameInput);
        username.sendKeys(Keys.CONTROL + "a");
        username.sendKeys(Keys.DELETE);
    }

    public void clearPasswordByKeys() {
        WebElement password = driver.findElement(passwordInput);
        password.sendKeys(Keys.CONTROL + "a");
        password.sendKeys(Keys.DELETE);
    }
} 