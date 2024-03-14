package Pages;

import Utils.BasePage;
import Utils.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    By byAceptarCookie = By.xpath("//button[contains(text(),'Aceptar todo')]");
    By byClasePasajero = By.xpath("//button[contains(text(),'Primera')]");
    By bySigClasePasajero = By.xpath("//button[ @class='d-128ddiu']"); // buscar mejor xpath
    By byBtnMetodoPago=By.xpath("(//button[@class='d-1p45yi9'])[1]"); // buscar mejor xpath
    By byCheckAmerican= By.xpath("//li[contains(text(), 'American')]//button");
    By byInputOrigen = By.xpath("//label[contains(text(),'Origen')]/following-sibling::*/input");
    By byInputDestino = By.xpath("//label[contains(text(),'Destino')]/following-sibling::*/input");
    By byInputFechaIda = By.xpath("//label[contains(text(),'ida')]/following-sibling::*");
    By byBtnBuscar = By.xpath("//button[@aria-label='Buscar']");
    By byBtnHoteles = By.xpath("//a[@title='Hoteles']");
    By byBtnAgregarPasajeros = By.xpath("//button[contains(@aria-label,'adultos')][2]");
    By byCampoInvalido= By.xpath("//span[@role='alert']");


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

    public void seleccionarFechaIda(int dia, int mes, int anio){
        esperarxsegundos(1000);
        clic(esperarElementoWeb(byInputFechaIda));
        esperarxsegundos(1000);
        Helper.ubicarCalendario(this, mes, anio);
        esperarxsegundos(1000);
        By fechaIda= By.xpath("(//span[@id='"+(mes-1)+"-"+anio+"']/following-sibling::*/button[text()='"+dia+"'])");
        clic(esperarElementoWeb(fechaIda));
    }

    public void seleccionarFechaVuelta(int dia, int mes, int anio){
        esperarxsegundos(1000);
        By fechaVuelta= By.xpath("(//span[@id='"+(mes-1)+"-"+anio+"']/following-sibling::*/button[text()='"+dia+"'])");
        clic(esperarElementoWeb(fechaVuelta));
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