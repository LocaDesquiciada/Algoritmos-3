package fiuba.algo3.tp1;

import java.text.SimpleDateFormat;
import java.util.TreeMap;
import java.util.*;

public class CalculadoraDeNoches {


    private TreeMap <String, String> fechas;
    private int total = 0;

    public CalculadoraDeNoches() {

        this.fechas = new TreeMap <String, String>();
    }

    public void agregarFecha(String fecha) {

        this.fechas.put(fecha, null);
    }

    public int nochesViaje() throws ValorNegativoError{

        if (this.fechas.isEmpty()) return 0;
        String fechaInicial = this.fechas.firstKey();
        total = 1;

        try {
            String fechaFinal = (String) this.fechas.lastKey();
            total = Formulas.distanciaEntreFechas(fechaInicial, fechaFinal);
            if ( total < 0) throw new ValorNegativoError( "La diferencia de días dio negativo" );
            return total;
        } catch (NoSuchElementException error){
            return total;
        }
    }
}
