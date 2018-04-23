package com.yangx.day2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTest {
    WebDriver driver;
    @BeforeMethod
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "D:\\IdeaProject\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void alertTest() throws InterruptedException {
        driver.get("file:///D:/yang/html/selenium_html/index.html");
        driver.findElement(By.className("alert")).click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        alert.accept();
        Assert.assertEquals(text,"请点击确定");
    }
    @Test
    public void confirmTest() throws InterruptedException {
        driver.get("file:///D:/yang/html/selenium_html/index.html");
        driver.findElement(By.className("confirm")).click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        Thread.sleep(3000);
        alert.accept();
        Thread.sleep(3000);
    }
    @Test
    public void promptTest() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("file:///D:/yang/html/selenium_html/index.html");
        driver.findElement(By.className("prompt")).click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("这是prompt");
        Thread.sleep(3000);
        alert.accept();
        alert.accept();
        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void iframeTest() throws InterruptedException {
        driver.get("file:///D:/yang/html/selenium_html/index.html");
//      driver.switchTo().frame("aa");
        WebElement element = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(element);
        driver.findElement(By.linkText("baidu")).click();
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
        driver.findElement(By.linkText("登陆界面")).click();
        Thread.sleep(2000);
    }
    @Test
    public void loginTest() throws InterruptedException {
        driver.get("file:///D:/yang/html/selenium_html/index.html");
        driver.findElement(By.linkText("登陆界面")).click();
        Thread.sleep(2000);
    }
    @AfterMethod
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
