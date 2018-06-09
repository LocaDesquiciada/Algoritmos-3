package fiuba.algo3.tp1;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class VueloInternacionalTest {

    private static final double DELTA = 1e-3;

    @Test
    public void test01VueloInternacionalCalcularCosto() {

        Ciudad ciudad1 = new Ciudad("EST", "Estocolmo", "Suecia", 59.32, 18.06);
        Ciudad ciudad2 = new Ciudad("REI", "Reikiavik", "Islandia", 64.12, -21.81);

        VueloInternacional vuelo = new VueloInternacional(ciudad1, ciudad2);

        Double costoEsperado = 2128.43 * 1.5 * 1.05;
        assertEquals(costoEsperado, vuelo.calcularCostoVuelo(), DELTA);
    }

}
