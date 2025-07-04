package org.epam.saucedemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected Logger logger = LogManager.getLogger(this.getClass());

    protected WebDriver getDriver() {
        return driver.get();
    }

    @BeforeMethod
    public void setUp() {
        driver.set(WebDriverFactory.createDriver());
        getDriver().manage().window().maximize();
        logger.info("WebDriver started");
    }

    @AfterMethod
    public void tearDown() {
        if (getDriver() != null) {
            getDriver().quit();
            logger.info("WebDriver stopped");
            driver.remove();
        }
    }
} 