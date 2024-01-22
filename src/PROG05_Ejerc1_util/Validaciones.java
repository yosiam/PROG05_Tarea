/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PROG05_Ejerc1_util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Joseme
 */
public class Validaciones {
    public static boolean validarFecha(String fecha) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dateFormat.setLenient(false);
            dateFormat.parse(fecha);
            return true;
        } catch (ParseException | DateTimeParseException e) {
            return false;
        }
    }

    public static boolean validarKilometros(int nuevosKilometros, int kilometrosActuales) {
        return nuevosKilometros > kilometrosActuales;
    }

    public static boolean validarDNI(String dni) {
        String regex = "^(0[1-9]|[1-9]\\d{0,7})[TRWAGMYFPDXBNJZSQVHLCKE]$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(dni);

        return matcher.matches();
    }
}
