package org.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.*;

public class icmark {

    BefAfter befAfter = new BefAfter();
    WebDriver driver = befAfter.Setup();

    /*@Before
    public void set(){
        driver = befAfter.Setup();
    }*/

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
    public void Smarttech(){
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

    @Test
    public void Invisible () {
        befAfter.Autorizat(driver);// чисто потому что лень искать сайт с фри загрузкой а для яндекса лень заново переписывать авторизацию, закинул в метод би афтера
        driver.get("https://disk.yandex.ru/client/recent");
        JavascriptExecutor jsscr = (JavascriptExecutor)driver;
        jsscr.executeScript("document.querySelector('#app > div > div.sidebar.sidebar_fixed > div.sidebar__buttons > span.control.button2.button2_view_default.button2_tone_default.button2_size_n.button2_theme_raised.button2_width_max.button2_action_yes.upload-button > span.button2__text > div > input').setAttribute('style', 'opacity: 1; position: unset')");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div[1]/span[1]/span[2]/div/input")).sendKeys("C:\\Users\\User\\Desktop\\rash\\icon.png");
        WebDriverWait ww = new WebDriverWait(driver, 60, 60);
        ww.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"nb-1\"]/body/div[2]/div/div/div/div/div[2]/div[1]/div/div/div/div/div[4]/div[42]/div[3]")));
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"nb-1\"]/body/div[2]/div/div/div/div/div[2]/div[1]/div/div/div/div/div[4]/div[42]/div[3]"))).build().perform();
    //Нужно будет тут дописать клик по элементу в попапе, хз почему но чет не видит, мб нужно свитчится тип драйвер все еще в другом активити находится
    }


    @Test
    public void Teamcheck(){ // тим чек из говна собаки
        driver.manage().window().maximize();
        driver.get("https://teamcheck.online/");
        WebDriverWait wait = new WebDriverWait(driver, 60, 60);

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"rec253294617\"]/div/div/div[7]/div/u/a"))).build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"rec253294617\"]/div/div/div[7]/div/u/a")));
        driver.findElement(By.xpath("//*[@id=\"rec253294617\"]/div/div/div[7]/div/u/a")).click();
        //driver.findElement(By.xpath("//*[@id=\"rec218442167\"]/div/div/div[1]/div")).click();
    }
   /* @After
    public void endTest() {
        driver.quit();
    }*/

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
