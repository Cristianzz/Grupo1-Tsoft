package Pages;

import Utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HdpPage extends BasePage {

    private final By byTodosFiltros = By.xpath("//div[contains(@class,'horizontal-filters-container')]/div[1]");
    private final By byOpcionDesayuno = By.xpath("//ul/li[contains(div/text(),'Desayuno')]");
    private final By byOpcionSpa = By.xpath("//ul/li[contains(div/text(),'Spa')]");
    private final By byBtnAplicarFiltros = By.xpath("//div[contains(text(),'Aplicar')]");
    
    public HdpPage(WebDriver driver) {
        super(driver);
    }

    public void seleccionarTodosFiltros() {
        esperarxsegundos(10000);
        clic(esperarElementoWeb(byTodosFiltros));
    }

    public void seleccionarDesayuno() {
        esperarxsegundos(2000);
        WebElement elemento = this.getDriver().findElement(byOpcionDesayuno);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) this.getDriver();
        jsExecutor.executeScript("arguments[0].click();", elemento);
    }

    public void seleccionarSPA() {
        esperarxsegundos(2000);
        WebElement elemento = this.getDriver().findElement(byOpcionSpa);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) this.getDriver();
        jsExecutor.executeScript("arguments[0].click();", elemento);
    }

    public void presionarAplicarFiltros() {
        esperarxsegundos(2000);
        clic(esperarElementoWeb(byBtnAplicarFiltros));
    }


    public void irHotelDetalles(int index) {
        esperarxsegundos(5000);
        clic(esperarElementoWeb(By.xpath("(//a[@data-testid='details'])["+index+"]")));

    }

}
