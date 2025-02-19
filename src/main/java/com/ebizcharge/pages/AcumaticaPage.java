package com.ebizcharge.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ebizcharge.utils.BaseTest;

public class AcumaticaPage {
    WebDriver driver;
    WebDriverWait wait;

    public AcumaticaPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Explicit wait
    }

    private By acumatica = By.xpath("//a[@href='/integrations/erp/acumatica' and text()='Acumatica']");
    private By downloadFactSheet = By.xpath("//span[contains(text(), 'Download Fact Sheet')]");
    private By iframeElement = By.xpath("//iframe[contains(@src, 'pi.ebizcharge.com/l/659723/2024-07-23/7mpm2')]");
    private By firstName = By.xpath("//input[@id='659723_128938pi_659723_128938']");
                                                  
    private By email = By.xpath("//input[@id='659723_128941pi_659723_128941']");
    private By phone = By.xpath("//input[@id='659723_132441pi_659723_132441']");
                                              
    private By agreeCheckbox = By.xpath("//input[@id='659723_128944pi_659723_128944_1956829']");
    private By downloadNow = By.xpath("//input[@id='spinner']");
    //private By downloadNow = By.xpath("//button[contains(text(),'Download Now')]");
    
    public void clickAcumatica() {
        WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(acumatica));
        menu.click();
        System.out.println("Click on Acumatica");
    }
    
    public void switchToIframe() {
        try {
            // Wait for iframe to be present
            WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(iframeElement));

            // Switch to iframe
            driver.switchTo().frame(iframe);
            System.out.println("Switched to the iframe successfully.");
            
        } catch (Exception e) {
            System.out.println("Failed to switch to iframe: " + e.getMessage());
        }
    }
    public void downloadAcumaticaSolution() throws InterruptedException {
        //driver.findElement(quickBooks).click();
    	 WebElement downloadFactSheetForm = wait.until(ExpectedConditions.elementToBeClickable(downloadFactSheet));
    	 downloadFactSheetForm.click();
         //IframeHandler iframeHandler = new IframeHandler(driver);
    	 WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(iframeElement));

         // Switch to iframe
         driver.switchTo().frame(iframe);
         System.out.println("Switched to the iframe successfully.");

      // Switch to the iframe
      
         WebElement inputElement = wait.until(ExpectedConditions.visibilityOfElementLocated(firstName));
         inputElement.click();
         inputElement.sendKeys("Joe");
        //driver.findElement(firstName).sendKeys("Joe");
        driver.findElement(email).sendKeys("joe.d@centurybizsolutions.com");
        driver.findElement(phone).sendKeys("8885007798");
        driver.findElement(agreeCheckbox).click();
        driver.findElement(downloadNow).click();
        BaseTest.waitForUrlToLoad(driver, "https://ebizcharge.com/resources/acumatica-overview-download/");

        System.out.println("QuickBooks Download Page Loaded Successfully!");
    }

    
    }

