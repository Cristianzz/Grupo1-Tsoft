package Tests;

import Pages.HdpCheckout;
import Pages.FlightsSearch;
import Pages.HomePage;
import Pages.TrenesPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class TrenesTest {

    HomePage home;
    TrenesPage trenes;
    FlightsSearch flights;
    HdpCheckout checkout;
    WebDriver driver;

    @BeforeAll
    public static void start(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void preCondioniones(){
        driver = new ChromeDriver();
        home = new HomePage(driver);
        trenes = new TrenesPage(driver);
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
    @DisplayName("TCT_001: Reserva de trenes - Dias fuera del rango - dias > 31")
    public void TCT_001(){
        home.aceptarCookies();
        trenes.verMas();
        trenes.ingresarOrigenTren("Madrid");
        trenes.ingresarDestinoTren("Barcelona");
        trenes.seleccionarFechaTren(5,2024);

    }

    @Test
    @DisplayName("TCT_002: Reserva de trenes - Origen y destino iguales")
    public void TCT_002(){
        home.aceptarCookies();
        trenes.verMas();
        trenes.ingresarOrigenTren("Madrid");
        trenes.ingresarDestinoTren("Madrid");
        trenes.seleccionarBuscar();
    }

    @Test
    @DisplayName("TCT_003: Reserva de trenes - Cobertura Adicionales - > 1 pasajero")
    public void TCT_003(){
        home.aceptarCookies();
        trenes.verMas();
        trenes.ingresarOrigenTren("Albacete");
        trenes.ingresarDestinoTren("Alicante");
        trenes.seleccionarFechaTren(5,2024);
        trenes.seleccionarPasajerosTren();
        trenes.seleccionarBuscar();
        trenes.seleccionarViajeTren();
        checkout.cargaCheckout();
        checkout.ingresarDatosContacto("Rodrigo","Sosa","rodrisosa@gmail.com","51","987654321");
        checkout.ingresarDatosPasajeroDni("15","2000","134653");
        }

    @Test
    @DisplayName("TCT_004: Busqueda Trenes - Rango de horarios")
    public void TCT_004(){
        home.aceptarCookies();
        trenes.verMas();
        trenes.ingresarOrigenTren("Albacete");
        trenes.ingresarDestinoTren("Alicante");
        trenes.seleccionarFechaTren(5,2024);
        trenes.seleccionarPasajerosTren();
        trenes.seleccionarBuscar();
        trenes.filtroHorario();
    }

    @Test
    @DisplayName("TCT_005: Reserva de trenes- Todas las Coberturas")
    public void TCT_005(){
        home.aceptarCookies();
        trenes.verMas();
        trenes.ingresarOrigenTren("Albacete");
        trenes.ingresarDestinoTren("Alicante");
        trenes.seleccionarFechaTren(5,2024);
        trenes.seleccionarPasajerosTren();
        trenes.seleccionarBuscar();
        trenes.seleccionarViajeTren();
        checkout.cargaCheckout();
        checkout.ingresarDatosContacto("Rodrigo","Sosa","rodrisosa@gmail.com","51","987654321");
        checkout.ingresarDatosPasajeroDni("15","2000","134653");
        checkout.AsistenciaEspecial();
        checkout.CoberturasAdicionales();
    }

    @Test
    @DisplayName("TCT_006: Reserva de trenes - Asistencia Especial")
    public void TCT_006(){
        home.aceptarCookies();
        trenes.verMas();
        trenes.ingresarOrigenTren("Albacete");
        trenes.ingresarDestinoTren("Alicante");
        trenes.seleccionarFechaTren(5,2024);
        trenes.seleccionarPasajerosTren();
        trenes.seleccionarBuscar();
        trenes.seleccionarViajeTren();
        checkout.cargaCheckout();
        checkout.ingresarDatosContacto("Rodrigo","Sosa","rodrisosa@gmail.com","51","987654321");
        checkout.ingresarDatosPasajeroDni("15","2000","134653");
        checkout.AsistenciaEspecial();
    }

}
