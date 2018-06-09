package fiuba.algo3.tp1;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculadoraDeNochesTest {

    private static final double DELTA = 1e-3;

    @Test
    public void test01Calcular0Noches() {

        CalculadoraDeNoches calcu = new CalculadoraDeNoches();
        calcu.agregarFecha("2018-06-06");

        int cantEsperada = 0;
        assertEquals(cantEsperada, calcu.nochesViaje(), DELTA);
    }

   @Test
    public void test02CalcularCantDiasEnUnMismoMes() {

        CalculadoraDeNoches calcu = new CalculadoraDeNoches();
        calcu.agregarFecha("2018-09-10");
        calcu.agregarFecha("2018-09-19");

        int cantEsperada = 9;
        assertEquals(cantEsperada, calcu.nochesViaje(), DELTA);
   }

    @Test
    public void test03CalcularCantDiasEnDistintiosMeses() {

        CalculadoraDeNoches calcu = new CalculadoraDeNoches();
        calcu.agregarFecha("2018-06-14");
        calcu.agregarFecha("2018-07-16");

        int cantEsperada = 32;
        assertEquals(cantEsperada, calcu.nochesViaje(), DELTA);
    }
}