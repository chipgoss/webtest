
# WebTest — Java Selenium Automation Framework

This project demonstrates a complete, working example of a functional UI test written in **Java**, **Selenium WebDriver**, and **TestNG**, packaged as a **Maven** project.  
The automated test simulates a real-world scenario: **adding a new employee** to a company’s internal employee page.

The goal of this project is to showcase:
- Clean automation structure  
- Page Object Model design  
- TestNG execution via XML suites  
- Maven test lifecycle  
- Modular element definitions  
- Realistic functional test automation workflow  

---

Scenario Automated  
**Scenario 1: Add a New Employee**

The test performs the following steps:

1. Opens the employee management web page  
2. Navigates to the form for adding a new employee  
3. Enters all required employee information  
4. Submits the form  
5. Validates that the new employee was successfully added  

This scenario was originally a manual QA test case, which I fully automated end-to-end.

---

Project Structure
webtest
│
├── src
│   ├── main
│   │   └── java/paylocity/challenge/employee/App.java    # Page Object
│   │
│   └── test
│       └── java/paylocity/challenge/functional/AppTest.java   # Test Class
│
├── resources
│   └── TestNGXmls/AppTest.xml   # TestNG Suite File
│
├── environment.properties        # Configurable environment values
├── pom.xml                       # Maven Project File
└── README.md

---

Technologies Used

- **Java (JDK 1.8+)**
- **Selenium WebDriver**
  - Using `chromedriver.exe v2.45`
- **TestNG**
- **Maven**
- **Eclipse IDE**
- **Page Object Model (POM)**
- **Enumerations for element definitions**

---

How to Run the Test

**Import the Project**
Import as an **Existing Maven Project** inside Eclipse (or IntelliJ).

**Run the TestNG Suite**
Execute the suite file:


/webtest/resources/TestNGXmls/AppTest.xml

**View Reports**
After execution, TestNG generates HTML reports at:


webtest/test-output/

Open `index.html` to view results.

---

About the Web Page

- The tested employee page is hosted locally on the machine this project was developed on.
- The URL defined in the Page Object is a **dummy placeholder** (since the page is not publicly hosted).
- All elements on the page are defined using a clean, modular **Enum-based structure**, improving maintainability and readability.

---

Framework Highlights

- **Modular Page Object Model**
- **Reusable element definitions via Enums**
- **TestNG XML suite orchestration**
- **Configurable test data and environment parameters**
- **Simple, maintainable structure ideal for functional test automation**

---

Notes

- The framework can be easily extended for multiple test scenarios.
- Chromedriver version can be upgraded—this project uses the version active at the time of creation.
- This project demonstrates understanding of test automation fundamentals, patterns, and tooling rather than modern Selenium 4 features.

---

Contact

If you have questions or would like to discuss automation approaches, feel free to reach out!
