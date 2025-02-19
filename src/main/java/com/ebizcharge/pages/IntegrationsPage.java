package com.ebizcharge.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IntegrationsPage {
    WebDriver driver;
    WebDriverWait wait;

    public IntegrationsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Explicit wait
    }

    private By accountErp = By.xpath("//a[@href='/integrations/erp' and text()='Accounting/ERP']");
    private By exploreMore = By.xpath("//a[@href='/integrations/' and text()='Explore More']");

    public void clickAccountErp() {
    	WebElement accountErpLink = wait.until(ExpectedConditions.elementToBeClickable(accountErp));
        accountErpLink.click();
        System.out.println("Clicked on Accounting/ERP.");
    	
    }

    public void clickExploreMore() {
        driver.findElement(exploreMore).click();
        System.out.println("Click on ClickExploreMore");
    }
}
