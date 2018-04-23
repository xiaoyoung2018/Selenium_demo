package com.yangx.day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.sql.Driver;

public class CloseBrowser {
    @Test
    public void closeBrowser1() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\IdeaProject\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Thread.sleep(5000);
        driver.close();
    }
    @Test
    public void closeBrowser2() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\IdeaProject\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Thread.sleep(5000);
        driver.quit();
    }
}
