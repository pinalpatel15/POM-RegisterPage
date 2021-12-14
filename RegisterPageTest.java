package com.demo.nopcommerce.tests;

import com.demo.nopcommerce.base.BasePage;
import com.demo.nopcommerce.pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Properties;

public class RegisterPageTest {

    //Before after method - Test - After Method

    BasePage basePage;
    Properties prop;
    WebDriver driver;
    RegisterPage  registerPage;
    String webEngine;
    @BeforeMethod
    public void openBrowser()throws InterruptedException {
        Thread.sleep(5000);
         basePage = new BasePage();

        prop = basePage.initialiseProperties();

         webEngine = prop.getProperty("browser");
       driver =  basePage.initialiseDriver(webEngine);
        driver.get(prop.getProperty("url"));
        registerPage= new RegisterPage(driver);
    }
    @Test(priority = 1)
    public void verifyRegisterPageTitleTest() throws InterruptedException {
        Thread.sleep(5000);
 registerPage.getPageTitle();
Assert.assertEquals(registerPage.getPageTitle(),"nopCommerce demo store. Register","RegisterPage title do not match");
    }
    @Test(priority = 2)
    public void registerTest() throws InterruptedException {
        Thread.sleep(5000);
        registerPage.doRegister(prop.getProperty("firstname"), prop.getProperty("lastname"),
                prop.getProperty("Day"), prop.getProperty("Month"), prop.getProperty("Year"),
        prop.getProperty("email"), prop.getProperty("companyName"), prop.getProperty("password"),
                prop.getProperty("confirmPassword") );
        Thread.sleep(5000);


    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    }


