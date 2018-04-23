package com.yangx.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.*;

public class WindowSelect {
    WebDriver driver;
    @BeforeMethod
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "D:\\IdeaProject\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void windowSelect() throws InterruptedException {
        driver.get("file:///D:/yang/html/selenium_html/index.html");
        driver.findElement(By.linkText("Open new window")).click();
        Thread.sleep(3000);
        String handle = driver.getWindowHandle();
        for (String handles:driver.getWindowHandles()){
            if(handles.equals(handle))
                continue;
            driver.switchTo().window(handles);
        }
        Thread.sleep(3000);
        driver.findElement(By.id("user")).sendKeys("test1");
        Thread.sleep(3000);
        driver.switchTo().window(handle);
        driver.findElement(By.id("user")).sendKeys("test2");
    }
    @AfterMethod
    public void closeBrowser() throws InterruptedException {
        sleep(3000);
        driver.quit();
    }
}
