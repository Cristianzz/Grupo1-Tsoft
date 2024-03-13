package Pages;
import Utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlightsSearch extends BasePage {
    By byResult = By.xpath("//div[contains(@class,\"TotalResultsContainer\")]");
    By bySinEscala = By.xpath("(//div[contains(@class,\"Switchstyles__Slider\")])[1]");

    public FlightsSearch(WebDriver driver) {
        super(driver);
    }

    public String MensajeResultado() {
        return obtenerTexto(esperarElementoWeb(byResult));
    }

    public void VuelosSinEscalas() {
        esperarxsegundos(500);
        clic(esperarElementoWeb(bySinEscala));

    }
}
