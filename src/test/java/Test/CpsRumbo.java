package Test;

import Pages.FlightsSearch;
import Pages.HomePage;
import Pages.TrenesPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CpsRumbo {
    HomePage home;

    TrenesPage trenesPage;

    FlightsSearch flights;

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
        flights = new FlightsSearch(driver);
        home.cargarSitio("https://www.rumbo.es/");
        home.maximizar();
    }

    @AfterEach
    public void posCondiciones(){
        //home.cerrarBrowser();
    }



    @Test
    public void TCT_001(){
        home.AceptarCookies();
        trenesPage.Vermas();

    }

}
