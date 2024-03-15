package Pages;

import Utils.BasePage;
import Utils.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private final By byAceptarCookie = By.xpath("//button[contains(text(),'Aceptar todo')]");
    private final By byClasePasajero = By.xpath("//button[contains(text(),'Primera')]");
    private final By bySigClasePasajero = By.xpath("//button[ @class='d-128ddiu']");
    private final By byBtnMetodoPago=By.xpath("(//button[@class='d-1p45yi9'])[1]");
    private final By byCheckAmerican= By.xpath("//li[contains(text(), 'American')]//button");
    private final By byInputOrigen = By.xpath("//label[contains(text(),'Origen')]/following-sibling::*/input");
    private final By byInputDestino = By.xpath("//label[contains(text(),'Destino')]/following-sibling::*/input");
    private final By byInputFechaIda = By.xpath("//label[contains(text(),'ida')]/following-sibling::*");
    private final By byFechaida = By.xpath("(//div[@class='d-iy1bge']/button[1])[1]");
    private final By byFechaVuelta = By.xpath("(//div[@class='d-iy1bge']/button[7])[1]");
    private final By byBtnBuscar = By.xpath("//button[@aria-label='Buscar']");
    private final By byBtnHoteles = By.xpath("//a[@title='Hoteles']");
    private final By byBtnAgregarPasajeros = By.xpath("//button[contains(@aria-label,'adultos')][2]");
    private final By byCampoInvalido= By.xpath("//span[@role='alert']");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void aceptarCookies() {
        esperarxsegundos(1000);
        clic(esperarElementoWeb(byAceptarCookie));
    }

    public void ingresarOrigen(String origen) {
        esperarxsegundos(1000);
        clic(esperarElementoWeb(byInputOrigen));
        esperarxsegundos(1000);
        agregarTexto(byInputOrigen, origen);
    }

    public void ingresarDestino(String destino) {
        esperarxsegundos(1000);
        clic(esperarElementoWeb(byInputDestino));
        esperarxsegundos(1000);
        agregarTexto(byInputDestino, destino);
    }

    public void seleccionarFecha(int mes, int anio) {
        esperarxsegundos(1000);
        clic(byInputFechaIda);
        esperarxsegundos(2000);
        Helper.ubicarCalendario(this,mes, anio);
        esperarxsegundos(1000);
        clic(byFechaida);
        esperarxsegundos(50);
        clic(byFechaVuelta);
        esperarxsegundos(1000);
    }

    public void agregarPasajeros(int pasajeros){
        for(int i=0; i<pasajeros; i++){
            esperarxsegundos(1000);
            clic(esperarElementoWeb(byBtnAgregarPasajeros));
        }
    }

    public void seleccionarPrimerClase(){
        esperarxsegundos(1000);
        clic(esperarElementoWeb(bySigClasePasajero));
        esperarxsegundos(1000);
        clic(esperarElementoWeb(bySigClasePasajero));
        esperarxsegundos(1000);
        clic(byClasePasajero);
        esperarxsegundos(1000);
    }

    public void seleccionarMetodoPago(){
        esperarxsegundos(500);
        clic(byBtnMetodoPago);
        esperarxsegundos(500);
        clic(esperarElementoWeb(byCheckAmerican));
    }


    public void presionarBuscar(){
        esperarxsegundos(1000);
        clic(esperarElementoWeb(byBtnBuscar));
    }

    public String obtenerCampoInvalido() {
        esperarxsegundos(1000);
        return obtenerTexto(esperarElementoWeb(byCampoInvalido));
    }

    public void irHoteles() {
        esperarxsegundos(2000);
        clic(esperarElementoWeb(byBtnHoteles));
    }

}