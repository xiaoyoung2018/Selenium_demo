package com.yangx.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FindElementsTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","D:\\IdeaProject\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void byIDTest(){
        driver.get("http://www.baidu.com");
/*
        WebElement keyField = driver.findElement(By.id("kw"));
        WebElement keyField = driver.findElement(By.name("wd"));
        WebElement keyField = driver.findElement(By.className("s_ipt"));
        WebElement keyField = driver.findElement(By.linkText("新闻"));
        WebElement keyField = driver.findElement(By.partialLinkText("新"));

        List<WebElement> list = driver.findElements(By.tagName("input"));
        System.out.println(list.size());//*[@id="su"]
*/
        WebElement keyField = driver.findElement(By.xpath(".//*[@id='su']"));

    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}
