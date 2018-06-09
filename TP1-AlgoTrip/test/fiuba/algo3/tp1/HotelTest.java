package fiuba.algo3.tp1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.text.ParseException;

public class HotelTest {

    private static final double DELTA = 1e-3;

    @Test
    public void test01HotelPrecioDeUnaNoche() {

        Hotel hotel = new Hotel("Sheraton", "BUE", 1500);
        Estadia estadia = new Estadia("1995-09-19", "1995-09-20");
        hotel.agregarEstadia(estadia);

        int cantNochesEsperada = 1;
        int costoEsperado = 1500;
        assertEquals(costoEsperado, hotel.precioHotelTotal(), DELTA);
        assertEquals(cantNochesEsperada, hotel.cantidadNoches(), DELTA);
    }

    @Test
    public void test02HotelConEstadia() {

        Hotel hotel = new Hotel("Sheraton", "BUE", 1500);
        Estadia estadia = new Estadia("1995-09-10", "1995-09-18");
        hotel.agregarEstadia(estadia);

        int cantNochesEsperada = 8;
        int costoEsperado = 1500 * cantNochesEsperada;
        assertEquals(costoEsperado, hotel.precioHotelTotal(), DELTA);
        assertEquals(cantNochesEsperada, hotel.cantidadNoches(), DELTA);
    }
}
