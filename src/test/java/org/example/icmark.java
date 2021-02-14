package org.example;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.*;

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

    @Test
    public void ASmarttech(){
        driver.get("https://yandex.ru/");
        driver.findElement(By.xpath("//*[@id=\"text\"]")).sendKeys("расчет расстояний между городами");
        driver.findElement(By.cssSelector(".search2__wrapper .search2__button .button")).click();
        driver.findElement(By.partialLinkText("avtodispetcher.ru")).click();
        befAfter.NextTab(driver);
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.avtodispetcher.ru/distance/"));
        driver.findElement(By.xpath("//*[@id=\"from_field_parent\"]/input")).sendKeys("Тула");
        driver.findElement(By.xpath("//*[@id=\"to_field_parent\"]/input")).sendKeys("Санкт-Петербург");
        driver.findElement(By.xpath("//*[@id=\"CalculatorForm\"]/div[2]/div[1]/label/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"CalculatorForm\"]/div[2]/div[1]/label/input")).sendKeys("9");
        driver.findElement(By.xpath("//*[@id=\"CalculatorForm\"]/div[2]/div[2]/label/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"CalculatorForm\"]/div[2]/div[2]/label/input")).sendKeys("46");
        befAfter.PauseSleep(6000);
        driver.findElement(By.xpath("//*[@id=\"CalculatorForm\"]/div[3]/input")).click();
        Assert.assertTrue(driver.findElement(By.id("totalDistance")).getText().equals("897"));
        driver.quit();

    }

    @Test
    public void DemoMagaz (){ // тупо наводимся на дропдаун меню и выбираем там нужный элемент
        driver.get("http://demowebshop.tricentis.com/");
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[2]/a"));
        action.moveToElement(we).moveToElement(driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[2]/ul/li[3]/a"))).click().build().perform();
        driver.quit();
    }

    @Test
    public void MoveSwapMospar (){ // Свайп по слайдеру
        driver.manage().window().maximize();
        driver.get("https://mospar.ru/");
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"site-main\"]/section[2]/div/div/div[1]/div[1]/div/div[6]"));
        action.dragAndDropBy(element,10,0).build().perform();
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
