# EPAM Saucedemo Selenium Tests

## Task Description

- Launch URL: https://www.saucedemo.com/
- UC-1: Test Login form with empty credentials
- UC-2: Test Login form with credentials by passing Username
- UC-3: Test Login form with credentials by passing Username & Password

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

### Test structure
- All tests are located in `src/test/java/org/epam/saucedemo/`
- Main class (if needed) in `src/main/java/org/epam/saucedemo/`
- Logging is configured via Log4j
- Parallel execution via Surefire Plugin 