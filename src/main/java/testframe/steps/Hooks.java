package testframe.steps;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import testframe.managers.DriverMan;

import static  testframe.managers.DriverMan.getDriverManager;

public class Hooks {
    final WebDriver driver= getDriverManager().getDriver();

    @After
    public void cuc (Scenario scenario) {
        String screen = scenario.getId().replace(" ", "_");
        try{
            if (scenario.isFailed()){
                scenario.log("Внимание!");
                TakesScreenshot ts = (TakesScreenshot) driver;
                byte[] screnshit = ts.getScreenshotAs(OutputType.BYTES);
                scenario.attach(screnshit,"image/png", screen);
            }
        } catch ( Exception e) {
            e.printStackTrace();
        }
       DriverMan.getDriverManager().quitDriver();;
    }

}
