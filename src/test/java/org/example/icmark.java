package org.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class icmark {

    @Before
    public void set(){

    }

    @Test
    public void YandexNotValidAutor(){
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        //создание экземпляра драйвера
        WebDriver driver = new ChromeDriver();
        driver.get("https://passport.yandex.ru/auth");
        driver.findElement(By.id("passp-field-login")).sendKeys("aaaa");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div/div/div[1]/form/div[3]/button")).click();
        WebDriverWait wait = new WebDriverWait(driver, 60, 60);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("passp-field-passwd")));
        driver.findElement(By.id("passp-field-passwd")).sendKeys("qqw");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div/div/form/div[3]/button")).click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".Textinput-Hint_state_error")));
        String st = driver.findElement(By.cssSelector(".Textinput-Hint_state_error")).getCssValue("color");
        Assert.assertTrue(st.equals("rgba(255, 0, 0, 1)"));
        System.out.println(st);
        driver.quit();
    }

    @Test
    public void YandexValidAutor(){
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        //создание экземпляра драйвера
        WebDriver driver = new ChromeDriver();
        driver.get("https://passport.yandex.ru/auth");
        driver.findElement(By.id("passp-field-login")).sendKeys("TaleRainbow@yandex.ru");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div/div/div[1]/form/div[3]/button")).click();
        WebDriverWait wait = new WebDriverWait(driver, 60, 60);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("passp-field-passwd")));
        driver.findElement(By.id("passp-field-passwd")).sendKeys("379706871Tale");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div/div/form/div[3]/button")).click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div[1]/div[2]/div")));
        Assert.assertTrue(driver.getCurrentUrl().equals("https://passport.yandex.ru/profile"));
        System.out.println(driver.getCurrentUrl());
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
