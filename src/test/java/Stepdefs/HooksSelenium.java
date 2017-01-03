package Stepdefs;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.chrome.ChromeDriver;

public class HooksSelenium {

    private static boolean initialized = false;

    public static WebDriver driver;

    private static final Thread CLOSE_THREAD = new Thread() {
        @Override
        public void run() {
            driver.close();
            driver.quit();
        }
    };

    static {
        Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);
    }


    public void close() {
        if (Thread.currentThread() != CLOSE_THREAD) {
            throw new UnsupportedOperationException("You shouldn't close this WebDriver. It's shared and will close when the JVM exits.");
        }
        driver.close();
        driver.quit();
    }


    @Before
    /**
     * Delete all cookies at the start of each scenario to avoid
     * shared state between tests
     */
    public void openBrowser() throws MalformedURLException {

        if (!initialized) {
            System.out.println("Called openBrowser");
            System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");
            //System.setProperty("webdriver.firefox.marionette","D:\\WORKSPACE7\\cucumberJava\\browsers\\geckodriver.exe");
            System.setProperty("webdriver.gecko.driver", "C://Users//elquiff//IdeaProjects//cucumber//browsers//geckodriver.exe");
            driver = new FirefoxDriver();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            //driver.manage().window().maximize();
            initialized = true;

        }
    }

    @After
    /**
     * Embed a screenshot in test report if test is marked as failed
     */
    public void embedScreenshot(Scenario scenario) {

        if (scenario.isFailed()) {
            try {
                scenario.write("Current Page URL is " + driver.getCurrentUrl());
                //byte[] screenshot = getScreenshotAs(OutputType.BYTES);
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
            }

        }

    }
}

