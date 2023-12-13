package testframe.pages;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testframe.managers.PageMan;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class CreateKomPage extends BasePage {

    @FindBy(xpath = "//div[@class='loader-content']")
    protected WebElement loading;
    @FindBy(xpath = "//a[@title='Создать командировку']")
    private WebElement createCom;

    @FindBy(xpath = "//h1[@class='user-name']")
    private WebElement title;

    @FindBy(xpath = "//select[@required='required']")
    private WebElement podrazdelenie;

    @FindBy(xpath = "//option[text()='Отдел внутренней разработки']")
    private WebElement viborPodrazrel;
    @FindBy(xpath = "//a[@id='company-selector-show']")
    private WebElement organisations;
    @FindBy(xpath = "//span[@class='select2-chosen']")
    private WebElement poiskOrg;
    @FindBy(xpath = "//div[contains(text(),'(Хром) Призрачная Организация Охотников')]")
    private WebElement organisation;

    @FindBy(xpath = "//input[@data-name='field__departure-city']")
    private WebElement departureCity;

    @FindBy(xpath = "//input[@data-name='field__arrival-city']")
    private WebElement arrivalCity;

    @FindBy(xpath ="//input[contains(@id,'departureDatePlan') and contains(@class,'datepicker-input')]")
    private WebElement startDate;
    @FindBy(xpath = "//input[contains(@id,'returnDatePlan') and contains(@class,'datepicker-input')]")
    private WebElement finDate;
    @FindBy(xpath = "//div[@id='oro-dropdown-mask']")
    private WebElement mask;
    @FindBy(xpath = "//label[text()='Заказ билетов']")
    private WebElement checkbox;

    @FindBy(xpath = "//button[@class ='btn btn-success action-button']")
    private WebElement button;

    @FindBy(xpath ="//div[@class='control-group control-group-collection']//span[@class='validation-failed']")
    private WebElement message;

    public CreateKomPage() {
        pageManager = PageMan.getPageMan();
    }
  //  @Step("Создание ново   й коммандировки")

    public CreateKomPage newCom(){
        waitClickability(createCom).click();
        return this;
    }
  //  @Step("Заполнение подразделения")
    public CreateKomPage podrazdelenie() {
        podrazdelenie.click();
        waitClickability(viborPodrazrel).click();
        return this;
    }
   // @Step("Заполнение организации")
    public CreateKomPage organisations() {
        waitVisibilityOfElement(organisations).click();
        waitVisibilityOfElement(poiskOrg).click();
        waitVisibilityOfElement(organisation).click();

        return this;
    }
   // @Step("заполнение города отбытия")
    public CreateKomPage departureCity(String city){
        departureCity.clear();
        departureCity.sendKeys(city);
       return this;
    }
  //  @Step("Заполонение города прибытия")
    public CreateKomPage arrivalCity(String city){

        arrivalCity.sendKeys(city);
        return this;
    }
  //  @Step("Заполнение дат")
    public CreateKomPage date(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate date = LocalDate.now();
        String startD = date.plusDays(15).format(formatter);
        String finD = date.plusDays(23).format(formatter);
        startDate.sendKeys(startD);
        finDate.sendKeys(finD);
        mask.click();

        return this;
    }
   // @Step("Отметка Ч/Б 'Заказ билетов'")
    public CreateKomPage checkbox(){
        checkbox.click();
        return this;
    }
  //  @Step("Проверка на заполненность, при нажатии Сохранить")
    public CreateKomPage saveBut(){
        button.click();
        waitVisibilityOfElement(message);
        Assertions.assertEquals("Список командируемых сотрудников не может быть пустым",message.getText(),"Сообщение " +
                "'Список командируемых сотрудников не может быть пустым' не появилось");
        return this;
    }
    public CreateKomPage alert(){
        waitVisibilityOfElement(message);
        Assertions.assertEquals("Список командируемых сотрудников не может быть пустым",message.getText(),"Сообщение " +
                "'Список командируемых сотрудников не может быть пустым' не появилось");
        return this;
    }









}
