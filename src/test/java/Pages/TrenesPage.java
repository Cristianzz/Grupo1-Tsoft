package Pages;

import Utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TrenesPage extends BasePage {
    //Trenes
    By byVermas = By.xpath("(//div[@class=\"TopBarMenuListItemstyled__MenuItem-sc-hzwcuj-6 kgnpkG\"])[4]");
    By byOpcionTrenes = By.xpath("//a[@title=\"Trenes\"]");
    By byCmbOrigenTrenes = By.xpath("//input[@id=\":Rb8qjalamt2mm:\"]");
    By byCmbDestinoTrenes = By.xpath("//input[@id=\":Rd8qjalamt2mm:\"]");
    By BtnFechaidaTren = By.xpath("//button[@aria-label = \"Fecha de ida\"]");



    By byPreviousmonth = By.xpath("//button[@aria-label ='Previous month']");
    By byNextmonth = By.xpath("//button[@aria-label ='Next month']");

    public TrenesPage(WebDriver driver) {super(driver);}

    public void Vermas() {
        esperarxsegundos(2000);
        moverCursorSobreElemento(byVermas);
        esperarxsegundos(2000);
        clic(esperarElementoWeb(byOpcionTrenes));
    }




}
