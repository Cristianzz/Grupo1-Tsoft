package Test;

import Pages.*;
import Utils.Helper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HotelesTest {

    HomePage home;
    HotelesPage hoteles;
    HdpSearch search;
    HdpDetails details;
    HdpCheckout checkout;
    WebDriver driver;

    @BeforeAll
    public static void inicio() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void preCondiciones() {
        driver = new ChromeDriver();
        home = new HomePage(driver);
        hoteles = new HotelesPage(driver);
        search = new HdpSearch(driver);
        details = new HdpDetails(driver);
        checkout = new HdpCheckout(driver);
        home.cargarSitio("https://www.rumbo.es");
        home.maximizar();
    }

    @AfterEach
    public void postCondiciones() {
        home.cerrarBrowser();
    }

   // @Test
    @DisplayName("TCH_001: Busqueda de hoteles Exitosa - Agregar Huspedes")
    public void TCH_001() {
        home.aceptarCookies();
        home.irHoteles();
        hoteles.seleccionarDestino("Barcelona");
        hoteles.seleccionarFecha(5,2024);
        hoteles.agregarPersonas(2);
        hoteles.presionarBuscar();
    }

   // @Test
    @DisplayName("TCH_002: Busqueda de hoteles Exitosa - Limite Habitaciones/Hotel (máx 6)")
    public void TCH_002() {
        home.aceptarCookies();
        home.irHoteles();
        hoteles.seleccionarDestino("Madrid");
        hoteles.seleccionarFecha(5, 2024);
        hoteles.agregarPersonas(2);
        hoteles.agregarHabitaciones(5);
        hoteles.presionarBuscar();
    }

   // @Test
    @DisplayName("TCH_003: Busqueda de hoteles Exitosa - Filtro por estrellas")
    public void TCH_003() {
        home.aceptarCookies();
        home.irHoteles();
        hoteles.seleccionarDestino("Barcelona");
        hoteles.seleccionarFecha(5,2024);
        hoteles.agregarPersonas(2);
        hoteles.presionarBuscar();
        hoteles.filtroEstrellasHotel();
    }

    //@Test
    @DisplayName("TCH_004: Reserva de hotel - con desayuno y spa")
    public void TCH_004(){
        home.aceptarCookies();
        home.irHoteles();
        hoteles.seleccionarDestino("Madrid");
        hoteles.seleccionarFecha(5, 2024);
        hoteles.agregarPersonas(0);
        hoteles.presionarBuscar();
        search.seleccionarTodosFiltros();
        search.seleccionarDesayuno();
        search.seleccionarSPA();
    }

    //@Test
    @DisplayName("TCH_005: Reserva - Seguro de Cancelacion")
    public void TCH_005(){
        home.aceptarCookies();
        home.irHoteles();
        hoteles.seleccionarDestino("Madrid");
        hoteles.seleccionarFecha(5, 2024);
        hoteles.agregarPersonas(0);
        hoteles.presionarBuscar();
        search.irHotelDetalles(1);
        details.seleccionarVerMas();
        details.seleccionarRegimen();
        details.seleccionarHabitacion(1);
        checkout.cargaCheckout();
        checkout.ingresarDatosContacto("John", "Doe", "john.doe@gmail.com","51","987654321");
        checkout.seleccionarSeguroCancelacion();
    }

    //@Test
    @DisplayName("TCH_006: Reserva - Pago con Tarjeta")
    public void TCH_006(){
        home.aceptarCookies();
        home.irHoteles();
        hoteles.seleccionarDestino("Madrid");
        hoteles.seleccionarFecha(5, 2024);
        hoteles.agregarPersonas(0);
        hoteles.presionarBuscar();
        search.irHotelDetalles(1);
        details.seleccionarVerMas();
        details.seleccionarRegimen();
        details.seleccionarHabitacion(1);
        checkout.cargaCheckout();
        checkout.ingresarDatosContacto("John", "Doe", "john.doe@gmail.com","51","987654321");
        checkout.seleccionarSeguroCancelacion();
        checkout.ingresarTarjeta("0123456789123456", 321);
        // Assert compara mensaje de error de campo con el mensaje esperado
        String esperado = Helper.corregirEncoding("Introduce un número válido.");
        assertEquals(esperado, checkout.obtenerCampoInvalido());
    }

}