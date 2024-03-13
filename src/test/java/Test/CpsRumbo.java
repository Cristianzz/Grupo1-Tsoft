package Test;

import Pages.HomePage;
import Pages.TrenesPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class    CpsRumbo {
    HomePage home;
    TrenesPage trenesPage;
    WebDriver driver;

    @BeforeAll
    public static void start(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void preCondioniones(){
        driver = new ChromeDriver();
        home = new HomePage(driver);
        trenesPage = new TrenesPage(driver);
        home.cargarSitio("https://www.rumbo.es/");
        home.maximizar();
    }

    @AfterEach
    public void posCondiciones(){
        //home.cerrarBrowser();
    }

    /*@Test
    public void TCV_001(){
        home.AceptarCookies();
        home.IngresarOrigen("Mexico");
        home.IngresarDestino("Paris");
        home.SeleccionarFecha();
        home.Buscar();
    }*/




    //Test Trenes
    @Test
    public void TCT_001(){
        home.AceptarCookies();
        trenesPage.Vermas();

    }


    

}
