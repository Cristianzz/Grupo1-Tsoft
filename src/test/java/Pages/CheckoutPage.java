package Pages;

import Utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    //Datos del contacto
    By byIngresarNombre = By.xpath("//input[@name='name']");
    By byIngresarApellido = By.xpath("//input[@name='surname']");
    By byIngresarCorreo = By.xpath("//input[@name='email']");
    By bySeleccionarPrefijoTelefono = By.xpath("//button[@data-testid='phone_isoCode']");
    By byIngresarPrefijoPais =By.xpath("//input[@aria-label='search-input']");
    By bySeleccionarPrefijoPais = By.xpath("//span[contains(text(),'Per')]");
    By byIngresarTelefono=By.xpath("//input[@name='phone']");
    By bySeguroCancelacion = By.xpath("//div[@class='insurance__expandable-upper-box']");
    By byCampoInvalido = By.xpath("//span[@data-testid='input-helper-text']");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void ingresarDatosContacto(String nombre, String apellido, String correo, String prefijo, String telefono) {
        esperarxsegundos(10000);
        agregarTexto(byIngresarNombre, nombre);
        esperarxsegundos(1000);
        agregarTexto(byIngresarApellido, apellido);
        esperarxsegundos(1000);
        agregarTexto(byIngresarCorreo, correo);
        esperarxsegundos(1000);
        clic(bySeleccionarPrefijoTelefono);
        esperarxsegundos(1000);
        agregarTexto(byIngresarPrefijoPais, prefijo);
        esperarxsegundos(1000);
        clic(bySeleccionarPrefijoPais);
        esperarxsegundos(1000);
        agregarTexto(byIngresarTelefono, telefono);
    }

    public void seleccionarSeguroCancelacion() {
        esperarxsegundos(1000);
        clic(esperarElementoWeb(bySeguroCancelacion));
    }

    public void ingresarTarjeta(String tarjeta, int cvv) {
        esperarxsegundos(1000);
        agregarTexto(By.xpath("//input[@name='creditCard.cardNumber']"), tarjeta);
        esperarxsegundos(1000);
        agregarTexto(By.xpath("//input[@name='creditCard.cvv']"), String.valueOf(cvv));
    }

    public String obtenerCampoInvalido() {
        esperarxsegundos(1000);
        return obtenerTexto(esperarElementoWeb(byCampoInvalido));
    }

}
