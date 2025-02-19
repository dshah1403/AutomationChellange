package com.ebizcharge.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ebizcharge.utils.BaseTest;

public class QuickBooksPage {
    WebDriver driver;
    WebDriverWait wait;

    public QuickBooksPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Explicit wait
    }

    private By quickBooks = By.xpath("//a[@href='/integrations/erp/quickbooks-desktop' and text()='QuickBooks Desktop']");
    private By downloadFactSheet = By.xpath("//span[@class='fusion-button-text' and text()='Download Fact Sheet']");
    private By iframeElement = By.xpath("//iframe[contains(@src, 'pi.ebizcharge.com/l/659723')]");
    private By firstName = By.xpath("//input[@id='659723_129016pi_659723_129016']");
    private By email = By.xpath("//input[@id='659723_129019pi_659723_129019']");
    private By phone = By.xpath("//input[@id='659723_132459pi_659723_132459']");
    private By agreeCheckbox = By.xpath("//input[@id='659723_129022pi_659723_129022_1956859']");
    private By downloadNow = By.xpath("//input[@id='spinner']");
    
    
    public void clickQuickBooks() {
        WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(quickBooks));
        menu.click();
        System.out.println("Click on QuickBoos");
    }
    public void switchToIframe() {
        try {
            // Wait for iframe to be present
            WebElement iframeElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[contains(@src, 'pi.ebizcharge.com/l/659723')]")));

            // Switch to iframe
            driver.switchTo().frame(iframeElement);
            System.out.println("Switched to the iframe successfully.");
            
        } catch (Exception e) {
            System.out.println("Failed to switch to iframe: " + e.getMessage());
        }
    }

    public void downloadQuickBooksFactSheet() throws InterruptedException {
        //driver.findElement(quickBooks).click();
    	 WebElement downloadFactSheetForm = wait.until(ExpectedConditions.elementToBeClickable(downloadFactSheet));
    	 downloadFactSheetForm.click();
         //IframeHandler iframeHandler = new IframeHandler(driver);
    	 WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(iframeElement));

         // Switch to iframe
         driver.switchTo().frame(iframe);
         System.out.println("Switched to the iframe successfully.");

      // Switch to the iframe
      //iframeHandler.switchToIframe();
         WebElement inputElement = wait.until(ExpectedConditions.visibilityOfElementLocated(firstName));
         inputElement.click();
         inputElement.sendKeys("Joe");
        //driver.findElement(firstName).sendKeys("Joe");
        driver.findElement(email).sendKeys("joe.d@ebizcharge.com");
        driver.findElement(phone).sendKeys("8885007798");
        driver.findElement(agreeCheckbox).click();
        driver.findElement(downloadNow).click();
        BaseTest.waitForUrlToLoad(driver, "https://ebizcharge.com/resources/quickbooks-desktop-overview-download/");

        System.out.println("QuickBooks Download Page Loaded Successfully!");
        
    }
}
