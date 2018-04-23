package com.yangx.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;

    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","D:\\IdeaProject\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://mail.163.com");
    }
    @Test
    public void loginTest(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("x-URS-iframe")));
        driver.switchTo().frame("x-URS-iframe");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("email")));
//        driver.findElement(By.name("email")).sendKeys("18620782105");
//        driver.findElement(By.name("password")).sendKeys("2988yx!");
//        driver.findElement(By.id("dologin")).click();
        LoginTest.login(driver,"18620782105","2988yx!");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("退出")));
        String logout = driver.findElement(By.linkText("退出")).getText();
        Assert.assertEquals(logout,"退出");
    }
    @Test
    public void loginErrorTest(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("x-URS-iframe")));
        driver.switchTo().frame("x-URS-iframe");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("email")));
//        driver.findElement(By.name("email")).sendKeys("18620782105");
//        driver.findElement(By.name("password")).sendKeys("12988yx!");
//        driver.findElement(By.id("dologin")).click();
        LoginTest.login(driver,"18620782105","123");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"nerror\"]/div[2]")));
        String error = driver.findElement(By.xpath("//*[@id=\"nerror\"]/div[2]")).getText();
        Assert.assertEquals(error,"请点击验证码");
    }
    public static void login(WebDriver driver,String email, String pwd){
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(pwd);
        driver.findElement(By.id("dologin")).click();
    }
    @AfterMethod
    public void closed(){
        driver.quit();
    }
}
