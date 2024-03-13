package Pages;

import Utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    By byAceptarCookie= By.xpath("//button[contains(text(),\"Aceptar todo\")]");
    By byCmbOrigen = By.xpath("//input[@id=\":R9d96jalbldq2mm:\"]");
    By byCmbDestino = By.xpath("//input[@id=\":R9l96jalbldq2mm:\"]");

    By byBtnFechaida= By.xpath("(//button[contains(@aria-label, \"Fecha de ida\")])[1] ");
    By byMes=By.xpath("//span[@id=\"2-2024\"]");
    By byFechaida=By.xpath("(//div[@class=\"d-iy1bge\"]/button[1])[2]");

    By byFechaVuelta = By.xpath("(//div[@class=\"d-iy1bge\"]/button[7])[2]");

    By byBtnPasajero= By.xpath("//button[span[contains(text(), \"pasajero\")]]");
    By ByBtnBuscar= By.xpath("(//button[contains(@aria-label, \"Buscar\")])[1]");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void AceptarCookies(){
        esperarxsegundos(1000);
        clic(esperarElementoWeb(byAceptarCookie));
    }
    public void IngresarOrigen(String origen){
        esperarxsegundos(2000);
        clic(byCmbOrigen);
        esperarxsegundos(2000);
        agregarTexto(byCmbOrigen,origen);
    }

    public void IngresarDestino(String destino){
        esperarxsegundos(2000);
        clic(byCmbDestino);
        esperarxsegundos(2000);
        agregarTexto(byCmbDestino,destino);
    }

    public void SeleccionarFecha(){
        esperarxsegundos(500);
        clic(byBtnFechaida);
        clic(esperarElementoWeb(byMes));
        clic(byFechaida);
        esperarxsegundos(2000);
        clic(byFechaVuelta);
    }
    public void Buscar(){
        esperarxsegundos(1000);
        clic(esperarElementoWeb(ByBtnBuscar));
    }



}
