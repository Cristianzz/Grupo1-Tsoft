package Test;

import Pages.InicioPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VuelosTest {


    InicioPage home;
    WebDriver driver;

    @BeforeAll
    public static void inicio() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void preCondiciones() {
        driver = new ChromeDriver();
        home = new InicioPage(driver);
        home.cargarSitio("https://www.rumbo.es");
        home.maximizar();
    }

    @AfterEach
    public void postCondiciones() {
        //home.cerrarBrowser();
    }

    @Test
    @DisplayName("TCV_002: Busqueda de vuelos - Campos inválidos")
    public void TCV_002(){
        home.aceptarCookies(); // Paso 1 - Aceptar cookies
        home.ingresarOrigen("Lima"); // Paso 2 - Ingresar origen valido
        home.ingresarDestino("abcd-2"); // Paso 3 - Ingresar destino inválida
        home.seleccionarFechaIda(3, 12, 2024); // Paso 4 - Seleccionar fecha de ida
        home.seleccionarFechaVuelta(6, 1, 2025); // Paso 5 - Seleccionar fecha de vuelta
        home.agregarPasajeros(2); // Paso 6 - Seleccionar adultos
        home.presionarBuscar(); // Paso 7 - Realizar búsqueda
        // assert compara mensaje de error de campo con el mensaje esperado
        assertEquals("Introduce ciudad o aeropuerto de destino", home.obtenerCampoInvalido());
    }

}