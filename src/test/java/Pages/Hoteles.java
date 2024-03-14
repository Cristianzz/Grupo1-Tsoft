package Pages;

import Utils.BasePage;
import Utils.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Hoteles extends BasePage {

    /*------------------------------- diegon----------------------------*/
    By byMenuHoteles = By.xpath("//a[@href='https://www.rumbo.es/hoteles/']");
    By byCmbLugarAlojamiento = By.xpath("//input[@id=\":R4sd9lalamt2mm:\"]");

    /*----fechas-----*/
    By byBtnFechaida = By.xpath("(//button[contains(@aria-label, 'Fecha de entrada')])[1]");
    By byFechaida = By.xpath("(//button[contains(@aria-label, 'Fecha de entrada')])[1]");
    By byFechaVuelta = By.xpath("(//button[contains(@aria-label, 'Fecha de salida')])[1]");
    /*----seleccionar personas-----*/
    By bySeleccionarPersonas = By.xpath("//*[@id='hub-csw-container']//div[@class='d-1pftzfn']");
    By byAumentarAdultos = By.xpath("//button[contains(@aria-label,\"adultos\")][2]");
    By byPillStarsContainer = By.xpath("//*[@id='Pill-StarsContainer']");
    By byPillStarsContainer2 = By.id("exp_elem_hotel_stars_3");
    By byBtnAplicarEstrellas= By.xpath("//button[contains(text(),\"Aplicar\")]");

    By ByBtnBuscar = By.xpath("(//button[contains(@aria-label, \"Buscar\")])[1]");

    public Hoteles(WebDriver driver) {
        super(driver);
    }
    public void IngresarLugarAlojamiento(String origen) {
        esperarxsegundos(2000);
        clic(byCmbLugarAlojamiento);
        esperarxsegundos(2000);
        agregarTexto(byCmbLugarAlojamiento, origen);
    }

    public void SeleccionarFecha(int mes, int anio) {
        esperarxsegundos(500);
        clic(byBtnFechaida);
        esperarxsegundos(1000);
        Helper.ubicarCalendario(this, mes, anio);
        esperarxsegundos(2000);
        clic(byFechaida);
        esperarxsegundos(2000);
        clic(byFechaVuelta);
        esperarxsegundos(1000);
    }
    public void SeleccionarPasajeros() {
        esperarxsegundos(500);
        clic(esperarElementoWeb(bySeleccionarPersonas));
        esperarxsegundos(1000);

        WebElement botonAgregar = esperarElementoWeb(byAumentarAdultos);

        int intentos = 0;
        while (intentos < 2) {
            clic(botonAgregar);
            esperarxsegundos(100); // Espera a que se realice la acción
            intentos++;
        }
    }
    public void Buscar() {
        esperarxsegundos(1000);
        clic(esperarElementoWeb(ByBtnBuscar));
    }
    public void FiltroEstrellasHotel() {
        esperarxsegundos(4000); // Esperas un segundo
        clic(esperarElementoWeb(byPillStarsContainer));
        esperarxsegundos(1000); // Esperas un segundo
        clic(esperarElementoWeb(byPillStarsContainer2)); // Haces clic en el botón de elección de estrellas
        esperarxsegundos(1000); // Esperas un segundo
        clic(esperarElementoWeb(byBtnAplicarEstrellas)); // Haces clic en el botón de aplicar filtro de estrellas
    }
}
