package Pages;

import Utils.BasePage;
import Utils.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    By byAceptarCookie = By.xpath("//button[contains(text(),\"Aceptar todo\")]");
    By byCmbOrigen = By.xpath("//input[@id=\":R9d96jalbldq2mm:\"]");
    By byCmbDestino = By.xpath("//input[@id=\":R9l96jalbldq2mm:\"]");
    By byBtnFechaida = By.xpath("(//button[contains(@aria-label, \"Fecha de ida\")])[1] ");
    By byFechaida = By.xpath("(//div[@class=\"d-iy1bge\"]/button[1])[1]");
    By byFechaVuelta = By.xpath("(//div[@class=\"d-iy1bge\"]/button[7])[1]");
    By byBtnNextMonth = By.xpath("//button[@aria-label=\"Next month\"]");
    By byAumentarAdultos=By.xpath("//button[contains(@aria-label,\"adultos\")][2]");
    By byClasePasajero = By.xpath("//button[contains(text(),\"Primera\")]");
    By bySigClasePasajero = By.xpath("//button[ @class=\"d-128ddiu\"]");
    By ByBtnBuscar = By.xpath("(//button[contains(@aria-label, \"Buscar\")])[1]");
    By byBtnMetodoPago=By.xpath("(//button[@class=\"d-1p45yi9\"])[1]");
    By byCheckAmerican= By.xpath("//li[contains(text(), \"American\")]//button");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void AceptarCookies() {
        esperarxsegundos(1000);
        clic(esperarElementoWeb(byAceptarCookie));
    }

    public void IngresarOrigen(String origen) {
        esperarxsegundos(2000);
        clic(byCmbOrigen);
        esperarxsegundos(2000);
        agregarTexto(byCmbOrigen, origen);
    }

    public void IngresarDestino(String destino) {
        esperarxsegundos(500);
        clic(byCmbDestino);
        esperarxsegundos(500);
        agregarTexto(byCmbDestino, destino);
    }

    public void SeleccionarFecha(int mes, int anio) {
        esperarxsegundos(1000);
        clic(byBtnFechaida);
        esperarxsegundos(2000);
        Helper.ubicarCalendario(this,mes, anio);
        esperarxsegundos(1000);
        clic(byFechaida);
        esperarxsegundos(50);
        clic(byFechaVuelta);
        esperarxsegundos(1000);
    }
    public void SeleccionarPasajeros(){
        esperarxsegundos(500);
        clic(esperarElementoWeb(byAumentarAdultos));
        esperarxsegundos(1000);
    }

    /*public void SeleccionarPasajerosPrimeraClase(){
        esperarxsegundos(500);
        clic(byAumentarAdultos);
        esperarxsegundos(1000);
        boolean clasePasajeroEncontrada = false;
            do {
                try {
                    // Intenta encontrar el elemento byClasePasajero
                    buscarElemento(byClasePasajero);
                    clasePasajeroEncontrada = true;
                } catch (NoSuchElementException e) {
                    clic(esperarElementoWeb(bySigClasePasajero));
                    esperarxsegundos(1000);
                }
            } while (!clasePasajeroEncontrada);


        clic(byClasePasajero);
        esperarxsegundos(1000);
    }*/
    public void SeleccionarPasajerosPrimeraClase(){
        esperarxsegundos(500);
        clic(byAumentarAdultos);
        esperarxsegundos(1000);
        clic(esperarElementoWeb(bySigClasePasajero));
        esperarxsegundos(1000);
        clic(esperarElementoWeb(bySigClasePasajero));
        esperarxsegundos(1000);
        clic(byClasePasajero);
        esperarxsegundos(1000);
    }

    public void SeleccionarMetodoPago(){
        esperarxsegundos(500);
        clic(byBtnMetodoPago);
        esperarxsegundos(500);
        clic(esperarElementoWeb(byCheckAmerican));

    }
    public void Buscar() {
        esperarxsegundos(1000);
        clic(esperarElementoWeb(ByBtnBuscar));
    }
}

