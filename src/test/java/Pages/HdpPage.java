package Pages;

import Utils.BasePage;
import Utils.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HdpPage extends BasePage {
    
    public HdpPage(WebDriver driver) {
        super(driver);
    }

    public void seleccionarTodosFiltros() {
        esperarxsegundos(10000);
        By filtro = By.xpath("//div[contains(@class,'horizontal-filters-container')]/div[1]");
        clic(esperarElementoWeb(By.xpath("//div[contains(@class,'horizontal-filters-container')]/div[3]")));
    }

    public void seleccionarDesayuno() {
        esperarxsegundos(2000);
        WebElement elemento = this.getDriver().findElement(By.xpath("//ul/li[contains(div/text(),'Desayuno')]"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) this.getDriver();
        jsExecutor.executeScript("arguments[0].click();", elemento);
    }

    public void seleccionarSPA() {
        esperarxsegundos(2000);
        WebElement elemento = this.getDriver().findElement(By.xpath("//ul/li[contains(div/text(),'Spa')]"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) this.getDriver();
        jsExecutor.executeScript("arguments[0].click();", elemento);
    }

    public void presionarAplicarFiltros() {
        esperarxsegundos(2000);
        clic(esperarElementoWeb(By.xpath("//div[contains(text(),'Aplicar')]")));
    }


}
