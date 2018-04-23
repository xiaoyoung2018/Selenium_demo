package com.yangx.day2;

import com.sun.glass.events.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.mustache.Value;

import javax.xml.ws.RequestWrapper;
import java.awt.*;
import java.util.List;

public class Actions2Test {
    WebDriver driver;


    @BeforeMethod
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "D:\\IdeaProject\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void rightClick(){
        driver.get("https://www.baidu.com");
        WebElement buttonBaidu = driver.findElement(By.id("su"));
        Actions actions = new Actions(driver);
        actions.contextClick(buttonBaidu).perform();
    }
    @Test
    public void doubleClick(){
        driver.get("https://www.baidu.com");
        WebElement buttonBaidu = driver.findElement(By.id("su"));
        Actions actions = new Actions(driver);
        actions.doubleClick(buttonBaidu).perform();
        //actions.moveToElement(buttonBaidu).perform();
    }
    @Test
    public void testDrop(){
        driver.get("file:///D:/yang/html/selenium_html/aa.html");
        WebElement element = driver.findElement(By.xpath("/html/body/div[1]"));
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(element,500,500).perform();
    }
    @Test
    public void dropTest(){
        driver.get("file:///D:/yang/html/selenium_html/aa.html");
        WebElement element1 = driver.findElement(By.xpath("/html/body/div[1]"));
        WebElement element2 = driver.findElement(By.xpath("/html/body/div[2]"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(element1).moveToElement(element2).release(element1).perform();
    }
    @Test
    public void moreSelectTest(){
        driver.get("file:///D:/yang/html/selenium_html/index.html");
        WebElement element = driver.findElement(By.id("selectWithMultipleEqualsMultiple"));
        List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"selectWithMultipleEqualsMultiple\"]/option"));
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.SHIFT).click(list.get(0)).click(list.get(2)).keyUp(Keys.SHIFT).perform();

    }
    @Test
    public void saveHtml() throws AWTException {
        driver.get("file:///D:/yang/html/selenium_html/index.html");
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        int KeyS = (int) new Character('S');
        System.out.println(KeyS);
        robot.keyPress(KeyS);
        //robot.keyPress(KeyEvent.VK_S);
        robot.keyPress(KeyEvent.VK_ENTER);
    }
    @Test
    public void uploadTest() throws InterruptedException {
        driver.get("file:///D:/yang/html/selenium_html/index.html");
        Thread.sleep(3000);
        driver.findElement(By.id("load")).sendKeys("D:\\BaiduNetdiskDownload\\jmeter配置、安装手册.docx");
    }


    @AfterMethod
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}