
//
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.text.DateFormat;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.Date;
//import java.util.concurrent.TimeUnit;
//
//public class MyTestSel {
//    WebDriver driver;
//    WebDriverWait wait;
//
//
//    @BeforeEach
//    public void beforeTest() {
//        System.setProperty("webdriver.chrome.driver", "src/java/resources/chromedriver.exe");
//        driver = new ChromeDriver();
//        wait = new WebDriverWait(driver, 10, 1000);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//    }
//
//    @Test
//    public void test(){
//        // шаг 1 Переход
//        driver.get("http://training.appline.ru/user/login");
//
//
//        // шаг 2 Авторизация
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//form[@id='login-form']"))));
//        driver.findElement(By.xpath("//input[@placeholder='Имя пользователя или Email']")).sendKeys("Irina Filippova");
//        driver.findElement(By.xpath("//input[@placeholder='Пароль']")).sendKeys("testing");
//        driver.findElement(By.xpath("//button[contains(text(),'Войти')]")).click();
//
//        // шаг 3 Проверка наличия заголовка
//         WebElement checkPanel = driver.findElement(By.xpath("//h1[@class='oro-subtitle']"));
//        Assertions.assertEquals("Панель быстрого запуска",checkPanel.getText(), "Заголовок не соответствует");
//
//        // шаг 4 В выплывающем окне раздела Расходы нажать Коммандировки
//        driver.findElement(By.xpath("//span[text()='Расходы']")).click();
//        driver.findElement(By.xpath("//span[text()='Командировки']")).click();
//
//        //шаг 5 Создание коммандировки
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@title='Создать командировку']"))));
//         driver.findElement(By.xpath("//a[@title='Создать командировку']")).click();
//
//        //шаг6 Наличие заголовка
//        WebElement zagolovok = driver.findElement(By.xpath("//h1[@class='user-name']"));
//        Assertions.assertEquals("Создать командировку",zagolovok.getText(), "Заголовок не соответствует");
//
//        //шаг 7 Заполнение полей
//
//        driver.findElement(By.xpath("//select[@required='required']")).click();
//        driver.findElement(By.xpath("//option[text()='Отдел внутренней разработки']")).click();
//        driver.findElement(By.xpath("//a[@id='company-selector-show']")).click();
//        driver.findElement(By.xpath("//span[@class='select2-chosen']")).click();
//        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[contains(@class,'select2-input')]")))).sendKeys("Ibs пао");
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='IBS ПАО']"))).click();
//        driver.findElement(By.xpath("//label[text()='Заказ билетов']")).click();
//        driver.findElement(By.xpath("//input[@data-name='field__departure-city']")).clear();
//        driver.findElement(By.xpath("//input[@data-name='field__departure-city']")).sendKeys("Мурманск");
//        driver.findElement(By.xpath("//input[@data-name='field__arrival-city']")).sendKeys("Гондурас");
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
//        LocalDate date = LocalDate.now();
//        String startDate = date.plusDays(15).format(formatter);
//        String finDate = date.plusDays(23).format(formatter);
//
//        driver.findElement(By.xpath("//input[contains(@id,'departureDatePlan') and contains(@class,'datepicker-input')]")).sendKeys(startDate);
//        driver.findElement(By.xpath("//input[contains(@id,'returnDatePlan') and contains(@class,'datepicker-input')]")).sendKeys(finDate);
//        driver.findElement(By.xpath("//div[@id='oro-dropdown-mask']")).click();
//        //шаг 8 Проверить, что все поля заполнены
//        //Подразделение
//                WebElement ovr = driver.findElement(By.xpath("//div[@class='selector input-widget-select']/span"));
//        Assertions.assertEquals("Отдел внутренней разработки",ovr.getText(), "В блоке 'Подразделление' не выбран 'Отдел внутренней разработки'");
//        //даты
//                WebElement stDate = driver.findElement(By.xpath("//input[contains(@id,'departureDatePlan') and contains(@class,'datepicker-input')]"));
//        Assertions.assertFalse(stDate.getText().contains("hasDatepicker error"),"Дата отъезда не указана");
//                 WebElement endDate = driver.findElement(By.xpath("//input[contains(@id,'returnDatePlan') and contains(@class,'datepicker-input')]"));
//        Assertions.assertFalse(endDate.getText().contains("hasDatepicker error"),"Дата возвращения не указана");
//        // чекбокс
//        WebElement cBox = driver.findElement(By.xpath("//input[contains(@id,'crm_business_trip_tasks_1')]"));
//        Assertions.assertTrue(cBox.isSelected(),"Чекбокс 'Заказ билетов' не выбран");
//        //организация
//        WebElement org = driver.findElement(By.xpath("//span[@class='select2-chosen']"));
//        Assertions.assertEquals("IBS ПАО",org.getText(),"Не выбрана оргнизация");
//        // Шаг 9 Сохранить
//        driver.findElement(By.xpath("//button[@class ='btn btn-success action-button']")).click();
//
//        //шаг 10 проыерка
//
//        WebElement message = driver.findElement(By.xpath("//div[@class='control-group control-group-collection']//span[@class='validation-failed']"));
//        Assertions.assertEquals("Список командируемых сотрудников не может быть пустым",message.getText(),"Сообщение " +
//                "'Список командируемых сотрудников не может быть пустым' не появилось");
//
//    }
//
//    @AfterEach
//    public void after(){
//        driver.quit();    }
//
//}