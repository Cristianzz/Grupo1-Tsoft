package Pages;

import Utils.BasePage;
import Utils.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class Trenes extends BasePage {
    By byVermas = By.xpath("(//div[@class=\"TopBarMenuListItemstyled__MenuItem-sc-hzwcuj-6 kgnpkG\"])[4]");
    By byOpcionTrenes = By.xpath("//a[@title=\"Trenes\"]");
    By byCmbOrigen = By.xpath("//*[@id=\"hub-csw-container\"]/div/div/form/div[2]/div[1]/fieldset/div[1]");
    By byCmbDestino = By.xpath("//input[@id=\":R9l96jalbldq2mm:\"]");
    By byCmbOrigentextt = By.xpath("  //*[@id=\":Rb8qjalamt2mm:\"]");
    By byCmbDestinotextt = By.xpath("  //*[@id=\":Rd8qjalamt2mm:\"]");
    /*----fechas-----*/
    By byBtnFechaida = By.xpath("(//button[contains(@aria-label, 'Fecha de ida')])[1]");
    By byFechaida = By.xpath("(//button[contains(@aria-label, 'Fecha de ida')])[1]");
    By byFechaVuelta = By.xpath("(//button[contains(@aria-label, 'Fecha de vuelta')])[1]");
    By ByBtnBuscar = By.xpath("(//button[contains(@aria-label, \"Buscar\")])[1]");

    /*----seleccionar personas-----*/
    public Trenes(WebDriver driver) {
        super(driver);
    }
    public void Vermas() {
        esperarxsegundos(2000);
        moverCursorSobreElemento(byVermas);
        esperarxsegundos(2000);
        clic(esperarElementoWeb(byOpcionTrenes));
    }
    public void IngresarOrigen(String origen) {
        esperarxsegundos(2000);
        clic(byCmbOrigentextt);
        esperarxsegundos(2000);
        agregarTexto(byCmbOrigentextt, origen);
    }
    public void IngresarDestino(String origen) {
        esperarxsegundos(2000);
        clic(byCmbDestinotextt);
        esperarxsegundos(2000);
        agregarTexto(byCmbDestinotextt, origen);
    }
    public void SeleccionarFechaTrenes(int mes, int anio) {
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

    public void BuscardorTrenes() {
        esperarxsegundos(1000);
        clic(esperarElementoWeb(ByBtnBuscar));
    }
}
