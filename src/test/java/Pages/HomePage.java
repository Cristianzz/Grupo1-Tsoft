package Pages;

import Utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.util.Date;

public class HomePage extends BasePage {

    int tiempoEspera = 500;
    By byAceptarCookie = By.xpath("//button[contains(text(),\"Aceptar todo\")]");
    By byCmbOrigen = By.xpath("//input[@id=\":R9d96jalbldq2mm:\"]");
    By byCmbDestino = By.xpath("//input[@id=\":R9l96jalbldq2mm:\"]");
    By byBtnFechaida = By.xpath("(//button[contains(@aria-label, \"Fecha de ida\")])[1] ");
    By byMes = By.xpath("//span[@id=\"6-2024\"]");
    By byFechaida = By.xpath("(//div[@class=\"d-iy1bge\"]/button[1])[2]");
    By byFechaVuelta = By.xpath("(//div[@class=\"d-iy1bge\"]/button[7])[2]");
    By byBtnPrevMonth = By.xpath("//button[@aria-label=\"Previous  month\"]");
    By byBtnNextMonth = By.xpath("//button[@aria-label=\"Next month\"]");
    By byAumentarAdultos=By.xpath("//button[contains(@aria-label,\"adultos\")][2]");
    By byClasePasajero = By.xpath("//button[contains(text(),\"Primera\")]");
    By bySigClasePasajero = By.xpath("//button[ @class=\"d-128ddiu\"]");
    By ByBtnBuscar = By.xpath("(//button[contains(@aria-label, \"Buscar\")])[1]");
    By byBtnMetodoPago=By.xpath("(//button[@class=\"d-1p45yi9\"])[1]");
    By byCheckAmerican= By.xpath("//li[contains(text(), \"American\")]//button");
    By byTituloMesAnioIda = By.xpath("//div[@class=\"d-b1sfx4\"]/div[2]");
    By byTituloMesAnioVuelta = By.xpath("//div[@class=\"d-b1sfx4\"]/div[3]");
    By byCampoInvalidoDestino = By.xpath("//span[@class=\"d-18hlxxm\"]");


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

    /**
     * Método para aceptar las cookies
     */
    public void aceptarCookies() {
        esperarxsegundos(tiempoEspera);
        clic(esperarElementoWeb(byAceptarCookie));
    }

    /**
     * Método para ingresar el origen
     * @param origen Ciudad de origen
     */
    public void ingresarOrigen(String origen) {
        esperarxsegundos(tiempoEspera);
        clic(esperarElementoWeb(byCmbOrigen));
        esperarxsegundos(tiempoEspera);
        agregarTexto(byCmbOrigen, origen);
    }

    /**
     * Método para ingresar el destino
     * @param destino Ciudad de destino
     */
    public void ingresarDestino(String destino) {
        esperarxsegundos(tiempoEspera);
        clic(esperarElementoWeb(byCmbDestino));
        esperarxsegundos(tiempoEspera);
        agregarTexto(byCmbDestino, destino);
    }

    /**
     * Método para seleccionar la fecha de ida
     * @param dia dia de la fecha de ida
     * @param mes mes de la fecha de ida
     * @param anio año de la fecha de ida
     */
    public void seleccionFechaIda(int dia, int mes, int anio){
        esperarxsegundos(tiempoEspera);
        clic(esperarElementoWeb(byBtnFechaida));
        esperarxsegundos(tiempoEspera);
        ubicarFechaIda(mes, anio);
        // fecha dinámica depende de el día que se quiera seleccionar
        By fechaIda = By.xpath("(//div[@class=\"d-iy1bge\"]/button[" + dia + "])[1]");
        clic(esperarElementoWeb(fechaIda));
    }

    /**
     * Método para seleccionar la fecha de vuelta
     * @param dia dia de la fecha de vuelta
     * @param mes mes de la fecha de vuelta
     * @param anio año de la fecha de vuelta
     */
    public void seleccionFechaVuelta(int dia, int mes, int anio) {
        esperarxsegundos(tiempoEspera);
        ubicarFechaVuelta(dia, mes, anio);
        // fecha dinámica depende de el día que se quiera seleccionar
        By fechaVuelta = By.xpath("(//div[@class=\"d-iy1bge\"]/button[" + dia + "])[2]");
        clic(esperarElementoWeb(fechaVuelta));
    }

    /**
     * Método para seleccionar la cantidad de pasajeros adultos
     * @param adultos cantidad de adultos
     */
    public void seleccionarPasajerosAdultos(int adultos) {
        esperarxsegundos(tiempoEspera);
        for (int i = 0; i < adultos - 1; i++) {
            clic(esperarElementoWeb(byAumentarAdultos));
            esperarxsegundos(tiempoEspera);
        }
    }

    /**
     * Método para realizar la búsqueda
     */
    public void realizarBusqueda() {
        esperarxsegundos(tiempoEspera);
        clic(esperarElementoWeb(ByBtnBuscar));
    }

    public String textoCampoInvalidoDestino(){
        esperarxsegundos(tiempoEspera);
        return obtenerTexto(esperarElementoWeb(byCampoInvalidoDestino));
    }

    private void ubicarFechaIda(int mes, int anio) {
        String[] fechaSplit = buscarElemento(byTituloMesAnioIda).getAttribute("aria-labelledby").split("-");
        int mesActualIda = Integer.parseInt(fechaSplit[0]) + 1;
        int anioActualIda = Integer.parseInt(fechaSplit[1]);
        // Se mueve al año deseado
        int aniosDiferencia = anio - anioActualIda;
        int mesIdaIteracion = mesActualIda;
        for (int i = 0; i < aniosDiferencia; i++) {
            int restante = 12 - mesIdaIteracion + 1;
            for (int j = 0; j < restante; j++) {
                clic(esperarElementoWeb(byBtnNextMonth));
                esperarxsegundos(tiempoEspera);
            }
            mesIdaIteracion = 1;
        }

        // Se mueve al mes deseado
        int mesDiferencia = mes - mesIdaIteracion;
        for (int i = 0; i < mesDiferencia; i++) {
            clic(esperarElementoWeb(byBtnNextMonth));
            esperarxsegundos(tiempoEspera);
        }
    }

    private void ubicarFechaVuelta(int dia, int mes, int anio) {
        String[] fechaSplit = buscarElemento(byTituloMesAnioVuelta).getAttribute("aria-labelledby").split("-");
        int mesActualVuelta = Integer.parseInt(fechaSplit[0]) + 1;
        int anioActualVuelta = Integer.parseInt(fechaSplit[1]);
        // Se mueve al año deseado
        int aniosDiferencia = anio - anioActualVuelta;
        int mesVueltaIteracion = mesActualVuelta;
        for (int i = 0; i < aniosDiferencia; i++) {
            int restante = 12 - mesVueltaIteracion + 1;
            for (int j = 0; j < restante; j++) {
                clic(byBtnNextMonth);
                esperarxsegundos(tiempoEspera);
            }
            mesVueltaIteracion = 1;
        }

        // Se mueve al mes deseado
        int mesDiferencia = mes - mesVueltaIteracion;
        for (int i = 0; i < mesDiferencia; i++) {
            clic(byBtnNextMonth);
            esperarxsegundos(tiempoEspera);
        }
    }

    public void SeleccionarFecha() {
        esperarxsegundos(500);
        clic(byBtnFechaida);
        esperarxsegundos(1000);
        boolean mesEncontrado = false;

        do {
            try {
                // Intentar buscar el elemento byMes
                buscarElemento(byMes);
                mesEncontrado = true; // Si se encuentra el elemento, salir del bucle
            } catch (NoSuchElementException e) {
                // Si no se encuentra el elemento, hacer clic en el botón "Next Month"
                clic(byBtnNextMonth);
                esperarxsegundos(500);
            }
        } while (!mesEncontrado);
        esperarxsegundos(2000);
        clic(byFechaida);
        esperarxsegundos(2000);
        clic(byFechaVuelta);
        esperarxsegundos(1000);
    }
    public void SeleccionarPasajeros(){
        esperarxsegundos(500);
        clic(esperarElementoWeb(byAumentarAdultos));
        esperarxsegundos(3000);
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
