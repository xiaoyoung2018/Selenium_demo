package com.yangx.day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class OpenBrowser {
    @Test
    public void openFF(){
        WebDriver webDriver = new FirefoxDriver();
    }

    @Test
    public void openFF2(){
        System.setProperty("webdriver.firefox.bin","C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        WebDriver webDriver = new FirefoxDriver();
    }

    @Test
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","D:\\IdeaProject\\drivers\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
    }
    @Test
    public void openIE(){
        System.setProperty("webdriver.ie.driver","D:\\IdeaProject\\drivers\\IEDriverServer.exe");
        WebDriver webDriver = new InternetExplorerDriver();
    }

}
