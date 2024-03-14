package Pages;

import Utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Checkout extends BasePage {
    By byTarifaTren = By. xpath("(//button[@data-testid=\"lmn-ds-btn\"])[2]");
    By byIngresarNameContacto = By.xpath("//input[@name=\"name\"]");
    By byIngresarSurnameContacto = By.xpath("//input[@name=\"surname\"]");
    By byIngresarEmailContacto = By.xpath("//input[@name=\"email\"]");
    By bySeleccionarPrefijo = By.xpath("//button[@data-testid=\"phone_isoCode\"]");
    By bySeleccionarPrefijoPais = By.xpath("//span[contains(text(), 'Italia')]");
    By byIngresarTelefono=By.xpath("//input[@name=\"phone\"]");
    By byIngresarDireccion=By.xpath("//input[@name=\"address\"]");
    By byIngresarCodigoPostal=By.xpath("//input[@name=\"postCode\"]");
    By byIngresarCiudad=By.xpath("//button[@data-testid=\"country\"]");
    By byCheck = By.xpath("//input[@value='MALE']");
    By byIngresarDiaPasajero = By.xpath("(//input[contains(@name, 'dateOfBirth')])[1]");
    By byIngresarAnioPasajero = By.xpath("(//input[contains(@name, 'dateOfBirth')])[2]");
    By byBtnMesPasajero = By.xpath("//button[contains(@data-testid, 'dateOfBirth')]");
    By byIngresarMesPasajero = By.xpath("//span[contains(text(), 'julio')]");
    By byBtnDocumentoPasajero = By.xpath("//button[contains(@data-testid, 'documentType')]");
    By byIngresarDocumentoPasajero = By.xpath(" //span[contains(text(), 'Pasaporte')]");
    By byIngresarNumeroDocumento = By.xpath(" //input[contains(@name, 'documentNumber')]");
    By byCobertura = By.xpath("(//div[@class='insurance__expandable-container'])[1]");
    By byAsistenciaEspcial = By.xpath("//div[contains(@class, 'special-requests-structured__fieldset-wrapper')]");
    By byBtnTipoSolicitud = By.xpath("//select[@name='REQUEST_TYPE']");
    By byMovilidadReducida = By.xpath("//option[@value='REDUCED_MOBILITY']");
    By bySolicitudGeneral = By.xpath("//option[@value='NOTE']");
    By byBtnTipoAsistencia = By.id("special-requests-structured-requirements_1");
    By byTipoAsistencia = By.xpath("//option[@value='WCHR']");


    public Checkout(WebDriver driver) {super(driver);}

    public void SeleccionarTarifaTren(){
        esperarxsegundos(15000);
        clic(esperarElementoWeb(byTarifaTren));
    }

    public void DatosContacto(String name, String surname, String email/*,String prefijo*/, String telefono ){
        esperarxsegundos(3000);
        clic(agregarTexto(byIngresarNameContacto,name));
        esperarxsegundos(1000);
       clic(agregarTexto(byIngresarSurnameContacto,surname));
        esperarxsegundos(1000);
        clic(agregarTexto(byIngresarEmailContacto, email));
        esperarxsegundos(1000);
        clic(esperarElementoWeb(bySeleccionarPrefijo));
        esperarxsegundos(1000);
        clic(bySeleccionarPrefijoPais);
        esperarxsegundos(1000);
        agregarTexto(byIngresarTelefono, telefono);
    }

    public void DatosPasajero(String dia, String anio, String documento){
        esperarxsegundos(1000);
        scrollDownHalfPage();
        esperarxsegundos(1000);
        clic(byCheck);
        esperarxsegundos(1500);
        clic(agregarTexto(byIngresarDiaPasajero, dia));
        esperarxsegundos(1000);
        clic(byBtnMesPasajero);
        esperarxsegundos(500);
        clic(byIngresarMesPasajero);
        esperarxsegundos(1000);
        clic(agregarTexto(byIngresarAnioPasajero, anio));
        esperarxsegundos(1000);
        clic(byBtnDocumentoPasajero);
        esperarxsegundos(1000);
        clic(byIngresarDocumentoPasajero);
        esperarxsegundos(1000);
        clic(agregarTexto(byIngresarNumeroDocumento, documento));
        esperarxsegundos(1500);

    }
    public void CoberturasAdicionales(){
        scrollDownFullPage();
        esperarxsegundos(1000);
        clic(byCobertura);
    }

    public void AsistenciaEspecial(){
        esperarxsegundos(1000);
        clic(byAsistenciaEspcial);
        esperarxsegundos(1000);
        clic(byBtnTipoSolicitud);
        esperarxsegundos(1000);
        clic(byMovilidadReducida);
        esperarxsegundos(1000);
        clic(byBtnTipoAsistencia);
        esperarxsegundos(1000);
        clic(byTipoAsistencia);
    }







}
