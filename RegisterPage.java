package com.demo.nopcommerce.pages;

import com.demo.nopcommerce.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Properties;

public class RegisterPage {

    WebDriver driver;

    //1.Create your page object/object repository in the form of By locators.

    By Register = By.className("ico-register");
    By Gender = By.xpath("//label[@for='gender']");
    By genderFemale = By.id("gender-female");
    By Firstname = By.id("FirstName");
    By Lastname = By.id("LastName");
    By day = By.cssSelector("select[name='DateOfBirthDay']");
    By month = By.cssSelector("select[name='DateOfBirthMonth']");
    By year = By.cssSelector("select[name='DateOfBirthYear']");
    By Email = By.id("Email");
    By CompanyName = By.id("Company");
    By Newsletter = By.id("Newsletter");
    By Password = By.id("Password");
    By ConfirmPassword = By.id("ConfirmPassword");
    By RegisterButton = By.xpath("//button[@name='register-button']");

    // 2. Create constructor of page class public than class name
    // Constructor for initialise driver

    public RegisterPage(WebDriver driver) {

        this.driver = driver;
    }

    // 3. Page actions/page methods

    public String getPageTitle() {
        String rpTitle = driver.getTitle();
        System.out.println("Register Page title is" + rpTitle);
        return rpTitle;
    }

    public void verifyRegister() {
        driver.findElement(Register).isDisplayed();
    }

    public void doRegister(String firstname, String lastname, String Day,String Month,String Year,
                           String email,String companyName,
                           String password, String confirmPassword) throws InterruptedException {
        driver.findElement(Register).click();
        driver.findElement(Gender).click();
        driver.findElement(genderFemale).click();
        driver.findElement(Firstname).sendKeys(firstname);
        driver.findElement(Lastname).sendKeys(lastname);
        Thread.sleep(1000);
        driver.findElement(day).sendKeys(Day);
        Thread.sleep(1000);
        driver.findElement(month).sendKeys(Month);
        Thread.sleep(1000);
        driver.findElement(year).sendKeys(Year);
        Thread.sleep(1000);
        driver.findElement(Email).sendKeys(email);
        Thread.sleep(1000);
        driver.findElement(CompanyName).sendKeys(companyName);
        driver.findElement(Newsletter).click();
        Thread.sleep(4000);
        driver.findElement(Password).sendKeys(password);
        driver.findElement(ConfirmPassword).sendKeys(confirmPassword);
        Thread.sleep(5000);
        driver.findElement(RegisterButton).click();
        //  System.out.println("Credentials are:" + firstname + " - "
        // );

    }
}



