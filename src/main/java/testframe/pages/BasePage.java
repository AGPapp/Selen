package testframe.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testframe.managers.DriverMan;
import testframe.managers.PageMan;
import testframe.managers.TstProperties;

import java.sql.DriverManager;
import java.time.Duration;
import java.util.List;

import static java.lang.Integer.parseInt;

public class BasePage {



    protected DriverMan driverManager = DriverMan.getDriverManager();

    protected PageMan pageManager = PageMan.getPageMan();



    protected WebDriverWait wait = new WebDriverWait(driverManager.getDriver(),10,1000);

    public BasePage() {
        PageFactory.initElements(driverManager.getDriver(), this);
    }

    protected boolean waitInvisibilityOfElement(WebElement e) {
        return wait.until(ExpectedConditions.invisibilityOf(e));
    }
    protected WebElement waitClickability(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected WebElement waitUtilElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    protected WebElement waitVisibilityOfElement(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }



}
