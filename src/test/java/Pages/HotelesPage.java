package Pages;

import Utils.BasePage;
import Utils.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HotelesPage extends BasePage {

    private final By byInputUbicacion = By.xpath("//input[contains(@aria-label, 'alojamiento')]");
    private final By byInputFechaEntrada = By.xpath("//button[@aria-label='Fecha de entrada']");
    private final By byBtnPersonas = By.xpath("//label[contains(text(), 'Personas')]/following-sibling::*");

    public HotelesPage(WebDriver driver) {
        super(driver);
    }

    public void seleccionarDestino(String destino) {
        esperarxsegundos(1000);
        agregarTexto(esperarElementoWeb(byInputUbicacion), destino);
    }

    public void seleccionarFechaEntrada(int dia, int mes, int anio) {
        esperarxsegundos(1000);
        clic(esperarElementoWeb(byInputFechaEntrada));
        esperarxsegundos(1000);
        Helper.ubicarCalendario(this, mes, anio);
        By fechaIda = By.xpath("//span[@id='" + (mes-1) + "-" + anio + "']/following-sibling::div/button[contains(text(), '" + dia + "')]");
        clic(esperarElementoWeb(fechaIda));
    }

    public void seleccionarFechaSalida(int dia, int mes, int anio) {
        esperarxsegundos(1000);
        By fechaSalida = By.xpath("//span[@id='" + (mes-1) + "-" + anio + "']/following-sibling::div/button[contains(text(), '" + dia + "')]");
        clic(esperarElementoWeb(fechaSalida));
    }

    public void agregarPersonas(int personas){
        for(int i=0; i<personas; i++){
            esperarxsegundos(1000);
            clic(esperarElementoWeb(By.xpath("//button[contains(@aria-label,'adultos')][2]")));
        }
    }

    public void agregarHabitaciones(int habitacion){
        for(int i=0; i<habitacion; i++){
            esperarxsegundos(1000);
            clic(esperarElementoWeb(By.xpath("//button[contains(text(),'habitaci')]")));
        }
    }

    public void presionarBuscar(){
        esperarxsegundos(1000);
        clic(esperarElementoWeb(By.xpath("//button[@aria-label='Buscar']")));
    }

}
