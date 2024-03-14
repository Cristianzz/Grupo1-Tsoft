package Pages;
import Utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class FlightsSearch extends BasePage {
    By byResult = By.xpath("//div[contains(@class,\"TotalResultsContainer\")]");
    By bySinEscala= By.xpath("(//div[contains(@class,\"Switchstyles__Slider\")])[1]");
    By byEnFly=By.xpath("//section[@data-role=\"results\"]");
    public FlightsSearch(WebDriver driver) {
        super(driver);
    }

    public void vuelosSinEscalas(){
        esperarxsegundos(500);
        clic(esperarElementoWeb(bySinEscala));

    }
    public boolean estoyEnFly() {
        esperarxsegundos(3000);
        try {
            buscarElemento(byEnFly);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
