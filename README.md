# Selenium Demo: Chrome Browser Automation

A clean, minimal Selenium test that launches Chrome, navigates to Google, performs a search, and verifies the title.

### Why this project?
- Proves I can set up Selenium 4+ with WebDriverManager (no manual driver downloads).
- Handles ChromeOptions, waits, and basic assertions.
- Runs locally or in CI—super portable.

### Setup
- Java 17+
- Maven 3.9+
- Chrome browser (auto-managed)

### How to run
1. Clone: `git clone https://github.com/yourusername/webtest.git`
2. Build: `mvn clean install`
3. Run: `mvn test` (or right-click \webtest\resources\TestNGXmls\DuckDuckGo.xml → Run)

### What it does
- Opens Chrome
- Goes to `https://duckduckgo.com/`
- Searches "selenium test"
- Checks title contains "selenium test"

### Tech
- Selenium 4.21.0 (or latest)
- WebDriverManager 6.3.3 (auto-driver)
- JUnit 5
- ChromeDriver (auto)

## Jenkins CI/CD Setup
This project is configured to run on a Windows Jenkins node.

### Global Tool Configuration
Ensure these exact **Names** are used in *Manage Jenkins > Tools*:
- **JDK:** `JDK` (Path: `C:\Program Files\Zulu\zulu-25\`)
- **Maven:** `Maven 3.x` (Install automatically from Apache)

### Jenkins Pipeline Details
- **Credentials ID:** `d12ea42e-e0b5-4e25-bac7-1035b04f53e2` (GitHub PAT)
- **Branch:** `master`
- **Shell Type:** Always use `bat` commands for Windows.
- <img width="1869" height="898" alt="image" src="https://github.com/user-attachments/assets/4c4b6abb-aff7-4262-a255-1009419f7c27" />


### Maven Notes
- **Compiler Release:** Set to `25` in `pom.xml` to match OpenJDK 25.
- **TestNG Scope:** Set to `compile` so Page Objects in `src/main` can use assertions.

No fluff. Just working code.

Feel free to fork, tweak, or steal for your own demo.
