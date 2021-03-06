package org.example;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class BefAfter {


    public void BeAfter (){

    }

    public WebDriver Setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    public String generateString(){
        String res = "";
        for (int i = 0; i<10; i++) {
            int check = (int) (Math.random() * 100);
            if ((check >= 65 && check <= 90) || (check >= 97 && check <= 122)) {
                char c = (char) check;
                res += String.valueOf(c);
            }
        }
        return res;
    }
    public void TakeScreen(WebDriver Driver) throws IOException {
        File scrFile = ((TakesScreenshot)Driver).getScreenshotAs(OutputType.FILE); // Делаем скрин
        FileUtils.copyFile(scrFile, new File("E:\\test.png"));
    }

    public void TakeScreen (WebDriver Driver, String name) throws IOException {
        File scrFile = ((TakesScreenshot)Driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("E:\\"+name+".png"));
    }

    public void PauseSleep (int sec){
        try {
            Thread.sleep(sec);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void NextTab(WebDriver driver){
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        };
    }

    public void MoveAndClick(WebDriver driver, String xpath1, String xpath2){ // https://kreisfahrer.gitbooks.io/selenium-webdriver/content/webdriver_api_slozhnie_vzaimodeistviya/webdriver_api_slozhnie_vzaimodeistviya.html
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(By.xpath(xpath1));
        action.moveToElement(we).moveToElement(driver.findElement(By.xpath(xpath2))).click().build().perform(); // билд это сформировать цепочку действий, а перформ ее запуск

    }

    public void Autorizat(WebDriver driver){ // по сути это тест на валидную авторизацию
        driver.get("https://passport.yandex.ru/auth");
        driver.findElement(By.id("passp-field-login")).sendKeys(ConfProperties.getProperty("login"));
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div/div/div[1]/form/div[3]/button")).click();
        WebDriverWait wait = new WebDriverWait(driver, 60, 60);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("passp-field-passwd")));
        driver.findElement(By.id("passp-field-passwd")).sendKeys(ConfProperties.getProperty("password"));
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div/div/form/div[3]/button")).click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div[1]/div[2]/div")));
    }
}
