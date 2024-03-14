package Test;

import Pages.Checkout;
import Pages.FlightsSearch;
import Pages.HomePage;
import Pages.TrenesPage;
import Utils.Helper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CpsRumbo {
    HomePage home;

    TrenesPage trenesPage;

    FlightsSearch flights;
    Checkout checkout;
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
        checkout = new Checkout(driver);
        home.cargarSitio("https://www.rumbo.es/");
        home.maximizar();
    }

    @AfterEach
    public void posCondiciones(){
        //home.cerrarBrowser();
    }

/*
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


*/

   ///////-------- Trenes ----------////////
  /* @Test
    public void TCT_001(){
        home.AceptarCookies();
        trenesPage.Vermas();
        trenesPage.IngresarOrigenTren("Madrid");
        trenesPage.IngresarDestinoTren("Barcelona");
        trenesPage.SeleccionarFechaTren(5,2024);

    }*/
   /* @Test
    public void TCT_002(){
        home.AceptarCookies();
        trenesPage.Vermas();
        trenesPage.IngresarOrigenTren("Madrid");
        trenesPage.IngresarDestinoTren("Madrid");
        // trenesPage.SeleccionarFechaTren(5,2024);
        trenesPage.Buscar();
    }*/

/*    @Test
    public void TCT_003(){
        home.AceptarCookies();
        trenesPage.Vermas();
        trenesPage.IngresarOrigenTren("Albacete");
        trenesPage.IngresarDestinoTren("Alicante");
        trenesPage.SeleccionarFechaTren(5,2024);
        trenesPage.SeleccionarPasajerosTren();
        trenesPage.Buscar();
        trenesPage.SeleccionarViajeTren();
       // checkout.SeleccionarTarifaTren();
        checkout.DatosContacto("Rodrigo","Sosa","rodrisosa@gmail.com","987654321");
        checkout.DatosPasajero("15","2000","134653");

    }*/
    @Test
    public void TCT_003(){
        home.AceptarCookies();
        trenesPage.Vermas();
        trenesPage.IngresarOrigenTren("Albacete");
        trenesPage.IngresarDestinoTren("Alicante");
        trenesPage.SeleccionarFechaTren(5,2024);
        trenesPage.SeleccionarPasajerosTren();
        trenesPage.Buscar();
        trenesPage.FiltroHorario();

    }

     /*@Test
    public void TCT_005){
        home.AceptarCookies();
        trenesPage.Vermas();
        trenesPage.IngresarOrigenTren("Albacete");
        trenesPage.IngresarDestinoTren("Alicante");
        trenesPage.SeleccionarFechaTren(5,2024);
        trenesPage.SeleccionarPasajerosTren();
        trenesPage.Buscar();
        trenesPage.SeleccionarViajeTren();
        // checkout.SeleccionarTarifaTren();
        checkout.DatosContacto("Rodrigo","Sosa","rodrisosa@gmail.com","987654321");
        checkout.DatosPasajero("15","2000","134653");
        checkout.AsistenciaEspecial();
        checkout.CoberturasAdicionales();
    }*/
    /*@Test
    public void TCT_006(){
        home.AceptarCookies();
        trenesPage.Vermas();
        trenesPage.IngresarOrigenTren("Albacete");
        trenesPage.IngresarDestinoTren("Alicante");
        trenesPage.SeleccionarFechaTren(5,2024);
        trenesPage.SeleccionarPasajerosTren();
        trenesPage.Buscar();
        trenesPage.SeleccionarViajeTren();
        // checkout.SeleccionarTarifaTren();
        checkout.DatosContacto("Rodrigo","Sosa","rodrisosa@gmail.com","987654321");
        checkout.DatosPasajero("15","2000","134653");
        checkout.AsistenciaEspecial();
    }*/


}
