package Pages;

import Utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HdpCheckout extends BasePage {

    //Tarifa
    By byBtnElegirClassic = By.xpath("//button[contains(text(),'Elegir Classic')]");

    //Datos del contacto
    By byIngresarNameContacto = By.xpath("//input[@name='name']");
    By byIngresarSurnameContacto = By.xpath("//input[@name='surname']");
    By byIngresarEmailContacto = By.xpath("//input[@name='email']");
    By bySeleccionarPrefijoTelefono = By.xpath("//button[@data-testid='phone_isoCode']");
    By byIngresarPrefijoPais =By.xpath("//input[@aria-label='search-input']");
    By bySeleccionarPrefijoPais = By.xpath("//span[contains(text(),'Per')]");
    By byIngresarTelefono=By.xpath("//input[@name='phone']");

    //Datos de la dirección
    By byIngresarDireccion=By.xpath("//div[@data-testid='address']/label");
    By byIngresarNumeroCasa=By.xpath("//div[@data-testid='houseNumber']/label");
    By byIngresarCodigoPostal=By.xpath("//div[@data-testid='postCode']/label");
    By byIngresarCiudad=By.xpath("//div[@data-testid='city']/label");
    By byIngresarPais=By.xpath("//button[@data-testid='country']");
    By bySeleccionarPais = By.xpath("//span[contains(text(),'Per')]");

    //Datos 1er pasajero
    By byCheckSr = By.xpath("//input[@value='MALE' and contains(@name,'travellers.1')]");
    By byDayPrimerPasajero = By.xpath("//div[contains(@data-testid,'travellers.1.dateOfBirth_day')]/label");
    By byMonthPrimerPasajero = By.xpath("//button[contains(@data-testid,'travellers.1.dateOfBirth_month')]");
    By bySeleccionarMonth = By.xpath("//li[contains(@class,'sc-eldPxv')][12]");
    By byAnioPrimerPasajero = By.xpath("//div[contains(@data-testid,'travellers.1.dateOfBirth_year')]/label");

    //Datos del Documento del 1r pasajero
    By byDocumentoPrimerPasajero = By.xpath("//div[contains(@data-testid,'travellers.1.documentNumber')]/label");
    By byBtnPaisEmision = By.xpath("//button[contains(@data-testid,'travellers.1.documentIssueCountry')]");
    By byIngresarPaisEmision = By.xpath("//button[contains(@data-testid,'travellers.1.documentIssueCountry')]//input");
    By bySeleccionarPaisEmision =By.xpath("//span[@data-testid='select-group']//span[contains(text(),'Per')]");
    By byDayDocumentoEmisionPrimerPasajero= By.xpath("//div[contains(@data-testid,'travellers.1.documentIssueDate_day')]/label");
    By byBtnDocumentoEmisionMonthPrimerPasajero= By.xpath("//button[contains(@data-testid,'travellers.1.documentIssueDate_month')]");
    By bySeleccionarDocumentoEmisionMonthPrimerPasajero = By.xpath("//li[contains(@class,'sc-eldPxv')][12]");
    By byAnioDocumentoEmisionPrimerPasajero = By.xpath("//div[contains(@data-testid,'travellers.1.documentIssueDate_year')]/label");
    By byDayDocumentoExpiracionPrimerPasajero= By.xpath("//div[contains(@data-testid,'travellers.1.documentExpiryDate_day')]/label");
    By byBtnDocumentoExpiracionMonthPrimerPasajero= By.xpath("//button[contains(@data-testid,'travellers.1.documentExpiryDate_month')]");
    By bySeleccionarDocumentoExpiracionMonthPrimerPasajero = By.xpath("//li[contains(@class,'sc-eldPxv')][12]");
    By byAnioDocumentoExpiracionPrimerPasajero = By.xpath("//div[contains(@data-testid,'travellers.1.documentExpiryDate_year')]/label");

    //Datos 2DO pasajero
    By byCheckSra = By.xpath("//input[@value='FEMALE' and contains(@name,'travellers.2')]");
    By byNameSegundoPasajero = By.xpath("//input[contains(@name,'travellers.2.name')]");
    By bySurnameSegundoPasajero=By.xpath("//input[contains(@name,'travellers.2.surname')]");
    By byDaySegundoPasajero = By.xpath("//div[contains(@data-testid,'travellers.2.dateOfBirth_day')]/label");
    By byMonthSegundoPasajero = By.xpath("//button[contains(@data-testid,'travellers.2.dateOfBirth_month')]");
    By bySeleccionarMonthSegundoPasajero = By.xpath("//li[contains(@class,'sc-eldPxv')][12]");
    By byAnioSegundoPasajero = By.xpath("//div[contains(@data-testid,'travellers.2.dateOfBirth_year')]/label");

    //Datos del Documento del 2do pasajero
    By byDocumentoSegundoPasajero = By.xpath("//div[contains(@data-testid,'travellers.2.documentNumber')]/label");
    By byBtnPaisEmisionSegundoPasajero = By.xpath("//button[contains(@data-testid,'travellers.2.documentIssueCountry')]");
    By byIngresarPaisEmisionSegundoPasajero = By.xpath("//button[contains(@data-testid,'travellers.2.documentIssueCountry')]//input");
    By bySeleccionarPaisEmisionSegundoPasajero =By.xpath("//span[@data-testid='select-group']//span[contains(text(),'Per')]");
    By byDayDocumentoEmisionSegundoPasajero= By.xpath("//div[contains(@data-testid,'travellers.2.documentIssueDate_day')]/label");
    By byBtnDocumentoEmisionMonthSegundoPasajero= By.xpath("//button[contains(@data-testid,'travellers.2.documentIssueDate_month')]");
    By bySeleccionarDocumentoEmisionMonthSegundoPasajero = By.xpath("//li[contains(@class,'sc-eldPxv')][12]");
    By byAnioDocumentoEmisionSegundoPasajero = By.xpath("//div[contains(@data-testid,'travellers.2.documentIssueDate_year')]/label");
    By byDayDocumentoExpiracionSegundoPasajero= By.xpath("//div[contains(@data-testid,'travellers.2.documentExpiryDate_day')]/label");
    By byBtnDocumentoExpiracionMonthSegundoPasajero= By.xpath("//button[contains(@data-testid,'travellers.2.documentExpiryDate_month')]");
    By bySeleccionarDocumentoExpiracionMonthSegundoPasajero = By.xpath("//li[contains(@class,'sc-eldPxv')][12]");
    By byAnioDocumentoExpiracionSegundoPasajero = By.xpath("//div[contains(@data-testid,'travellers.2.documentExpiryDate_year')]/label");

    //Equipaje Facturado Primer Pasajero
    By byCheckSinEquipajePrimerPasajeroVI =By.xpath("(//div[@data-testid='traveller-container-1-1-1-ADT_1']//input[@data-testid='radio-input'])[1]");
    By byCheckSinEquipajePrimerPasajeroVV=By.xpath("(//div[@data-testid='traveller-container-1-1-2-ADT_2']//input[@data-testid='radio-input'])[1]");

    //Equipaje Facturado Segundo Pasajero
    By byCheckSinEquipajeSegundoPasajeroVI= By.xpath("(//div[@data-testid='traveller-container-1-2-1-ADT_1']//input[@data-testid='radio-input'])[1]");
    By byCheckSinEquipajeSegundoPasajeroVV = By.xpath("(//div[@data-testid='traveller-container-1-2-2-ADT_2']//input[@data-testid='radio-input'])[1]");

    //Boton Siguiente
    By byBtnSiguiente= By.xpath("//button[contains(text(),'Siguiente')]");

    //Coberturas
    By byBtnSinCoberturas = By.xpath("//div[@class='insurance__noThanks']//div[@class='radio']");

    //TarjetaBono o Descuento
    By bySeleccionarDescuento = By.xpath("//div[@class='form-elements-2']");
    By byIngresarDescuento = By.xpath("//input[@data-test='input-voucher']");
    By byBtnAplicar= By.xpath("//button[contains(text(),'Aplicar')]");

    //Campo Bono Caducado
    By byMensajeBonoCaducado = By.xpath("//label[contains(text(),'El bono ha caducado.')]");

    By byMensajeBonoInvalido =By.xpath("//label[contains(text(),'No hemos encontrado este ')]");
    
    public HdpCheckout(WebDriver driver) {
        super(driver);
    }

    public void seleccionarTarifa(){
        esperarxsegundos(1000);
        clic(esperarElementoWeb(byBtnElegirClassic));

    }

    public void ingresarDatosContacto(String name, String surname, String email,String prefijo, String telefono){
        esperarxsegundos(2000);
        clic(byIngresarNameContacto);
        esperarxsegundos(500);
        agregarTexto(byIngresarNameContacto,name);
        esperarxsegundos(500);
        clic(byIngresarSurnameContacto);
        esperarxsegundos(500);
        agregarTexto(byIngresarSurnameContacto,surname);
        esperarxsegundos(500);
        clic(byIngresarEmailContacto);
        esperarxsegundos(500);
        agregarTexto(byIngresarEmailContacto,email);
        esperarxsegundos(2000);
        clic(bySeleccionarPrefijoTelefono);
        esperarxsegundos(2000);
        agregarTexto(byIngresarPrefijoPais,prefijo);
        esperarxsegundos(2000);
        clic(bySeleccionarPrefijoPais);
        esperarxsegundos(500);
        clic(byIngresarTelefono);
        esperarxsegundos(500);
        agregarTexto(byIngresarTelefono,telefono);
    }
    public void ingresarDireccion(String direcPostal, String numeroCasa,String codigoPostal, String ciudad,String pais){
        esperarxsegundos(500);
        clic(byIngresarDireccion);
        esperarxsegundos(500);
        agregarTexto(byIngresarDireccion,direcPostal);
        esperarxsegundos(500);
        clic(byIngresarNumeroCasa);
        esperarxsegundos(500);
        agregarTexto(byIngresarNumeroCasa,numeroCasa);
        esperarxsegundos(500);
        clic(byIngresarCodigoPostal);
        esperarxsegundos(1000);
        agregarTexto(byIngresarCodigoPostal,codigoPostal);
        esperarxsegundos(1000);
        clic(byIngresarCiudad);
        esperarxsegundos(500);
        agregarTexto(byIngresarCiudad,ciudad);
        esperarxsegundos(500);
        clic(byIngresarPais);
        esperarxsegundos(1000);
        agregarTexto(byIngresarPais,pais);
        esperarxsegundos(1000);
        clic(bySeleccionarPais);
    }

    public void ingresarDatosPrimerPasajero(String day, String anio){
        esperarxsegundos(500);
        clic(byCheckSr);
        esperarxsegundos(500);
        clic(byDayPrimerPasajero);
        esperarxsegundos(500);
        agregarTexto(byDayPrimerPasajero,day);
        esperarxsegundos(500);
        clic(byMonthPrimerPasajero);
        esperarxsegundos(2000);
        clic(bySeleccionarMonth);
        esperarxsegundos(500);
        clic(byAnioPrimerPasajero);
        esperarxsegundos(500);
        agregarTexto(byAnioPrimerPasajero,anio);

    }
    public void ingresarNroDocumentoPrimerPasajero(String nrodocumento, String paisEmision, String dayEmisionDocumento, String anioEmisionDocumento,String dayExpiracionDocumento, String anioExpiracionDocumento){
        esperarxsegundos(500);
        clic(byDocumentoPrimerPasajero);
        esperarxsegundos(500);
        agregarTexto(byDocumentoPrimerPasajero,nrodocumento);
        esperarxsegundos(500);
        clic(byBtnPaisEmision);
        esperarxsegundos(2000);
        agregarTexto(byIngresarPaisEmision, paisEmision);
        esperarxsegundos(2000);
        clic(bySeleccionarPaisEmision);
        esperarxsegundos(600);
        clic(byDayDocumentoEmisionPrimerPasajero);
        esperarxsegundos(500);
        agregarTexto(byDayDocumentoEmisionPrimerPasajero,dayEmisionDocumento);
        esperarxsegundos(500);
        clic(byBtnDocumentoEmisionMonthPrimerPasajero);
        esperarxsegundos(500);
        clic(bySeleccionarDocumentoEmisionMonthPrimerPasajero);
        esperarxsegundos(500);
        clic(byAnioDocumentoEmisionPrimerPasajero);
        esperarxsegundos(500);
        agregarTexto(byAnioDocumentoEmisionPrimerPasajero,anioEmisionDocumento);
        esperarxsegundos(600);
        clic(byDayDocumentoExpiracionPrimerPasajero);
        esperarxsegundos(500);
        agregarTexto(byDayDocumentoExpiracionPrimerPasajero,dayExpiracionDocumento);
        esperarxsegundos(500);
        clic(byBtnDocumentoExpiracionMonthPrimerPasajero);
        esperarxsegundos(500);
        clic(bySeleccionarDocumentoExpiracionMonthPrimerPasajero);
        esperarxsegundos(500);
        clic(byAnioDocumentoExpiracionPrimerPasajero);
        esperarxsegundos(500);
        agregarTexto(byAnioDocumentoExpiracionPrimerPasajero,anioExpiracionDocumento);
    }
    public void ingresarDatosSegundoPasajero(String name, String surname,String day, String anio){
        esperarxsegundos(500);
        clic(byCheckSra);
        esperarxsegundos(500);
        clic(byNameSegundoPasajero);
        esperarxsegundos(500);
        agregarTexto(byNameSegundoPasajero,name);
        esperarxsegundos(500);
        clic(bySurnameSegundoPasajero);
        esperarxsegundos(500);
        agregarTexto(bySurnameSegundoPasajero,surname);
        esperarxsegundos(500);
        clic(byDaySegundoPasajero);
        esperarxsegundos(500);
        agregarTexto(byDaySegundoPasajero,day);
        esperarxsegundos(500);
        clic(byMonthSegundoPasajero);
        esperarxsegundos(2000);
        clic(bySeleccionarMonthSegundoPasajero);
        esperarxsegundos(500);
        clic(byAnioSegundoPasajero);
        esperarxsegundos(500);
        agregarTexto(byAnioSegundoPasajero,anio);

    }

    public void ingresarNroDocumentoSegundoPasajero(String nrodocumento, String paisEmision, String dayEmisionDocumento, String anioEmisionDocumento,String dayExpiracionDocumento, String anioExpiracionDocumento){
        esperarxsegundos(500);
        clic(byDocumentoSegundoPasajero);
        esperarxsegundos(500);
        agregarTexto(byDocumentoSegundoPasajero,nrodocumento);
        esperarxsegundos(500);
        clic(byBtnPaisEmisionSegundoPasajero);
        esperarxsegundos(2000);
        agregarTexto(byIngresarPaisEmisionSegundoPasajero, paisEmision);
        esperarxsegundos(2000);
        clic(bySeleccionarPaisEmisionSegundoPasajero);
        esperarxsegundos(600);
        clic(byDayDocumentoEmisionSegundoPasajero);
        esperarxsegundos(500);
        agregarTexto(byDayDocumentoEmisionSegundoPasajero,dayEmisionDocumento);
        esperarxsegundos(500);
        clic(byBtnDocumentoEmisionMonthSegundoPasajero);
        esperarxsegundos(500);
        clic(bySeleccionarDocumentoEmisionMonthSegundoPasajero);
        esperarxsegundos(500);
        clic(byAnioDocumentoEmisionSegundoPasajero);
        esperarxsegundos(500);
        agregarTexto(byAnioDocumentoEmisionSegundoPasajero,anioEmisionDocumento);
        esperarxsegundos(600);
        clic(byDayDocumentoExpiracionSegundoPasajero);
        esperarxsegundos(500);
        agregarTexto(byDayDocumentoExpiracionSegundoPasajero,dayExpiracionDocumento);
        esperarxsegundos(500);
        clic(byBtnDocumentoExpiracionMonthSegundoPasajero);
        esperarxsegundos(500);
        clic(bySeleccionarDocumentoExpiracionMonthSegundoPasajero);
        esperarxsegundos(500);
        clic(byAnioDocumentoExpiracionSegundoPasajero);
        esperarxsegundos(500);
        agregarTexto(byAnioDocumentoExpiracionSegundoPasajero,anioExpiracionDocumento);
    }
    public void reporteEquipajePrimerPasajero(){
        esperarxsegundos(1000);
        clic(byCheckSinEquipajePrimerPasajeroVI);
        esperarxsegundos(1000);
        clic(byCheckSinEquipajePrimerPasajeroVV);

    }

    public void reporteEquipajeSegundoPasajero(){
        esperarxsegundos(1000);
        clic(byCheckSinEquipajeSegundoPasajeroVI);
        esperarxsegundos(1000);
        clic(byCheckSinEquipajeSegundoPasajeroVV);
    }

    public void seleccionarSiguiente(){
        esperarxsegundos(1000);
        clic(byBtnSiguiente);
    }

    public void seleccionarSinCobertura(){
        esperarxsegundos(5000);
        clic(esperarElementoWeb(byBtnSinCoberturas));
    }

    public void ingresarDescuentoCaducado(String descuento){
        esperarxsegundos(1000);
        clic(esperarElementoWeb(bySeleccionarDescuento));
        esperarxsegundos(500);
        clic(byIngresarDescuento);
        esperarxsegundos(500);
        agregarTexto(byIngresarDescuento,descuento);
        esperarxsegundos(500);
        clic(byBtnAplicar);
    }

    public void ingresarDescuentoInvalido(String descuento){
        esperarxsegundos(1000);
        clic(esperarElementoWeb(bySeleccionarDescuento));
        esperarxsegundos(500);
        clic(byIngresarDescuento);
        esperarxsegundos(500);
        agregarTexto(byIngresarDescuento,descuento);
        esperarxsegundos(500);
        clic(byBtnAplicar);
    }

    public String mensajeAlertaBonoCaducado(){
        return (obtenerTexto(esperarElementoWeb(byMensajeBonoCaducado)));
    }
    public String mensajeAlertaBonoInvalido(){
        return (obtenerTexto(esperarElementoWeb(byMensajeBonoInvalido)));
    }
}
