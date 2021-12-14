package com.demo.nopcommerce.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BasePage {
    /**
     * @return
     */
    WebDriver driver;
    Properties prop;
   FileInputStream file;

    public WebDriver initialiseDriver(String browserName) {

        if (browserName.equals("Chrome")) {
           System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\IdeaProjects\\Software\\chromedriver.exe");
           // WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equals("edge")) {
            System.setProperty("webdriver.edge.driver", "C:\\Users\\User\\IdeaProjects\\" +
                    "POMFramework1\\src\\test\\resources\\browserdriver\\msedgedriver.exe");
            driver = new EdgeDriver();
        } else if (browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\User\\IdeaProjects\\" +
                    "POMFramework1\\src\\test\\resources\\" +
                    "browserdriver\\geckodriver.exe");
        } else {
            System.out.println(browserName + "Browser is invalid, please enter correct browser name");
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        return driver;
    }

    public Properties initialiseProperties() {
        prop = new Properties();
        try { file = new FileInputStream("C:\\Users\\User\\IdeaProjects\\" +
                "POMFramework1\\src\\test\\resources\\TestData\\config.properties");
            prop.load(file);
        } catch (FileNotFoundException e) {
            System.out.println("Config file not found");
        }
         catch (IOException e) {
            e.printStackTrace();
        }
        return prop;



    }
}



