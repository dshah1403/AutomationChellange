package com.ebizcharge.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

   public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Explicit wait
    }

    private By integrationsMenu = By.xpath("//a[contains(@href, '/integrations')]/span[contains(text(), 'Integrations')]");
    
    public void clickIntegrations() {
        WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(integrationsMenu));
        menu.click();
        System.out.println("Click on Integration menu");
    }
    
    public void mouseHoverIntegrations() {
        WebElement menu = wait.until(ExpectedConditions.presenceOfElementLocated(integrationsMenu));
        Actions actions = new Actions(driver);
        actions.moveToElement(menu).perform();
        System.out.println("Mouse hovered over the Integrations menu.");
    }
}
