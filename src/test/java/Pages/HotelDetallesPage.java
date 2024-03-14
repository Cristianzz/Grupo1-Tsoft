package Pages;

import Utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HotelDetallesPage extends BasePage {
    private final By byBtnCta = By.xpath("//button[@data-test-id='book-cta']");
    private final By byOpcionRegimen = By.xpath("(//label[@data-testid='radio'])[2]");

    public HotelDetallesPage(WebDriver driver) {
        super(driver);
    }

    public void seleccionarVerMas() {
        esperarxsegundos(5000);
        enfocarNuevaVentana();
        clic(esperarElementoWeb(byBtnCta));
    }

    public void seleccionarHabitacion(int index){
        esperarxsegundos(1000);
        clic(esperarElementoWeb(By.xpath("(//button[@data-testid='checkout-button'])["+index+"]")));
    }

    public void seleccionarRegimen() {
        esperarxsegundos(1000);
        clic(esperarElementoWeb(byOpcionRegimen));
    }

}
