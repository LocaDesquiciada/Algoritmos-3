package fiuba.algo3.tp1;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class VueloDomesticoTest {

    private static final double DELTA = 1e-3;

    @Test
    public void test01VueloDomesticoCalcularCosto(){

        Ciudad ciudad1 = new Ciudad("BER", "Berlín", "Alemania", 52.52, 13.40);
        Ciudad ciudad2 = new Ciudad("MUN", "Munich", "Alemania", 48.13, 11.58);

        VueloDomestico vuelo = new VueloDomestico(ciudad1, ciudad2);

        Double costoEsperado = 504.91;
        assertEquals(costoEsperado, vuelo.calcularCostoVuelo(), DELTA);
    }
}
