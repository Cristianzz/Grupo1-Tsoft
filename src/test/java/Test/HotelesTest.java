package Test;

import Pages.*;
import Utils.FixingCoding;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HotelesTest {

    InicioPage inicio;
    HotelesPage hoteles;
    HdpPage hdp;
    HotelDetallesPage hotelDetalles;
    CheckoutPage checkout;
    WebDriver driver;

    @BeforeAll
    public static void inicio() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void preCondiciones() {
        driver = new ChromeDriver();
        inicio = new InicioPage(driver);
        hoteles = new HotelesPage(driver);
        hdp = new HdpPage(driver);
        hotelDetalles = new HotelDetallesPage(driver);
        checkout = new CheckoutPage(driver);
        inicio.cargarSitio("https://www.rumbo.es");
        inicio.maximizar();
    }

    @AfterEach
    public void postCondiciones() {
        //home.cerrarBrowser();
    }

    @Test
    @DisplayName("TCH_002: Busqueda de hoteles Exitosa - Limite Habitaciones/Hotel (máx 6)")
    public void TCH_002() {
        inicio.aceptarCookies(); // Paso 1 - Aceptar Cookies
        inicio.irHoteles(); // Paso 2 - Redireccionar a Hoteles
        hoteles.seleccionarDestino("Madrid"); // Paso 3 - Ingresar Destino
        hoteles.seleccionarFechaEntrada(22, 5, 2024); // Paso 3 - Seleccionar Fecha de Entrada
        hoteles.seleccionarFechaSalida(6, 7, 2024); // Paso 4 - Seleccionar Fecha de Salida
        hoteles.agregarPersonas(2); // Paso 5 - Agregar Personas
        hoteles.agregarHabitaciones(5); // Paso 6 - Agregar 5 Habitaciones mas (máx 6)
        hoteles.presionarBuscar(); // Paso 7 - Presionar Buscar
    }

    @Test
    @DisplayName("TCH_004: Reserva de esquí- con desayuno y spa")
    public void TCH_004(){
        inicio.aceptarCookies(); // Paso 1 - Aceptar Cookies
        inicio.irHoteles(); // Paso 2 - Redireccionar a Hoteles
        hoteles.seleccionarDestino("Madrid"); // Paso 3 - Ingresar Destino
        hoteles.seleccionarFechaEntrada(22, 5, 2024); // Paso 3 - Seleccionar Fecha de Entrada
        hoteles.seleccionarFechaSalida(6, 6, 2024); // Paso 4 - Seleccionar Fecha de Salida
        hoteles.agregarPersonas(0); // Paso 5 - Seleccionar Personas
        hoteles.presionarBuscar(); // Paso 6 - Presionar Buscar
        hdp.seleccionarTodosFiltros(); // Paso 7 - Seleccionar Todos los Filtros
        hdp.seleccionarDesayuno(); // Paso 8 - Seleccionar Desayuno
        hdp.seleccionarSPA(); // Paso 9 - Seleccionar SPA
        hdp.presionarAplicarFiltros(); // Paso 10 - Presionar Aplicar Filtros
    }

    @Test
    @DisplayName("TCH_005: Reserva - Seguro de Cancelacion")
    public void TCH_005(){
        inicio.aceptarCookies(); // Paso 1 - Aceptar Cookies
        inicio.irHoteles(); // Paso 2 - Redireccionar a Hoteles
        hoteles.seleccionarDestino("Madrid"); // Paso 3 - Ingresar Destino
        hoteles.seleccionarFechaEntrada(22, 5, 2024); // Paso 3 - Seleccionar Fecha de Entrada
        hoteles.seleccionarFechaSalida(6, 6, 2024); // Paso 4 - Seleccionar Fecha de Salida
        hoteles.agregarPersonas(0); // Paso 5 - Seleccionar Personas
        hoteles.presionarBuscar(); // Paso 6 - Presionar Buscar
        hdp.irHotelDetalles(1); // Paso 7 - Seleccionar el hospedaje
        hotelDetalles.seleccionarVerMas(); // Paso 8 - Seleccionar Cta
        hotelDetalles.seleccionarRegimen(); // Paso 9 - Seleccionar el regimen
        hotelDetalles.seleccionarHabitacion(1); // Paso 10 - Elejir la habitacion
        checkout.ingresarDatosContacto("John", "Doe", "john.doe@gmail.com","51","987654321"); // Paso 11 - Ingresar datos de contacto
        checkout.seleccionarSeguroCancelacion(); // Paso 12 - Seleccionar seguro de cancelacion
    }

}
