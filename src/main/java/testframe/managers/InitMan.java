package testframe.managers;

import java.util.concurrent.TimeUnit;

public class InitMan {

    private static final DriverMan driverManager = DriverMan.getDriverManager();

    public static void initFramework() {
        driverManager.getDriver().manage().window().maximize();
        driverManager.getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driverManager.getDriver().manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
    }


    public static void quitChrom() {
        driverManager.quitDriver();
    }
}

