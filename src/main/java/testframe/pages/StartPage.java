package testframe.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testframe.managers.TstProperties;

import javax.xml.xpath.XPath;
import java.util.List;
import java.util.Properties;

public class StartPage extends  BasePage{
    private  final TstProperties properties = TstProperties.getProperty();

    @FindBy(xpath = "//form[@id='login-form']")
    private WebElement loginForm;

    @FindBy(xpath = "//input[@placeholder='Имя пользователя или Email']")
    private WebElement userName;

    @FindBy(xpath = "//input[@placeholder='Пароль']")
    private WebElement password;

    @FindBy(xpath = "//button[contains(text(),'Войти')]")
    private WebElement enter;

    @FindBy(xpath = "//h1[@class='oro-subtitle']")
    private WebElement pageTitle;

    @FindBy(xpath = "//ul[contains(@class, 'main-menu')]/li/a/span")
    private List<WebElement> navPanel;

    @FindBy(xpath = "//ul[contains(@class, 'dropdown-menu')]/li/a/span")
    private List<WebElement> dropDownMenu;


    public StartPage loginPassword() {
        waitUtilElementToBeClickable(loginForm);
        userName.sendKeys(properties.getProperty("LOGIN"));
        password.sendKeys(properties.getProperty("PASSWORD"));
        return this;}


    public StartPage enter() {
        enter.click();
        return this;
    }

    public StartPage pageTitle() {
        waitVisibilityOfElement(pageTitle);
        Assertions.assertEquals("Панель быстрого запуска", pageTitle.getText());
        return this;
    }
    public StartPage navPanel (String nav) {
        for (WebElement element : navPanel) {
            if (element.getText().equals(nav)) {
                element.click();
                return this;
            }
        }
        Assertions.fail( nav + "не найдено");
        return this;
    }
    public CreateKomPage  selectMenu(String menu) {
        for (WebElement element : dropDownMenu) {
            if (element.getText().equals(menu)) {
                waitVisibilityOfElement(element).click();
                return pageManager.getCreateKomPage();
            }
        }
        Assertions.fail("Пункт меню " + menu + " не найден");

        return pageManager.getCreateKomPage();
    }




    }










