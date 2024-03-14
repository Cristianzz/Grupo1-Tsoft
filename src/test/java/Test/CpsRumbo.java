package Test;

import Pages.FlightsSearch;
import Pages.HomePage;
import Pages.checkout;
import Utils.Helper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CpsRumbo {
    checkout check;
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
        check = new checkout(driver);
        home.cargarSitio("https://www.rumbo.es/");
        home.maximizar();
    }

    @AfterEach
    public void posCondiciones(){
        //home.cerrarBrowser();
    }

    //@Test
    public void TCV_001_BusquedaVuelos_CamposValidos(){
        home.AceptarCookies();
        home.IngresarOrigen("Lima");
        home.IngresarDestino("Santiago (SCL)");
        home.SeleccionarFecha(7, 2024);
        home.SeleccionarPasajeros();
        home.Buscar();
        Assertions.assertTrue(flights.estoyEnFly());
    }

    //@Test
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

    //@Test
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
        flights.SeleccionarVuelo();
        check.seleccionarTarifa();
        check.ingresarDatosContacto("Juan","Perez","JuanPerz@gmail.com","Per","999888777");
        check.ingresarDireccion("Jr. Union","111","15762","Lima","Perú");
        check.ingresarDatosPrimerPasajero("14","2000");
        check.ingresarNroDocumentoPrimerPasajero("999999999", "Per","21","2021","21","2024");
        check.ingresarDatosSegundoPasajero("Maria","Cisneros","05","1999");
        check.ingresarNroDocumentoSegundoPasajero("888888888","Per","01","2021","01","2024");
        check.reporteEquipajePrimerPasajero();
        check.reporteEquipajeSegundoPasajero();
        check.seleccionarSiguiente();
        check.seleccionarSinCobertura();
        check.seleccionarSiguiente();
        check.ingresarDescuentoCaducado("2270968630151074");
        Assertions.assertEquals("El bono ha caducado.",check.mensajeAlertaBonoCaducado());
    }

    //@Test
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
