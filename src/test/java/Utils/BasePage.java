package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class BasePage {
    String ventanaPrincipal;
    //Wrapper de Selenium
    private WebDriver driver;
    private WebDriverWait espera;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.ventanaPrincipal  = driver.getWindowHandle();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriverWait getEspera() {
        return espera;
    }

    public void setEspera(WebDriverWait espera) {
        this.espera = espera;
    }

    //Métodos de la libreria de Selenium
    public WebElement buscarElemento(By localizador){
        return driver.findElement(localizador);
    }

    public void clic(By localizador){
        driver.findElement(localizador).click();
    }

    public void clic(WebElement elemento){
        elemento.click();
    }

    public void esperarxsegundos(int milisegundo){
        try {
            Thread.sleep(milisegundo);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public WebElement esperarElementoWeb(By localizador){
        espera = new WebDriverWait(this.driver,30);
        return espera.until(ExpectedConditions.presenceOfElementLocated(localizador));
    }

    public WebElement esperarElementoWebVisible(By localizador){
        espera = new WebDriverWait(this.driver,30);
        return espera.until(ExpectedConditions.visibilityOfElementLocated(localizador));
    }

    public void cargarSitio(String url){
        driver.get(url);
    }

    public void cerrarBrowser(){
        driver.quit();
    }

    public void agregarTexto(By localizador, String texto){
        driver.findElement(localizador).sendKeys(texto);
    }
    public void agregarTexto(WebElement elemento, String texto){
        elemento.sendKeys(texto);
    }
    public void maximizar(){
        driver.manage().window().maximize();
    }
    public String obtenerTexto(WebElement elemento){
        return elemento.getText();
    }
    public String obtenerTexto(By localizador){
        return driver.findElement(localizador).getText();
    }
    public String obtenerAtributo(WebElement elemento, String atributo){
        return elemento.getAttribute(atributo);
    }
    public boolean estaDesplegado(WebElement elemento){
        return elemento.isDisplayed();
    }
    public void seleccionarCmbPorValue(WebElement elemento, String value){
        Select selector = new Select(elemento);
        selector.selectByValue(value);
    }

    public void moverCursorSobreElemento(By localizador) {
        WebElement elemento = driver.findElement(localizador);
        Actions acciones = new Actions(driver);
        acciones.moveToElement(elemento).perform();
    }

    public void scrollDownHalfPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Long windowHeight = (Long) js.executeScript("return window.innerHeight");
        Long documentHeight = (Long) js.executeScript("return document.body.scrollHeight");
        Long scrollHeight = documentHeight / 2 - windowHeight / 2;
        js.executeScript("window.scrollTo(0, " + scrollHeight + ")");
    }

    public void scrollDownFullPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void controlarSlider(By localizadorSlider, double posicionDeseada) {
        WebElement slider = driver.findElement(localizadorSlider);

        // Obtener el ancho del slider
        int sliderWidth = slider.getSize().getWidth();

        // Calcular la posición a la que se quiere deslizar el slider
        int xOffset = (int) (sliderWidth * posicionDeseada);

        // Crear una instancia de Actions
        Actions acciones = new Actions(driver);

        // Realizar el arrastre y soltar hasta la posición deseada
        acciones.clickAndHold(slider).moveByOffset(xOffset, 0).release().perform();
    }

    public void enfocarNuevaVentana(){
        Set<String> ventanas = driver.getWindowHandles();
        for (String ventana : ventanas) {
            // Si la ventana no es la ventana principal, cambia a ella
            if (!ventana.equals(ventanaPrincipal)) {
                driver.switchTo().window(ventana);
                break;
            }
        }
    }

}