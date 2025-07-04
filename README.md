# EPAM Saucedemo Selenium Tests

## Task Description

- Launch URL: https://www.saucedemo.com/
- UC-1: Test Login form with empty credentials
- UC-2: Test Login form with credentials by passing Username
- UC-3: Test Login form with credentials by passing Username & Password

### Features
- Test framework: TestNG
- Assertions: AssertJ
- Browser selection is handled via system property: `-Dbrowser=chrome`, `-Dbrowser=firefox` or `-Dbrowser=edge`.
- Parallel execution is enabled via Maven Surefire и TestNG.

### How to run
1. Install Maven, JDK 11+ and Chrome/Firefox/Edge.
2. Run tests with:
   ```
   mvn clean test
   ```
3. To select browser use system property:
   ```
   mvn clean test -Dbrowser=chrome
   mvn clean test -Dbrowser=firefox
   mvn clean test -Dbrowser=edge
   ```