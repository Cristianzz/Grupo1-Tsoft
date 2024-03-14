package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.Calendar;

public class Helper {

    private static final By byCalendarioAvanzar = By.xpath("//button[@aria-label='Next month']");

    public static void ubicarCalendario(BasePage page, int mes, int anio){
        Calendar calendario = Calendar.getInstance();
        int mesActual = calendario.get(Calendar.MONTH);
        int anioActual = calendario.get(Calendar.YEAR);
        int nAnios = anio - anioActual;
        int nMeses = mes - mesActual;
        int nIteraciones = nAnios*12 + nMeses - 1;
        for (int i = 0; i < nIteraciones; i++) {
            page.clic(page.esperarElementoWeb(byCalendarioAvanzar));
            page.esperarxsegundos(1000);
        }
    }

    public static void esperarElemento(WebElement elemento, int maxIntentos, int intervalo) {
        int intentos = 0;
        while (!elemento.isEnabled() || intentos < maxIntentos) {
            intentos++;
            try {
                Thread.sleep(intervalo);
            } catch (InterruptedException e) {
                System.out.println("Error al esperar elemento, intento: " + intentos);
            }
        }
    }

}
