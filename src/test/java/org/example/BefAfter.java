package org.example;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
}
