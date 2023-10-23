package testframe.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverMan {

    private WebDriver driver;

    private static DriverMan instance = null;

    private final TstProperties properties = TstProperties.getProperty();

    private DriverMan() {
    }

    public static DriverMan getDriverManager() {
        if (instance == null) {
            instance = new DriverMan();
        }
        return instance;
    }

    public WebDriver getDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    private void initDriver() {
        System.setProperty(properties.getProperty("WEB_DRIVER"), properties.getProperty("WEB_DRIVER_PATH"));
        driver = new ChromeDriver();
    }
}