package com.yangx.day1;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserAction {
    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","D:\\IdeaProject\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void getTest() throws InterruptedException {
     System.setProperty("webdriver.firefox.bin","C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        driver = new FirefoxDriver();
        driver.get("http://www.baidu.com");
        Thread.sleep(5000);

    }
    @Test
    public void backTest() throws InterruptedException {
        driver.get("http://www.baidu.com");
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().forward();
        Thread.sleep(3000);

    }
    @Test
    public void refreshTest() throws InterruptedException {
        Dimension dimension = new Dimension(300,300);
        driver.manage().window().setSize(dimension);
        Thread.sleep(3000);
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.get("https://www.jd.com");
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(3000);

    }
    @Test
    public void getURLTest(){
        driver.get("https://www.baidu.com");
        String url = driver.getCurrentUrl();
        System.out.println("当前获取到的URL是：" + url);
        Assert.assertEquals(url,"https://www.baidu.com/");
    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}
