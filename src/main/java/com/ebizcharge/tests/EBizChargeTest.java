package com.ebizcharge.tests;

import com.ebizcharge.pages.*;
import com.ebizcharge.utils.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EBizChargeTest {
    private WebDriver driver;
    private HomePage home;
    private IntegrationsPage integrations;
    private QuickBooksPage quickBooks;
    private AcumaticaPage acumatica;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        BaseTest.setup();
        driver = BaseTest.getDriver(); // Initialize driver after BaseTest.setup()

        driver.get("https://www.ebizcharge.com");
        Thread.sleep(5000);
        System.out.println("Website opened successfully!");

        // Initialize page objects after driver is assigned
        home = new HomePage(driver);
        integrations = new IntegrationsPage(driver);
        quickBooks = new QuickBooksPage(driver);
        acumatica = new AcumaticaPage(driver);
    }

   @Test(description = "Verify that the Quickbook tab download page opens successfully")
    public void testQuickBooksDownload() throws InterruptedException {
    	
    	home.clickIntegrations();
        integrations.clickAccountErp();
        home.mouseHoverIntegrations();
        quickBooks.clickQuickBooks();
        quickBooks.downloadQuickBooksFactSheet();

        // Assertion for correct URL
        String expectedUrl = "https://ebizcharge.com/resources/quickbooks-desktop-overview-download/";
        
        String actualUrl = driver.getCurrentUrl();
        System.out.println("Actual string" + actualUrl + "\n Expected URL" + expectedUrl);
        Assert.assertEquals(actualUrl, expectedUrl, "QuickBooks URL verification Pass!");
    }

 @Test(description = "Verify that the Acumatica download page opens successfully")
    public void testAcumaticaDownload() throws InterruptedException {
        home.clickIntegrations();
        integrations.clickExploreMore();
        home.mouseHoverIntegrations();
        acumatica.clickAcumatica();
        acumatica.downloadAcumaticaSolution();
        

        // Assertion for correct URL
        String expectedUrl = "https://ebizcharge.com/resources/acumatica-overview-download/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Acumatica URL verification failed!");
    } 

    @AfterMethod
    public void tearDown() {
        BaseTest.tearDown(); // Close WebDriver
    }
}