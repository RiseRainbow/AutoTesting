package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;

public class LoginPage {

    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"passp-field-login\"]")
    public WebElement loginField;

    @FindBy(xpath = "//*[@id=\"passp-field-passwd\"]")
    public WebElement PasswordField;

    @FindBy(xpath = "//*[contains(text(), 'Войти')]")
    public WebElement loginBtn;


    public void inputLogTest () {
        driver.findElement(By.id("passp-field-login")).sendKeys("asdasd");
    }

    public void inputLogin(String login){
        loginField.sendKeys(login);
    }

    public void inputPassword(String pass){
        PasswordField.sendKeys(pass);
    }

    public  void LogButClick(){
        loginBtn.click();
    }
}
