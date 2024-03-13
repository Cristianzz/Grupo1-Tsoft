package Test;

import Pages.FlightsSearch;
import Pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CpsRumbo {
    HomePage home;
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
        flights = new FlightsSearch(driver);
        home.cargarSitio("https://www.rumbo.es/");
        home.maximizar();
    }

    @AfterEach
    public void posCondiciones(){
        //home.cerrarBrowser();
    }

    @Test
    public void TCV_001_BusquedaVuelos_CamposValidos(){
        home.AceptarCookies();
        home.IngresarOrigen("Lima");
        home.IngresarDestino("Tokio");
        home.SeleccionarFecha();
        home.SeleccionarPasajeros();
        home.Buscar();
        Assertions.assertTrue(flights.MensajeResultado().contains("resultado"));
    }

    @Test
    public void TCV_003_BusquedaVuelos_PrimeraClase(){
        home.AceptarCookies();
        home.IngresarOrigen("Madrid");
        home.IngresarDestino("Tokio");
        home.SeleccionarFecha();
        home.SeleccionarPasajerosPrimeraClase();
        home.SeleccionarMetodoPago();
        home.Buscar();
        Assertions.assertTrue(flights.MensajeResultado().contains("resultado"));
    }



}
