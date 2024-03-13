package Test;

import Pages.FlightsSearch;
import Pages.HomePage;
import Utils.Helper;
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
        home.IngresarDestino("Santiago (SCL)");
        home.SeleccionarFecha(7, 2024);
        home.SeleccionarPasajeros();
        home.Buscar();
        Assertions.assertTrue(flights.estoyEnFly());
    }

    @Test
    public void TCV_003_BusquedaVuelos_PrimeraClase(){
        home.AceptarCookies();
        home.IngresarOrigen("Lima");
        home.IngresarDestino("Santiago (SCL)");
        home.SeleccionarFecha(7, 2024);
        home.SeleccionarPasajerosPrimeraClase();
        home.SeleccionarMetodoPago();
        home.Buscar();
        Assertions.assertTrue(flights.estoyEnFly());
    }

    @Test
    public void TCV_004_BusquedaVuelos_SinEscala(){
        home.AceptarCookies();
        home.IngresarOrigen("Lima");
        home.IngresarDestino("Santiago (SCL)");
        home.SeleccionarFecha(7, 2024);
        home.SeleccionarPasajeros();
        home.SeleccionarMetodoPago();
        home.Buscar();
        flights.vuelosSinEscalas();
    }

    @Test
    public void TCV_005_reservaVuelos_codigoDescuentoCaducado(){
        home.AceptarCookies();
        home.IngresarOrigen("Lima");
        home.IngresarDestino("Santiago (SCL)");
        home.SeleccionarFecha(7, 2024);
        home.SeleccionarPasajeros();
        home.SeleccionarMetodoPago();
        home.Buscar();
    }

    @Test
    public void TCV_006_reservaVuelos_codigoDescuentoNOExitoso(){
        home.AceptarCookies();
        home.IngresarOrigen("Lima");
        home.IngresarDestino("Santiago (SCL)");
        home.SeleccionarFecha(7, 2024);
        home.SeleccionarPasajeros();
        home.SeleccionarMetodoPago();
        home.Buscar();
    }




}
