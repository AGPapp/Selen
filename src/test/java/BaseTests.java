import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testframe.managers.DriverMan;
import testframe.managers.PageMan;
import testframe.managers.InitMan;
import testframe.managers.TstProperties;
import testframe.pages.BasePage;
;
public class BaseTests extends BasePage {
    private final TstProperties properties = TstProperties.getProperty();
    protected PageMan pageMan = PageMan.getPageMan();


    private final DriverMan driverManager = DriverMan.getDriverManager();

    @BeforeAll
    public static void beforeAll() {
        InitMan.initFramework();
    }

    @BeforeEach
    public void beforeEach() {
        driverManager.getDriver().get(TstProperties.getProperty().getProperty("HOSTNAME"));
    }

//    @AfterAll
//    public static void afterAll() {
//        InitMan.quitChrom();
//    }

    @Test
    public void test() {
        PageMan.getPageMan().getStartPage()
                .loginPassword()
                .enter()
                .pageTitle()
                .navPanel("Расходы")
                .selectMenu("Командировки")
                .newCom()
                .podrazdelenie()
                .organisations()
                .departureCity("Мурманск")
                .arrivalCity("Гондурас")
                .date()
                .checkbox()
                .saveBut();


    }


}