package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestOne {
    public WebDriver driver;

    public void setUp(){
        WebDriverManager.chromedriver().setup();
        //driver = new ChromeDriver((new ChromeOptions()).addArguments("--remote-allow-origins=*"));
        driver = new EdgeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void codeChallenge(){
        WebElement user = driver.findElement(By.id("user-name"));
        user.sendKeys("standard_user");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement((By.id("add-to-cart-sauce-labs-backpack"))).click();
        driver.findElement((By.id("add-to-cart-sauce-labs-bike-light"))).click();
        driver.findElement(By.className("shopping_cart_container")).click();
        driver.findElement(By.id("remove-sauce-labs-backpack")).click();
        driver.findElement(By.id("checkout")).click();
    }

    public void cerrrarPagina(){
       // driver.quit();
    }

    @Test
    public  void verificarFuncionamientoPaginaWeb(){
        setUp();
        codeChallenge();
        cerrrarPagina();
    }
}
