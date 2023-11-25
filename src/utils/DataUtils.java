package utils;

import java.util.Calendar;

public class DataUtils {
    /** Retorna uma string DD/MM/AAAA dado um Calendar contendo a data.
     */
    public static String getDataString(Calendar data){
        int dia = data.get(Calendar.DAY_OF_MONTH);
        int mes = data.get(Calendar.MONTH) + 1;
        int ano = data.get(Calendar.YEAR);

        String dataString = dia + "/" + mes + "/"+ ano;

        return dataString;
    }
}
