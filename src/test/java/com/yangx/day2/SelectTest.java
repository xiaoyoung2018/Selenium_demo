package com.yangx.day2;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectTest {
    WebDriver driver;
    @BeforeMethod
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "D:\\IdeaProject\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void SelectTest() throws InterruptedException {
        driver.get("file:///D:/yang/html/selenium_html/index.html");
        WebElement element = driver.findElement(By.id("moreSelect"));
        Select select = new Select(element);
        select.selectByIndex(2);
        Thread.sleep(3000);
        select.selectByValue("huawei");
        Thread.sleep(3000);
        select.selectByVisibleText("iphone");
        Thread.sleep(3000);
    }

    @AfterMethod
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
