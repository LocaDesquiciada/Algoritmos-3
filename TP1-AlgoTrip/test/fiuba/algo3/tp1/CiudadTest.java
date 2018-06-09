package fiuba.algo3.tp1;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CiudadTest {

    private static final double DELTA = 1e-3;

    @Test
    public void test01CiudadesPertenecenAMismoPais() {

        Integer valorEsperado = 0;

        Ciudad ciudad1 = new Ciudad("BER", "Berlín", "Alemania", 52.52, 13.40);
        Ciudad ciudad2 = new Ciudad("MUN", "Munich", "Alemania", 48.13, 11.58);

        if (ciudad1.mismoPais(ciudad2)) valorEsperado = 1;

        assertEquals(valorEsperado, 1, DELTA);
    }
}
