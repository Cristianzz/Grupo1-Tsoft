package Pages;

import Utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlightsSearch extends BasePage {
    By byResult = By.xpath("//div[contains(@class,\"TotalResultsContainer\")]");
    public FlightsSearch(WebDriver driver) {
        super(driver);
    }

    public String MensajeResultado(){
        return obtenerTexto(esperarElementoWeb(byResult));
    }
}
