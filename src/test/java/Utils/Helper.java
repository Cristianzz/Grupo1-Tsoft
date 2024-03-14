package Utils;

import org.openqa.selenium.By;

import java.nio.charset.StandardCharsets;
import java.util.Calendar;

public class Helper {
    static By byCalendarioAvanzar = By.xpath("//button[@aria-label='Next month']");
    public static void ubicarCalendario(BasePage page, int mes, int anio){
        Calendar calendario = Calendar.getInstance();
        int mesActual = calendario.get(Calendar.MONTH);
        int anioActual = calendario.get(Calendar.YEAR);
        int nAnios = anio - anioActual;
        int nMeses = mes - mesActual;
        int nIteraciones = nAnios*12 + nMeses - 1;
        for (int i = 0; i < nIteraciones; i++) {
            page.clic(page.esperarElementoWeb(byCalendarioAvanzar));
            page.esperarxsegundos(500);
        }
    }

    public static String corregirEncoding(String textoIncorrecto) {
        byte[] bytes = textoIncorrecto.getBytes(StandardCharsets.ISO_8859_1);
        return new String(bytes, StandardCharsets.UTF_8);
    }

}
