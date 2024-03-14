package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    //Wrapper de Selenium
    private WebDriver driver;
    private WebDriverWait espera;

    public BasePage(WebDriver driver) {
        this.driver = driver;
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

}
