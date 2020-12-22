package utils;


import io.cucumber.java.Scenario;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class Base {
    public static WebDriver driver;
    public static Properties prop;
    private Scenario scenario;

    public Base() throws IOException {
        prop = new Properties();
        String path = System.getProperty("user.dir");
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//Drivers//config.properties");

        prop.load(fis);

    }


    public static void init() {
        String browserName = prop.getProperty("browser");
        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers//chromedriver.exe");
            driver = new ChromeDriver();

        }


        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
        System.out.println("Browser has initialized successfully with given URL: " + prop.getProperty("url"));
    }
}
