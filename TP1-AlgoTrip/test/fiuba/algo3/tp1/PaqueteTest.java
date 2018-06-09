package fiuba.algo3.tp1;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PaqueteTest {

    private static final double DELTA = 1e-3;

    // EL PAQUETE CALCULA SOLO LAS NOCHES, YA QUE EL DIA ADICIONAL DE DURACIÓN SE LO AÑADE EL VIAJE
    @Test
    public void test01PaqueteConVueloDomestico() {

        Paquete paquete = new Paquete("Vacaciones en alemán");
        Ciudad ciudad1 = new Ciudad("BER", "Berlín", "Alemania", 52.52, 13.40);
        Ciudad ciudad2 = new Ciudad("MUN", "Munich", "Alemania", 48.13, 11.58);

        VueloDomestico vueloIda = new VueloDomestico(ciudad1, ciudad2);
        VueloDomestico vueloVuelta = new VueloDomestico(ciudad2, ciudad1);
        paquete.agregarVuelo(vueloIda, "2018-09-19");
        paquete.agregarVuelo(vueloVuelta, "2018-09-20");

        Double costoEsperado = 504.91 * 2 * 0.9;
        Integer diasEsperados = 1;
        assertEquals(costoEsperado, paquete.obtenerCostoPaquete(), DELTA);
        assertEquals(diasEsperados, paquete.obtenerDiasPaquete(), DELTA);
    }

    @Test
    public void test02PaqueteConVueloInternacional() {

        Paquete paquete = new Paquete("Vacaciones en alemán");
        Ciudad ciudad1 = new Ciudad("EST", "Estocolmo", "Suecia", 59.32, 18.06);
        Ciudad ciudad2 = new Ciudad("REI", "Reikiavik", "Islandia", 64.12, -21.81);

        VueloInternacional vueloIda = new VueloInternacional(ciudad1, ciudad2);
        VueloInternacional vueloVuelta = new VueloInternacional(ciudad2, ciudad1);
        paquete.agregarVuelo(vueloIda, "2018-09-10");
        paquete.agregarVuelo(vueloVuelta, "2018-09-18");

        Double costoEsperado = 2128.43 * 1.5 * 1.05 * 2 * 0.9;
        Integer nochesEsperadas = 8;
        assertEquals(costoEsperado, paquete.obtenerCostoPaquete(), DELTA);
        assertEquals(nochesEsperadas, paquete.obtenerDiasPaquete(), DELTA);
    }

    @Test
    public void test03PaqueteConHotel() {

        Paquete paquete = new Paquete("Solo el hotel!");
        Hotel hotel = new Hotel("RIKI", "EST", 2000);
        paquete.agregarHotel("RIKI", hotel);
        paquete.agregarEstadiaHotel("RIKI", "2018-09-10", "2018-09-18");

        Double costoEsperado = 2000 * 8 * 0.8;
        Integer diasEsperados = 8;
        assertEquals(costoEsperado, paquete.obtenerCostoPaquete(), DELTA);
        assertEquals(diasEsperados, paquete.obtenerDiasPaquete(), DELTA);
    }

    @Test
    public void test04PaqueteConVueloDomesticoYHotel() {

        Paquete paquete = new Paquete("Vacaciones en alemán");
        Ciudad ciudad1 = new Ciudad("BER", "Berlín", "Alemania", 52.52, 13.40);
        Ciudad ciudad2 = new Ciudad("MUN", "Munich", "Alemania", 48.13, 11.58);
        Hotel hotel = new Hotel("RIKI", "EST", 2000);
        VueloDomestico vueloIda = new VueloDomestico(ciudad1, ciudad2);
        VueloDomestico vueloVuelta = new VueloDomestico(ciudad2, ciudad1);

        paquete.agregarVuelo(vueloIda, "2018-09-09");
        paquete.agregarVuelo(vueloVuelta, "2018-09-19");
        paquete.agregarHotel("RIKI", hotel);
        paquete.agregarEstadiaHotel("RIKI", "2018-09-10", "2018-09-18");

        Double costoEsperado = 2000 * 8 * 0.8 + 2 * 0.9 * 504.91;
        Integer diasEsperados = 10;
        assertEquals(costoEsperado, paquete.obtenerCostoPaquete(), DELTA);
        assertEquals(diasEsperados, paquete.obtenerDiasPaquete(), DELTA);
    }

    @Test
    public void test05PaqueteConVueloInternacionalYHotel() {

        Paquete paquete = new Paquete("Vacaciones en alemán");
        Ciudad ciudad1 = new Ciudad("EST", "Estocolmo", "Suecia", 59.32, 18.06);
        Ciudad ciudad2 = new Ciudad("REI", "Reikiavik", "Islandia", 64.12, -21.81);
        Hotel hotel = new Hotel("RIKI", "EST", 2000);
        VueloInternacional vueloIda = new VueloInternacional(ciudad1, ciudad2);
        VueloInternacional vueloVuelta = new VueloInternacional(ciudad2, ciudad1);

        paquete.agregarVuelo(vueloIda, "2018-09-09");
        paquete.agregarVuelo(vueloVuelta, "2018-09-18");
        paquete.agregarHotel("RIKI", hotel);
        paquete.agregarEstadiaHotel("RIKI", "2018-09-10", "2018-09-18");

        Double costoEsperado = 2000 * 8 * 0.8 + 2 * 0.9 * 2128.43 * 1.5 * 1.05;
        Integer diasEsperados = 9;
        assertEquals(costoEsperado, paquete.obtenerCostoPaquete(), DELTA);
        assertEquals(diasEsperados, paquete.obtenerDiasPaquete(), DELTA);
    }
}
