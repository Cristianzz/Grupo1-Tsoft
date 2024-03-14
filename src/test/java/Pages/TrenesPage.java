package Pages;

import Utils.BasePage;
import Utils.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TrenesPage extends BasePage {
    //Trenes
    By byVermas = By.xpath("(//div[@class=\"TopBarMenuListItemstyled__MenuItem-sc-hzwcuj-6 kgnpkG\"])[4]");
    By byOpcionTrenes = By.xpath("//a[@title=\"Trenes\"]");
    By byCmbOrigenTrenes = By.xpath("//input[@id=\":Rb8qjalamt2mm:\"]");
    By byCmbDestinoTrenes = By.xpath("//input[@id=\":Rd8qjalamt2mm:\"]");
    By BtnFechaidaTren = By.xpath("//button[@aria-label = \"Fecha de ida\"]");
    By byFechaidaTren = By.xpath("(//div[@class=\"d-iy1bge\"]/button[1])[1]");
    By byFechaVueltaTren = By.xpath("(//div[@class=\"d-iy1bge\"]/button[7])[1]");
    By byPreviousmonth = By.xpath("//button[@aria-label ='Previous month']");
    By byNextmonth = By.xpath("//button[@aria-label ='Next month']");
    By byAumentarAdultosTren=By.xpath("//button[contains(@aria-label,\"adultos\")][1]");
    By byBtnBuscar = By.xpath("(//button[contains(@aria-label, \"Buscar\")])[1]");
    By byEscogerViaje = By.xpath("//*[contains(@class, \"FullTransportSummary__SummaryColumn\")][1]");
    By byBtnSeleccionarViajeTren = By.xpath("//button[contains(@class, \"Button__LmnDsButton\") and contains(@class, \"TripCardBookButton__BrgUiBootstrapSizedButton\")]\n") ;
    By bySliderIdaTrenes = By.xpath("(//div[contains(@class, 'Slider__TrackWrapper')])[2]");
    By bySliderVueltaTrenes = By.xpath("(//div[contains(@class, 'Slider__TrackWrapper')])[3]");

    public TrenesPage(WebDriver driver) {super(driver);}

    public void Vermas() {
        esperarxsegundos(2000);
        moverCursorSobreElemento(byVermas);
        esperarxsegundos(2000);
        clic(esperarElementoWeb(byOpcionTrenes));
    }

    public void IngresarOrigenTren(String origen) {
        esperarxsegundos(2000);
        clic(byCmbOrigenTrenes);
        esperarxsegundos(2000);
        agregarTexto(byCmbOrigenTrenes, origen);
    }

    public void IngresarDestinoTren(String destino) {
        esperarxsegundos(2000);
        clic(byCmbDestinoTrenes);
        esperarxsegundos(2000);
        agregarTexto(byCmbDestinoTrenes, destino);
    }

    public void SeleccionarFechaTren(int mes, int anio) {
        esperarxsegundos(500);
        clic(BtnFechaidaTren);
        esperarxsegundos(1000);
        Helper.ubicarCalendario(this,mes, anio);
        esperarxsegundos(1000);
        clic(byFechaidaTren);
        esperarxsegundos(1000);
        clic(byFechaVueltaTren);
        esperarxsegundos(1000);
    }

    public void SeleccionarPasajerosTren(){
        esperarxsegundos(500);
        clic(esperarElementoWeb(byAumentarAdultosTren));
        esperarxsegundos(1000);
    }

    public void Buscar() {
        esperarxsegundos(1000);
        clic(esperarElementoWeb(byBtnBuscar));
    }

    public void SeleccionarViajeTren(){
        esperarxsegundos(10000);
        clic(esperarElementoWeb(byEscogerViaje));
        esperarxsegundos(2000);
        clic(byBtnSeleccionarViajeTren);
    }

    public void FiltroHorario(){
        esperarxsegundos(5000);
        //scrollDownHalfPage();
        esperarxsegundos(3000);
        controlarSlider(bySliderIdaTrenes,0.1);
        esperarxsegundos(5000);
        controlarSlider(bySliderVueltaTrenes,0.01);

    }




}
