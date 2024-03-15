package Pages;

import Utils.BasePage;
import Utils.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HotelesPage extends BasePage {

    private final By byInputUbicacion = By.xpath("//input[contains(@aria-label, 'alojamiento')]");
    private final By byInputFechaEntrada = By.xpath("//button[@aria-label='Fecha de entrada']");
    private final By byFechaida = By.xpath("(//div[@class=\"d-iy1bge\"]/button[1])[1]");
    private final By byFechaVuelta = By.xpath("(//div[@class=\"d-iy1bge\"]/button[7])[1]");
    private final By byBtnAgregarPersonas = By.xpath("//button[contains(@aria-label,'adultos')][2]");
    private final By byBtnAgregarHabitaciones = By.xpath("//button[contains(text(),'habitaci')]");
    private final By byBtnBuscar = By.xpath("//button[@aria-label='Buscar']");
    private final By byPillStarsContainer = By.xpath("//*[@id='Pill-StarsContainer']");
    private final By byPillStarsContainer2 = By.id("exp_elem_hotel_stars_3");
    private final By byBtnAplicarEstrellas= By.xpath("//button[contains(text(),'Aplicar')]");

    public HotelesPage(WebDriver driver) {
        super(driver);
    }

    public void seleccionarDestino(String destino) {
        esperarxsegundos(1000);
        agregarTexto(esperarElementoWeb(byInputUbicacion), destino);
    }

    public void seleccionarFecha(int mes, int anio) {
        esperarxsegundos(500);
        clic(byInputFechaEntrada);
        esperarxsegundos(1000);
        Helper.ubicarCalendario(this, mes, anio);
        esperarxsegundos(2000);
        clic(byFechaida);
        esperarxsegundos(2000);
        clic(byFechaVuelta);
        esperarxsegundos(1000);
    }

    public void agregarPersonas(int personas){
        for(int i=0; i<personas; i++){
            esperarxsegundos(1000);
            clic(esperarElementoWeb(byBtnAgregarPersonas));
        }
    }

    public void agregarHabitaciones(int habitacion){
        for(int i=0; i<habitacion; i++){
            esperarxsegundos(1000);
            clic(esperarElementoWeb(byBtnAgregarHabitaciones));
        }
    }

    public void presionarBuscar(){
        esperarxsegundos(1000);
        clic(esperarElementoWeb(byBtnBuscar));
    }

    public void filtroEstrellasHotel() {
        esperarxsegundos(10000); // Esperas un segundo
        clic(esperarElementoWeb(byPillStarsContainer));
        esperarxsegundos(1000); // Esperas un segundo
        clic(esperarElementoWeb(byPillStarsContainer2)); // Haces clic en el botón de elección de estrellas
        esperarxsegundos(1000); // Esperas un segundo
        clic(esperarElementoWeb(byBtnAplicarEstrellas)); // Haces clic en el botón de aplicar filtro de estrellas
    }

}