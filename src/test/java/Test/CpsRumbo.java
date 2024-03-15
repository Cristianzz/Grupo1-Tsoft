package Test;

import Pages.FlightsSearch;
import Pages.HomePage;
import Pages.Hoteles;
import Pages.Trenes;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CpsRumbo {
    HomePage home;
    Hoteles hotel;
    Trenes trenes;
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
        hotel = new Hoteles(driver);
        trenes = new Trenes(driver);
        flights = new FlightsSearch(driver);
        home.cargarSitio("https://www.rumbo.es/");
        home.maximizar();
    }
    @AfterEach
    public void posCondiciones(){
        //home.cerrarBrowser();
    }
    @Test
    public void TCH_001_IrAPaginaHoteles_AgregarHuspedes() {
        home.AceptarCookies();
        home.irAPaginaHoteles(); // Hacer clic en el menú de hoteles
        hotel.IngresarLugarAlojamiento("Barcelona"); // Alojamiento
        hotel.SeleccionarFecha(5,2024);
        hotel.SeleccionarPasajeros();
        hotel.Buscar();
    }
    @Test
    public void TCH_002_IrAPaginaHoteles_busquedaconestrellas() {
        home.AceptarCookies();
        home.irAPaginaHoteles(); // Hacer clic en el menú de hoteles
        hotel.IngresarLugarAlojamiento("Barcelona"); // Alojamiento
        hotel.SeleccionarFecha(5,2024);
        hotel.SeleccionarPasajeros();
        hotel.Buscar();
        hotel.FiltroEstrellasHotel();
    }
    @Test
    public void TCH_003_IrAPaginaTrenes_busquedaconestrellas() {
        home.AceptarCookies();
        trenes.Vermas();
        trenes.IngresarOrigen("Madrid");
        trenes.IngresarDestino("Barcelona");
        trenes.SeleccionarFechaTrenes(5,2024);
        trenes.BuscardorTrenes();
    }
}
