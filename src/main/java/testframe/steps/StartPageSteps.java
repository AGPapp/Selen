package testframe.steps;

import io.cucumber.java.ru.И;

import testframe.managers.DriverMan;
import testframe.managers.PageMan;
import testframe.managers.TstProperties;



public class StartPageSteps {

    final DriverMan driverManager = DriverMan.getDriverManager();
    final PageMan pageMan = PageMan.getPageMan();
    final TstProperties properties = TstProperties.getProperty();

    @И("Зайти на портал")
    public void наПортал() {
        driverManager.getDriver().get(TstProperties.getProperty().getProperty("HOSTNAME"));
    }
@И("Заполнение Логина и Пароля")
    public void enterLogPass() {
        pageMan.getStartPage().loginPassword(properties.getProperty("LOGIN")
                , properties.getProperty("PASSWORD"));
    }
    @И("Нажать кнопку 'Подтвердить'")
    public void pressEnter() {
        pageMan.getStartPage().enter();
    }
    @И("Выбрать в меню {string}")
    public void меню(String nav) {
        pageMan.getStartPage().navPanel(nav);
    }
    @И("Выбрать пункт меню {string}")
    public void пунктМеню(String menu){
        pageMan.getStartPage().selectMenu(menu);
    }

    @И("Нажать кнопку'Создать командировку'")
    public void создатьКомандировку(){
        pageMan.getCreateKomPage().newCom();}
    @И("Указать подразделение'")
    public void указатьПодразделение(){
        pageMan.getCreateKomPage().podrazdelenie();}
    @И("Заполнить поле 'Организация'")
    public void заполнитьОрганизацию(){
        pageMan.getCreateKomPage().organisations();}
    @И("Заполнить город отбытия: {string} ")
    public void заполнитьГородОткуда(String city){
        pageMan.getCreateKomPage().departureCity(city);}

    @И("Заполнить поля дат")
    public void заполнитьПоляДат(){
        pageMan.getCreateKomPage().date();}
    @И("Отметить чекбокс")
    public void отметитьЧекбокс(){
        pageMan.getCreateKomPage().checkbox();}
    @И("Сохранить ")
    public void сохранение(){
        pageMan.getCreateKomPage().saveBut();}
    @И("Проверить сообщение")
    public void проверка (){
        pageMan.getCreateKomPage().alert();
    }



}
