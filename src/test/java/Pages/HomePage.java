package Pages;

import Utils.BasePage;
import Utils.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    By byAceptarCookie = By.xpath("//button[contains(text(),\"Aceptar todo\")]");
    By byCmbOrigen = By.xpath("//input[@id=\":R9d96jalbldq2mm:\"]");
    By byCmbDestino = By.xpath("//input[@id=\":R9l96jalbldq2mm:\"]");
    By byMes = By.xpath("//span[@id=\"6-2024\"]");
    By byBtnPrevMonth = By.xpath("//button[@aria-label=\"Previous  month\"]");
    By byBtnNextMonth = By.xpath("//button[@aria-label=\"Next month\"]");
    By byClasePasajero = By.xpath("//button[contains(text(),\"Primera\")]");
    By bySigClasePasajero = By.xpath("//button[ @class=\"d-128ddiu\"]");
    By ByBtnBuscar = By.xpath("(//button[contains(@aria-label, \"Buscar\")])[1]");
    By byBtnMetodoPago = By.xpath("(//button[@class=\"d-1p45yi9\"])[1]");
    By byCheckAmerican = By.xpath("//li[contains(text(), \"American\")]//button");

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

    By byMenuTrenes = By.xpath("//a[@href='https://www.rumbo.es/trenes/']");



    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void AceptarCookies() {
        esperarxsegundos(5000);
        clic(esperarElementoWeb(byAceptarCookie));
    }
    public void irAPaginaHoteles() {
        clic(esperarElementoWeb(byMenuHoteles));
    }

    public void irAPaginaTrenes() {
        clic(esperarElementoWeb(byMenuTrenes));
    }
    /*----------------------------------------------------*/
}

