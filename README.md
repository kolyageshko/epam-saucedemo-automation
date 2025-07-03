# EPAM Saucedemo Selenium Tests

## Task Description

- Launch URL: https://www.saucedemo.com/
- UC-1: Test Login form with empty credentials
- UC-2: Test Login form with credentials by passing Username
- UC-3: Test Login form with credentials by passing Username & Password

### Features
- Browser selection is handled via system property: `-Dbrowser=chrome` or `-Dbrowser=edge`.
- Parallel execution is enabled via JUnit 5 platform properties and Maven Surefire.
- Logging includes thread id to verify parallel execution.

### Requirements
- Test Automation tool: Selenium WebDriver
- Project Builder: Maven
- Browsers: Edge, Chrome
- Locators: XPath
- Test Runner: JUnit
- Assertions: Hamcrest
- Logging: Log4j
- Parallel execution, DataProvider, parameterization

### How to run
1. Install Maven, JDK 11+ and Chrome/Edge.
2. Run tests with:
   ```
   mvn clean test
   ```
3. To select browser use system property:
   ```
   mvn clean test -Dbrowser=chrome
   mvn clean test -Dbrowser=edge
   ```