package org.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.*;
import org.openqa.selenium.*;

import java.io.File;

public class icmark {

    BefAfter befAfter = new BefAfter();
    WebDriver driver = befAfter.Setup();

    @Test
    public void YandexNotValidAutor() throws IOException {
        driver.get("https://passport.yandex.ru/auth");
        driver.findElement(By.id("passp-field-login")).sendKeys(befAfter.generateString());
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div/div/div[1]/form/div[3]/button")).click();
        WebDriverWait wait = new WebDriverWait(driver, 60, 60);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("passp-field-passwd")));
        driver.findElement(By.id("passp-field-passwd")).sendKeys(befAfter.generateString());
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div/div/form/div[3]/button")).click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".Textinput-Hint_state_error")));
        String st = driver.findElement(By.cssSelector(".Textinput-Hint_state_error")).getCssValue("color");
        Assert.assertTrue(st.equals("rgba(255, 0, 0, 1)"));
        befAfter.TakeScreen(driver, "qwe");
        driver.quit();

    }

    @Test
    public void YandexValidAutor(){
        driver.get("https://passport.yandex.ru/auth");
        driver.findElement(By.id("passp-field-login")).sendKeys(ConfProperties.getProperty("login"));
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div/div/div[1]/form/div[3]/button")).click();
        WebDriverWait wait = new WebDriverWait(driver, 60, 60);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("passp-field-passwd")));
        driver.findElement(By.id("passp-field-passwd")).sendKeys(ConfProperties.getProperty("password"));
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div/div/form/div[3]/button")).click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div[1]/div[2]/div")));
        Assert.assertTrue(driver.getCurrentUrl().equals("https://passport.yandex.ru/profile"));
        driver.quit();
    }

    /*@Test
    public void icmark(){
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        //создание экземпляра драйвера
        WebDriver driver = new ChromeDriver();
        driver.get("https://icmark.ru/");
        String title = driver.getTitle();
        Assert.assertTrue(title.equals("ICMARK (АЙСИМАРК) интернет-агентство, разработка и продвижение веб-сайтов в Туле."));
    }
*/
}
