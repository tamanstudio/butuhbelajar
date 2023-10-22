package saucedemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Logine {

        @Test
        public void Login_Sukses(){
            WebDriver Driver;
            String baseurl = "http://www.saucedemo.com/";
            WebDriverManager.chromedriver().setup();

            //Open Browser
            Driver = new ChromeDriver();
            Driver.get(baseurl);

            String loginPageAssert = Driver.findElement(By.className("login_logo")).getText();
            Assert.assertEquals("Swag Labs",loginPageAssert);

            //Input Email
            Driver.findElement(By.id("user-name")).sendKeys("qwerstandard_user");

            //Input Password
            Driver.findElement(By.id("password")).sendKeys("secret_sauce");

            //Button Login
            Driver.findElement(By.id("login-button")).click();

            Driver.quit();
        }

        @Test
    public void Login_Gagal(){
        WebDriver Driver;
        String baseurl = "http://www.saucedemo.com/";
        WebDriverManager.chromedriver().setup();

        //Open Browser
        Driver = new ChromeDriver();
        Driver.get(baseurl);

        //
        String loginPageAssert = Driver.findElement(By.className("login_logo")).getText();
        Assert.assertEquals("Swag Labs",loginPageAssert);

        //Input Email
        Driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //Input IncorrectPassword
        Driver.findElement(By.id("password")).sendKeys("secret_caebe");

        //Button Login
        Driver.findElement(By.id("login-button")).click();

        // Close Browser
        Driver.quit();
        Assert.assertEquals("secret_sauce","secret_caebe");
    }

}
