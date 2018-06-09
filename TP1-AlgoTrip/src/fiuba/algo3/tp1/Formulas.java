package fiuba.algo3.tp1;

import java.lang.Math;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Formulas {

    // HARVENSINE

    public static final double EARTH_RADIUS = 6371.00; // Approx Earth radius in KM

    public static double harvensine(double startLat, double startLong, double endLat, double endLong) {

        double dLat = Math.toRadians((endLat - startLat));
        double dLong = Math.toRadians((endLong - startLong));

        startLat = Math.toRadians(startLat);
        endLat = Math.toRadians(endLat);

        double a = haversin(dLat) + (Math.cos(startLat) * Math.cos(endLat) * haversin(dLong));
        double c = 2 * (Math.atan2(Math.sqrt(a), Math.sqrt(1 - a)));
        return EARTH_RADIUS * c;
    }

    public static double haversin(double val) {

        return Math.pow(Math.sin(val / 2), 2);
    }


    // CALCULADORA DE DIAS

    public static int distanciaEntreFechas(String fechaInicial, String fechaFinal) {

        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date fechaInicio = formato.parse(fechaInicial);
            Date fechaFin = formato.parse(fechaFinal);
            int total = (int) (((fechaFin.getTime()) - (fechaInicio.getTime())) / 86400000);
            return total;
        }
        catch (ParseException e) {
            return 1;
        }
    }
}
