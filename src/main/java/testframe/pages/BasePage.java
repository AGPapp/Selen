package testframe.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testframe.managers.DriverMan;
import testframe.managers.PageMan;


public class BasePage {



    protected DriverMan driverManager = DriverMan.getDriverManager();

    protected PageMan pageManager = PageMan.getPageMan();



    protected WebDriverWait wait = new WebDriverWait(driverManager.getDriver(),10,1000);

    public BasePage() {
        PageFactory.initElements(driverManager.getDriver(), this);
    }
    protected WebElement waitClickability(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected WebElement waitVisibilityOfElement(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }



}
