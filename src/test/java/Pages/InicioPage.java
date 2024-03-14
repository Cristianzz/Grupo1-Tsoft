package Pages;

import Utils.BasePage;
import Utils.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InicioPage extends BasePage {

    private final By byAceptarCookie = By.xpath("//button[contains(text(),'Aceptar todo')]");
    private final By byInputOrigen = By.xpath("//label[contains(text(),'Origen')]/following-sibling::*/input");
    private final By byInputDestino = By.xpath("//label[contains(text(),'Destino')]/following-sibling::*/input");
    private final By byInputFechaIda = By.xpath("//label[contains(text(),'ida')]/following-sibling::*");
    private final By byBtnBuscar = By.xpath("//button[@aria-label='Buscar']");
    private final By byBtnHoteles = By.xpath("//a[@title='Hoteles']");
    private final By byCampoInvalido= By.xpath("//span[@role='alert']");


    public InicioPage(WebDriver driver) {
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
        Helper.ubicarCalendario(this, mes, anio);
        By fechaVuelta= By.xpath("(//span[@id='"+(mes-1)+"-"+anio+"']/following-sibling::*/button[text()='"+dia+"'])");
        clic(esperarElementoWeb(fechaVuelta));
    }

    public void agregarPasajeros(int pasajeros){
        for(int i=0; i<pasajeros; i++){
            esperarxsegundos(1000);
            clic(esperarElementoWeb(By.xpath("//button[contains(@aria-label,'adultos')][2]")));
        }
    }

    public void presionarBuscar(){
        esperarxsegundos(1000);
        clic(esperarElementoWeb(byBtnBuscar));
    }

    public void irHoteles() {
        esperarxsegundos(this.getTiempoEspera());
        clic(esperarElementoWeb(byBtnHoteles));
    }

    public String obtenerCampoInvalido() {
        esperarxsegundos(1000);
        return obtenerTexto(esperarElementoWeb(byCampoInvalido));
    }
}
