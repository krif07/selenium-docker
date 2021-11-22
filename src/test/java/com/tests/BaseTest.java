package com.tests;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setupDriver() throws MalformedURLException {

        String host = "localhost";
        String browser = "chrome";
        String version = "94.0.4606.61";

        if(System.getProperty("BROWSER") != null){
            if (System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
                browser = "firefox";
                version = "92.0.1";
            }
        }

        if(System.getProperty("HUB_HOST") != null){
            host = System.getProperty("HUB_HOST");
        }

        String completeUrl = "http://" + host + ":4444/wd/hub";
        DesiredCapabilities dc = new DesiredCapabilities(browser,version, Platform.LINUX);
        this.driver = new RemoteWebDriver(new URL(completeUrl), dc);

        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\cristian.davila\\Documents\\Cursos\\docker\\chromedriver\\chromedriver.exe");
        //this.driver = new ChromeDriver();
    }

    @AfterTest
    public void quitDriver(){
        this.driver.quit();
    }
}
