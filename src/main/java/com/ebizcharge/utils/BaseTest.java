package com.ebizcharge.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BaseTest {
    private static WebDriver driver;

    public static void setup() {
    	if (driver == null) {
            try {
                // Option 1: Try Stable Version First
                //WebDriverManager.chromedriver().setup();

                //  Option 2: If fails, try Beta Version
                 //WebDriverManager.chromedriver().useBetaVersions().setup();

                // Option 3: If still fails, manually set path to downloaded ChromeDriver
                System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Jasmin Shah\\\\eclipse-workspace\\\\SeleniumAutomation\\\\chromedriver.exe");

                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                options.addArguments("--remote-allow-origins=*");

                driver = new ChromeDriver(options);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                System.out.println("WebDriver setup successful!");

            } catch (Exception e) {
                throw new RuntimeException("WebDriver setup failed!", e);
            }
        }
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            System.err.println("⚠️ WebDriver is NULL! Calling setup again...");
            setup();
        }
        return driver;
    }

    public static void waitForPageLoad(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));
    }

    public static void waitForUrlToLoad(WebDriver driver, String expectedUrl) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        System.out.println("Navigated to expected URL: " + expectedUrl);
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
            System.out.println("Browser session closed successfully!!!");
        }
    }
}
