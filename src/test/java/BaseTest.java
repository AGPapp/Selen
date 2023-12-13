//import extension.AllureExtension;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import testframe.managers.DriverMan;
//import testframe.managers.PageMan;
//import testframe.managers.InitMan;
//import testframe.managers.TstProperties;
//import testframe.pages.BasePage;
//@ExtendWith(AllureExtension.class)
//public class BaseTest extends BasePage {
//    private final TstProperties properties = TstProperties.getProperty();
//
//
//
//    private final DriverMan driverManager = DriverMan.getDriverManager();
//
//
//    public static void beforeAll() {
//        InitMan.initFramework();
//    }
//
//
//
//
//
//    public static void afterAll() {
//        InitMan.quitChrom();
//    }
//
//
//    void test() {
//        PageMan.getPageMan().getStartPage()
//                .loginPassword(
//                        properties.getProperty("LOGIN"),
//                        properties.getProperty("PASSWORD")
//                )
//                .enter()
//                .pageTitle()
//                .navPanel("Расходы")
//                .selectMenu("Командировки")
//                .newCom()
//                .podrazdelenie()
//                .organisations()
//                .departureCity("Мурманск")
//                .arrivalCity("Гондурас")
//                .date()
//                .checkbox()
//                .saveBut();
//
//
//    }
//
//
//}