package Tests;

import Pages.FlightsSearch;
import Pages.HdpCheckout;
import Pages.HomePage;
import Utils.Helper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VuelosTest {

    HomePage home;
    HdpCheckout checkout;
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
        checkout = new HdpCheckout(driver);
        home.cargarSitio("https://www.rumbo.es/");
        home.maximizar();
    }

    @AfterEach
    public void posCondiciones(){
        home.cerrarBrowser();
    }

    @Test
    @DisplayName("TCV_001: Busqueda de vuelos - Campos validos")
    public void TCV_001(){
        home.aceptarCookies();
        home.ingresarOrigen("Lima");
        home.ingresarDestino("Santiago (SCL)");
        home.seleccionarFechaIda(3, 7, 2024);
        home.seleccionarFechaVuelta(8, 7, 2024);
        home.agregarPasajeros(1);
        home.presionarBuscar();
        Assertions.assertTrue(flights.isFlightsSearch());
    }

    @Test
    @DisplayName("TCV_002: Busqueda de vuelos - Campos inválidos")
    public void TCV_002(){
        home.aceptarCookies();
        home.ingresarOrigen("Lima");
        home.ingresarDestino("abcd-2");
        home.seleccionarFechaIda(3, 7, 2024);
        home.seleccionarFechaVuelta(8, 7, 2024);
        home.agregarPasajeros(1);
        home.presionarBuscar();
        assertEquals("Introduce ciudad o aeropuerto de destino", home.obtenerCampoInvalido());
    }

    @Test
    @DisplayName("TCV_003: Busqueda de vuelos - Primera clase")
    public void TCV_003(){
        home.aceptarCookies();
        home.ingresarOrigen("Lima");
        home.ingresarDestino("Santiago (SCL)");
        home.seleccionarFechaIda(3, 7, 2024);
        home.seleccionarFechaVuelta(8, 7, 2024);
        home.seleccionarPrimerClase();
        home.seleccionarMetodoPago();
        home.presionarBuscar();
        Assertions.assertTrue(flights.isFlightsSearch());
    }

    @Test
    @DisplayName("TCV_004: Busqueda de vuelos - Sin escala")
    public void TCV_004(){
        home.aceptarCookies();
        home.ingresarOrigen("Lima");
        home.ingresarDestino("Santiago (SCL)");
        home.seleccionarFechaIda(3, 7, 2024);
        home.seleccionarFechaVuelta(8, 7, 2024);
        home.agregarPasajeros(1);
        home.seleccionarMetodoPago();
        home.presionarBuscar();
        flights.vuelosSinEscalas();
    }

    @Test
    @DisplayName("TCV_005: Reserva de vuelos - Codigo descuento caducado")
    public void TCV_005(){
        home.aceptarCookies();
        home.ingresarOrigen("Lima");
        home.ingresarDestino("Santiago (SCL)");
        home.seleccionarFechaIda(3, 7, 2024);
        home.seleccionarFechaVuelta(8, 7, 2024);
        home.agregarPasajeros(1);
        home.seleccionarMetodoPago();
        home.presionarBuscar();
        flights.seleccionarVuelo();
        checkout.seleccionarTarifa();
        checkout.ingresarDatosContacto("Juan","Perez","JuanPerz@gmail.com","Per","999888777");
        checkout.ingresarDireccion("Jr. Union","111","15762","Lima","Perú");
        checkout.ingresarDatosPrimerPasajero("14","2000");
        checkout.ingresarNroDocumentoPrimerPasajero("999999999", "Per","21","2021","21","2024");
        checkout.ingresarDatosSegundoPasajero("Maria","Cisneros","05","1999");
        checkout.ingresarNroDocumentoSegundoPasajero("888888888","Per","01","2021","01","2024");
        checkout.reporteEquipajePrimerPasajero();
        checkout.reporteEquipajeSegundoPasajero();
        checkout.seleccionarSiguiente();
        checkout.seleccionarSinCobertura();
        checkout.seleccionarSiguiente();
        checkout.ingresarDescuentoCaducado("2270968630151074");
        assertEquals("El bono ha caducado.", checkout.mensajeAlertaBonoCaducado());
    }

    @Test
    @DisplayName("TCV_006: Reserva de vuelos - Codigo descuento no exitoso")
    public void TCV_006(){
        home.aceptarCookies();
        home.ingresarOrigen("Lima");
        home.ingresarDestino("Santiago (SCL)");
        home.seleccionarFechaIda(3, 7, 2024);
        home.seleccionarFechaVuelta(8, 7, 2024);
        home.agregarPasajeros(1);
        home.seleccionarMetodoPago();
        home.presionarBuscar();
        flights.seleccionarVuelo();
        checkout.seleccionarTarifa();
        checkout.ingresarDatosContacto("Juan","Perez","JuanPerz@gmail.com","Per","999888777");
        checkout.ingresarDireccion("Jr. Union","111","15762","Lima","Perú");
        checkout.ingresarDatosPrimerPasajero("14","2000");
        checkout.ingresarNroDocumentoPrimerPasajero("999999999", "Per","21","2021","21","2024");
        checkout.ingresarDatosSegundoPasajero("Maria","Cisneros","05","1999");
        checkout.ingresarNroDocumentoSegundoPasajero("888888888","Per","01","2021","01","2024");
        checkout.reporteEquipajePrimerPasajero();
        checkout.reporteEquipajeSegundoPasajero();
        checkout.seleccionarSiguiente();
        checkout.seleccionarSinCobertura();
        checkout.seleccionarSiguiente();
        checkout.ingresarDescuentoInvalido("APP16");
        String esperado = Helper.corregirEncoding("No hemos encontrado este código descuento.");
        assertEquals(esperado, checkout.mensajeAlertaBonoInvalido());
    }
}
