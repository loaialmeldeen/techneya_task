# Tehneya Test Automation Framework

A comprehensive Selenium-based test automation framework built with Java, TestNG, and Allure reporting for automated testing of web applications.

## Project Overview

This test automation framework provides a robust foundation for UI testing with built-in features for reporting, logging, screenshots, and video recording capabilities.

## Tech Stack

- **Language**: Java 25
- **Build Tool**: Maven
- **Testing Framework**: TestNG 7.12.0
- **Browser Automation**: Selenium WebDriver 4.43.0
- **Reporting**: Allure 2.34.0
- **Logging**: Log4j2 2.25.4
- **Driver Management**: WebDriverManager 6.3.4
- **Test Data**: JSON (JsonPath, json-simple)
- **Video Recording**: Video Recorder TestNG 2.0

## Project Structure

```
Tehneya_task/
├── src/
│   ├── main/
│   │   ├── java/com/Technya_task/tests/
│   │   │   ├── assertions/          # Custom assertion implementations
│   │   │   ├── drivers/             # WebDriver factory and management
│   │   │   ├── listeners/           # TestNG listeners
│   │   │   ├── media/               # Screenshot and video recording
│   │   │   ├── pages/               # Page object classes
│   │   │   └── utils/               # Utility classes (actions, waits, data readers)
│   │   └── resources/               # Configuration files (.properties)
│   └── test/
│       ├── java/com/Technya_task/tests/ui/  # Test classes
│       └── resources/test-data/     # Test data JSON files
├── pom.xml
└── README.md
```

## Key Features

### 1. Driver Management
- Multiple browser support (Chrome, etc.)
- Automatic driver version management with WebDriverManager
- Factory pattern implementation for browser initialization

### 2. Reporting & Logging
- Allure report integration with detailed test execution reports
- Environment properties attached to reports
- Log4j2 for comprehensive logging
- Screenshots on test failure
- Video recording of test execution

### 3. Test Data Management
- JSON-based test data storage
- Property files for configuration
- Easy data-driven testing support

### 4. Utilities
- **Element Actions**: Custom wrapper for WebDriver element interactions
- **Browser Actions**: Browser-level operations (navigation, window handling)
- **Wait Manager**: Configurable explicit and implicit waits
- **Time Manager**: Time-related utilities
- **Assertions**: Hard assertions for test validations

### 5. Test Organization
- Page Object Model (POM) design pattern
- BaseTest class for test setup and teardown
- TestNG listeners for test lifecycle management

## Prerequisites

- Java Development Kit (JDK) 25 or higher
- Maven 3.6+
- Allure CLI (for report generation)

## Installation

1. Clone the repository
2. Navigate to the project directory
3. Install dependencies:
```bash
mvn clean install
```

## Configuration

### Environment Configuration
Edit `src/main/resources/environment.properties`:
```properties
baseURL=https://www.amazon.eg/
```

### Wait Configuration
Configure waits in `src/main/resources/waits.properties`

### Video Recording
Configure video settings in `src/main/resources/video.properties`

### Allure Configuration
Configure Allure in `src/main/resources/allure.properties`

## Running Tests

### Run all tests
```bash
mvn clean test
```

### Run specific test suite
```bash
mvn test -DsuiteXmlFile=test-runner/SignupSuite.xml
```

### Run with Allure report generation
```bash
mvn clean test
allure serve test-output/allure-results
```

## Test Data

Test data is stored in JSON format under `src/test/resources/test-data/`. Example structure:
- `scenario1-data.json` - Test data for scenario 1

## Reports

### Allure Reports
After test execution:
1. Generate report: `allure generate test-output/allure-results --clean`
2. Open report: `allure open allure-report`
3. Or serve directly: `allure serve test-output/allure-results`

### Build Output
Maven build output is configured to: `test-output/target`

## Writing Tests

### Example Test Class
```java
@UITest
public class ExampleTest extends BaseTest {

    @BeforeClass
    protected void preCondition() {
        testData = new JsonReader("test-data-file-name");
    }

    @BeforeMethod
    public void setUp() {
        driver = new GUIDriver();
    }

    @Test
    @Description("Test description")
    public void testExample() {
        // Test implementation using Page Objects
    }
}
```

## Dependencies

### Core Dependencies
- Selenium Java 4.43.0
- TestNG 7.12.0
- JUnit 5 (Jupiter) 6.1.0-M1

### Utilities
- Apache Commons IO 2.21.0
- Apache POI 5.5.0 (Excel handling)
- JSoup 1.22.1 (HTML parsing)
- REST Assured 6.0.0 (API testing)

### Reporting & Monitoring
- Allure TestNG 2.34.0
- AspectJ Weaver 1.9.25.1
- Allure Environment Writer 1.0.0

## Best Practices

1. Follow Page Object Model pattern
2. Use descriptive test names and descriptions
3. Store test data in JSON files
4. Leverage built-in utilities for actions and waits
5. Add appropriate assertions for validations
6. Use Allure annotations for better reporting

## Troubleshooting

### Common Issues
- **Driver not found**: WebDriverManager handles this automatically
- **Test failures**: Check logs in `test-output/logs` and screenshots
- **Report generation**: Ensure Allure CLI is installed and accessible

## Contributing

1. Create feature branch
2. Make changes following existing patterns
3. Add/update tests as needed
4. Ensure all tests pass
5. Submit pull request

## License

This project is part of Tehneya task implementation.
