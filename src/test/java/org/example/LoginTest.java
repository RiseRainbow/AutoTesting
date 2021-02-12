package org.example;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class LoginTest {
    public static LoginPage loginPage;
    public static WebDriver driver;

    /**
     * осуществление первоначальной настройки
     */
    @BeforeClass
    public static void setup() {

        //определение пути до драйвера и его настройка
        //System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        //создание экземпляра драйвера
        WebDriver driver = new ChromeDriver();
        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        //получение ссылки на страницу входа из файла настроек
        driver.get(ConfProperties.getProperty("loginpage"));

        //loginPage.inputLogTest();
    }

    @Test
    public void LoginTest (){

        //System.out.println(ConfProperties.getProperty("login"));
        //driver.findElement(By.id("passp-field-login")).sendKeys("asdasdasd");
        //WebDriverWait wait = new WebDriverWait(driver, 100);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passp-field-login")));
      //  driver.findElement(By.id("passp-field-login")).sendKeys("asdasdasd");
       // System.out.println("asdasdaaaa");
        //driver.findElement(By.id("passp-field-login")).sendKeys("asdasdasd");
       loginPage.inputLogin(ConfProperties.getProperty("login"));
       loginPage.LogButClick();
       loginPage.inputPassword(ConfProperties.getProperty("password"));//фывфыв
    }

    @Test
    public void test (){
        System.out.println("3");
    }
}



