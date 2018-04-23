package com.yangx.day2;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ActionsTest {
    WebDriver driver;
    @BeforeMethod
    public void openBrowser(){
         System.setProperty("webdriver.chrome.driver", "D:\\IdeaProject\\drivers\\chromedriver.exe");
         driver = new ChromeDriver();
    }
    @Test
    public void clickTest() throws InterruptedException {
        driver.get("https://www.baidu.com");
        WebElement newslink = driver.findElement(By.name("tj_trnews"));
        newslink.click();
        Thread.sleep(3000);
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url,"http://news.baidu.com/");
    }
    @Test
    public void sendkeysTest() throws InterruptedException {
        driver.get("https://www.baidu.com");
        WebElement keys = driver.findElement(By.id("kw"));
        keys.sendKeys("selenium");
        WebElement button = driver.findElement(By.id("su"));
        button.click();
        Thread.sleep(3000);
        String title = driver.getTitle();
        Assert.assertEquals(title,"selenium_百度搜索");
    }
    @Test
    public void clearTest() throws InterruptedException {
        driver.get("https://www.baidu.com");
        WebElement keys = driver.findElement(By.id("kw"));
        keys.sendKeys("selenium");
        Thread.sleep(3000);
        keys.clear();
        Thread.sleep(3000);
    }
    @Test
    public void getTagname(){
        driver.get("https://www.baidu.com");
        String text = driver.findElement(By.id("kw")).getTagName();
        Assert.assertEquals(text,"input");
    }
    @Test
    public void getText(){
        driver.get("https://www.baidu.com");
        String attribute = driver.findElement(By.id("su")).getAttribute("value");
        Assert.assertEquals(attribute,"百度一下");
    }
    @Test
    public void isDisplayedTest(){
        driver.get("https://www.baidu.com");
        boolean b = driver.findElement(By.id("su")).isDisplayed();
        Assert.assertTrue(b);
    }
    @Test
    public void shotTest(){
        driver.get("https://www.baidu.com");
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(file,new File("D://test1.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}
