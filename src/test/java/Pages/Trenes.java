package Pages;

import Utils.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class Trenes extends BasePage {
    By byVermas = By.xpath("(//div[@class=\"TopBarMenuListItemstyled__MenuItem-sc-hzwcuj-6 kgnpkG\"])[4]");
    By byOpcionTrenes = By.xpath("//a[@title=\"Trenes\"]");

    public Trenes(WebDriver driver) {
        super(driver);
    }


    public void Vermas() {
        esperarxsegundos(2000);
        moverCursorSobreElemento(byVermas);
        esperarxsegundos(2000);
        clic(esperarElementoWeb(byOpcionTrenes));
    }
}
