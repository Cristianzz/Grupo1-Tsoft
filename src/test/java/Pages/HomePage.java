package Pages;

import Utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    By byCmbOrigen = By.xpath("//input[@id=\":R9d96jalbldq2mm:\"]");
    By byCmbDestino = By.xpath("//input[@id=\":R9l96jalbldq2mm:\"]");

    By byBtnFechaida= By.xpath("(//button[contains(@aria-label, \"Fecha de ida\")])[1] ");

    By ByFechaida=By.xpath("//button[contains(text(), \"13\")]");

    By ByFechaVuelta = By.xpath("//button[contains(text(), \"20\")]");

    By ByBtnPasajero= By.xpath("//button[span[contains(text(), \"pasajero\")]]");
    By ByBtnBuscar= By.xpath("(//button[contains(@aria-label, \"Buscar\")])[1]");
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void IngresarOrigen(String origen){
        esperarxsegundos(500);
        clic(esperarElementoWeb(byCmbOrigen));
        esperarxsegundos(500);
        agregarTexto(esperarElementoWeb(byCmbOrigen),origen);
    }

    public void IngresarDestino(String destino){
        esperarxsegundos(500);
        clic(esperarElementoWeb(byCmbDestino));
        esperarxsegundos(500);
        agregarTexto(esperarElementoWeb(byCmbDestino),destino);
    }
}
