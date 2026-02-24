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

No fluff. Just working code.

Feel free to fork, tweak, or steal for your own demo.
