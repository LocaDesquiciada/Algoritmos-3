package fiuba.algo3.tp1;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ViajeTest {

    // Viaje lo unico que calcula es el costo y las noches del mismo.

    private static final double DELTA = 1e-3;

    @Test
    public void test01ViajeVacio() {

        Viaje viaje = new Viaje("Vacaciones Invierno 2017");

        assertEquals(0, viaje.obtenerDuracionViaje(), DELTA);
        assertEquals(0, viaje.obtenerCostoViaje(), DELTA);
    }

    // UN SOLO VIAJE DOMÉSTICO
    @Test
    public void test02ViajeConVueloIdaDomestico() {

        Viaje viaje = new Viaje("Vacaciones en alemán");

        Ciudad ciudad1 = new Ciudad("BER", "Berlín", "Alemania", 52.52, 13.40);
        Ciudad ciudad2 = new Ciudad("MUN", "Munich", "Alemania", 48.13, 11.58);

        VueloDomestico vueloIda = new VueloDomestico(ciudad1, ciudad2);
        viaje.agregarVuelo(vueloIda, "2018-09-19");

        Double costoEsperado = 504.91;
        Integer diasEsperados = 1;
        assertEquals(costoEsperado, viaje.obtenerCostoViaje(), DELTA);
        assertEquals(diasEsperados, viaje.obtenerDuracionViaje(), DELTA);
    }

    @Test
    public void test03ViajeConVueloIdaDomesticoYComidaEspecial() {

        Viaje viaje = new Viaje("Vacaciones en alemán");
        Ciudad ciudad1 = new Ciudad("BER", "Berlín", "Alemania", 52.52, 13.40);
        Ciudad ciudad2 = new Ciudad("MUN", "Munich", "Alemania", 48.13, 11.58);

        VueloDomestico vueloIda = new VueloDomestico(ciudad1, ciudad2);
        viaje.agregarVuelo(vueloIda, "2018-09-19");
        viaje.agregarComidaEspecial();

        Double costoEsperado = 504.91 + 100;
        Integer diasEsperados = 1;
        assertEquals(costoEsperado, viaje.obtenerCostoViaje(), DELTA);
        assertEquals(diasEsperados, viaje.obtenerDuracionViaje(), DELTA);
    }

    @Test
    public void test04ViajeConVueloIdaDomesticoYAsistencia() {

        Viaje viaje = new Viaje("Vacaciones en alemán");
        Ciudad ciudad1 = new Ciudad("BER", "Berlín", "Alemania", 52.52, 13.40);
        Ciudad ciudad2 = new Ciudad("MUN", "Munich", "Alemania", 48.13, 11.58);

        VueloDomestico vueloIda = new VueloDomestico(ciudad1, ciudad2);
        viaje.agregarVuelo(vueloIda, "2018-09-19");
        viaje.agregarAsist();

        Double costoEsperado = 504.91 * 1.1;
        Integer diasEsperados = 1;
        assertEquals(costoEsperado, viaje.obtenerCostoViaje(), DELTA);
        assertEquals(diasEsperados, viaje.obtenerDuracionViaje(), DELTA);
    }

    @Test
    public void test05ViajeConVueloIdaDomesticoYHotel() {

        Viaje viaje = new Viaje("Vacaciones en alemán");
        Hotel hotel = new Hotel("ElAleman", "MUN", 1500);
        Ciudad ciudad1 = new Ciudad("BER", "Berlín", "Alemania", 52.52, 13.40);
        Ciudad ciudad2 = new Ciudad("MUN", "Munich", "Alemania", 48.13, 11.58);

        VueloDomestico vueloIda = new VueloDomestico(ciudad1, ciudad2);
        viaje.agregarVuelo(vueloIda, "2018-09-10");
        viaje.agregarHotel("ElAleman", hotel);
        viaje.agregarEstadiaHotel("ElAleman","2018-09-10", "2018-09-18");


        Integer duracionViaje = 9;
        Double costoEsperado = 504.91 + 1500 * 8;
        assertEquals(costoEsperado, viaje.obtenerCostoViaje(), DELTA);
        assertEquals(duracionViaje, viaje.obtenerDuracionViaje(), DELTA);
    }

    @Test
    public void test06ViajeConVueloIdaDomesticoAsistenciaComidaEspecialYHotel() {

        Viaje viaje = new Viaje("Vacaciones en alemán");
        Hotel hotel = new Hotel("ElAleman", "Mun", 1500);
        Ciudad ciudad1 = new Ciudad("BER", "Berlín", "Alemania", 52.52, 13.40);
        Ciudad ciudad2 = new Ciudad("MUN", "Munich", "Alemania", 48.13, 11.58);

        VueloDomestico vueloIda = new VueloDomestico(ciudad1, ciudad2);
        viaje.agregarVuelo(vueloIda, "2018-09-10");
        viaje.agregarHotel(hotel.nombreHotel, hotel);
        viaje.agregarEstadiaHotel("ElAleman", "2018-09-10", "2018-09-18");
        viaje.agregarAsist();
        viaje.agregarComidaEspecial();

        Integer diasEsperados = 9;
        Double costoEsperado = 504.91 * 1.1 + 100 + 1500 * 8 + 30 * 8;
        assertEquals(costoEsperado, viaje.obtenerCostoViaje(), DELTA);
        assertEquals(diasEsperados, viaje.obtenerDuracionViaje(), DELTA);
    }

    // UN SOLO VIAJE INTERNACIONAL
    @Test
    public void test07ViajeConVueloIdaInternacional() {

        Viaje viaje = new Viaje("Vacacione en frío");
        Ciudad ciudad1 = new Ciudad("EST", "Estocolmo", "Suecia", 59.32, 18.06);
        Ciudad ciudad2 = new Ciudad("REI", "Reikiavik", "Islandia", 64.12, -21.81);

        VueloInternacional vueloIda = new VueloInternacional(ciudad1, ciudad2);

        viaje.agregarVuelo(vueloIda, "2018-09-19");

        Double costoEsperado = 2128.43 * 1.5 * 1.05;
        Integer diasEsperados = 1;
        assertEquals(costoEsperado, viaje.obtenerCostoViaje(), DELTA);
        assertEquals(diasEsperados, viaje.obtenerDuracionViaje(), DELTA);
    }

    @Test
    public void test08ViajeConVueloIdaInternacionalYComidaEspecial() {

        Viaje viaje = new Viaje("Vacaciones en frío");
        Ciudad ciudad1 = new Ciudad("EST", "Estocolmo", "Suecia", 59.32, 18.06);
        Ciudad ciudad2 = new Ciudad("REI", "Reikiavik", "Islandia", 64.12, -21.81);

        VueloInternacional vueloIda = new VueloInternacional(ciudad1, ciudad2);
        viaje.agregarVuelo(vueloIda, "2018-09-19");
        viaje.agregarComidaEspecial();

        Double costoEsperado = 2128.43 * 1.5 * 1.05 + 100;
        Integer diasEsperados = 1;
        assertEquals(costoEsperado, viaje.obtenerCostoViaje(), DELTA);
        assertEquals(diasEsperados, viaje.obtenerDuracionViaje(), DELTA);
    }

    @Test
    public void test09ViajeConVueloIdaInternacionalYAsistencia() {

        Viaje viaje = new Viaje("Vacaciones en alemán");
        Ciudad ciudad1 = new Ciudad("EST", "Estocolmo", "Suecia", 59.32, 18.06);
        Ciudad ciudad2 = new Ciudad("REI", "Reikiavik", "Islandia", 64.12, -21.81);

        VueloInternacional vueloIda = new VueloInternacional(ciudad1, ciudad2);
        viaje.agregarVuelo(vueloIda, "2018-09-19");
        viaje.agregarAsist();

        Double costoEsperado = 2128.43 * 1.5 * 1.05 * 1.1;
        Integer diasEsperados = 1;
        assertEquals(costoEsperado, viaje.obtenerCostoViaje(), DELTA);
        assertEquals(diasEsperados, viaje.obtenerDuracionViaje(), DELTA);
    }

    @Test
    public void test10ViajeConVueloIdaInternacionalYHotel() {

        Viaje viaje = new Viaje("Vacacione en frío");
        Hotel hotel = new Hotel("RIKI", "EST", 2000);
        Ciudad ciudad1 = new Ciudad("EST", "Estocolmo", "Suecia", 59.32, 18.06);
        Ciudad ciudad2 = new Ciudad("REI", "Reikiavik", "Islandia", 64.12, -21.81);

        VueloInternacional vueloIda = new VueloInternacional(ciudad1, ciudad2);
        viaje.agregarVuelo(vueloIda, "2018-09-10");
        viaje.agregarHotel("RIKI", hotel);
        viaje.agregarEstadiaHotel("RIKI", "2018-09-10", "2018-09-18");

        Integer diasEsperados = 9;
        Double costoEsperado = 2128.43 * 1.5 * 1.05 + 2000 * 8;
        assertEquals(costoEsperado, viaje.obtenerCostoViaje(), DELTA);
        assertEquals(diasEsperados, viaje.obtenerDuracionViaje(), DELTA);
    }

    @Test
    public void test11ViajeConVueloIdaInternacionalAsistenciaComidaEspecialYHotel() {

        Viaje viaje = new Viaje("Vacacione en frío");
        Hotel hotel = new Hotel("RIKI", "EST", 2000);
        Ciudad ciudad1 = new Ciudad("EST", "Estocolmo", "Suecia", 59.32, 18.06);
        Ciudad ciudad2 = new Ciudad("REI", "Reikiavik", "Islandia", 64.12, -21.81);

        VueloInternacional vueloIda = new VueloInternacional(ciudad1, ciudad2);
        viaje.agregarVuelo(vueloIda, "2018-09-18");
        viaje.agregarHotel(hotel.nombreHotel, hotel);
        viaje.agregarEstadiaHotel(hotel.nombreHotel, "2018-09-10", "2018-09-18");
        viaje.agregarAsist();
        viaje.agregarComidaEspecial();

        Integer diasEsperados = 9;
        Double costoEsperado = 2128.43 * 1.5 * 1.05 * 1.1 + 100 + 2000 * 8 + 30 * 8;
        assertEquals(costoEsperado, viaje.obtenerCostoViaje(), DELTA);
        assertEquals(diasEsperados, viaje.obtenerDuracionViaje(), DELTA);
    }

    // VIAJES DOMESTICOS IDA Y VUELTA
    @Test
    public void test12ViajeConVueloDomesticoIdaYVuelta() {

        Viaje viaje = new Viaje("Vacaciones en alemán");
        Ciudad ciudad1 = new Ciudad("BER", "Berlín", "Alemania", 52.52, 13.40);
        Ciudad ciudad2 = new Ciudad("MUN", "Munich", "Alemania", 48.13, 11.58);

        VueloDomestico vueloIda = new VueloDomestico(ciudad1, ciudad2);
        VueloDomestico vueloVuelta = new VueloDomestico(ciudad2, ciudad1);
        viaje.agregarVuelo(vueloIda, "2018-09-19");
        viaje.agregarVuelo(vueloVuelta, "2018-09-20");

        Double costoEsperado = 504.91 * 2;
        Integer diasEsperados = 2;
        assertEquals(costoEsperado, viaje.obtenerCostoViaje(), DELTA);
        assertEquals(diasEsperados, viaje.obtenerDuracionViaje(), DELTA);
    }

    @Test
    public void test13ViajeConVueloDomesticoIdaYVueltaYComidaEspecial() {

        Viaje viaje = new Viaje("Vacaciones en alemán");
        Ciudad ciudad1 = new Ciudad("BER", "Berlín", "Alemania", 52.52, 13.40);
        Ciudad ciudad2 = new Ciudad("MUN", "Munich", "Alemania", 48.13, 11.58);

        VueloDomestico vueloIda = new VueloDomestico(ciudad1, ciudad2);
        VueloDomestico vueloVuelta = new VueloDomestico(ciudad2, ciudad1);
        viaje.agregarVuelo(vueloIda, "2018-09-19");
        viaje.agregarVuelo(vueloVuelta, "2018-09-20");
        viaje.agregarComidaEspecial();

        Double costoEsperado = 504.91 * 2 + 200;
        Integer diasEsperados = 2;
        assertEquals(costoEsperado, viaje.obtenerCostoViaje(), DELTA);
        assertEquals(diasEsperados, viaje.obtenerDuracionViaje(), DELTA);
    }

    @Test
    public void test14ViajeConVueloDomesticoIdayVueltaYAsistencia() {

        Viaje viaje = new Viaje("Vacaciones en alemán");
        Ciudad ciudad1 = new Ciudad("BER", "Berlín", "Alemania", 52.52, 13.40);
        Ciudad ciudad2 = new Ciudad("MUN", "Munich", "Alemania", 48.13, 11.58);

        VueloDomestico vueloIda = new VueloDomestico(ciudad1, ciudad2);
        VueloDomestico vueloVuelta = new VueloDomestico(ciudad2, ciudad1);
        viaje.agregarVuelo(vueloIda, "2018-09-19");
        viaje.agregarVuelo(vueloVuelta, "2018-09-20");
        viaje.agregarAsist();

        Double costoEsperado = 504.91 * 2 * 1.1;
        Integer diasEsperados = 2;
        assertEquals(costoEsperado, viaje.obtenerCostoViaje(), DELTA);
        assertEquals(diasEsperados, viaje.obtenerDuracionViaje(), DELTA);
    }
    @Test
    public void test15ViajeConVueloDomesticoIdaYVueltaConHotel() {

        Viaje viaje = new Viaje("Vacaciones en alemán");
        Hotel hotel = new Hotel("ElAleman", "MUN", 1500);
        Ciudad ciudad1 = new Ciudad("BER", "Berlín", "Alemania", 52.52, 13.40);
        Ciudad ciudad2 = new Ciudad("MUN", "Munich", "Alemania", 48.13, 11.58);

        VueloDomestico vueloIda = new VueloDomestico(ciudad1, ciudad2);
        VueloDomestico vueloVuelta = new VueloDomestico(ciudad2, ciudad1);
        viaje.agregarVuelo(vueloIda, "2018-09-10");
        viaje.agregarVuelo(vueloVuelta, "2018-09-18");
        viaje.agregarHotel("ElAleman", hotel);
        viaje.agregarEstadiaHotel("ElAleman", "2018-09-10", "2018-09-18");

        Double costoEsperado = 504.91 * 2 + 8 * 1500;
        Integer diasEsperados = 9;
        assertEquals(costoEsperado, viaje.obtenerCostoViaje(), DELTA);
        assertEquals(diasEsperados, viaje.obtenerDuracionViaje(), DELTA);
    }

    @Test
    public void test16ViajeConVueloDomesticoIdaYVueltaYComidaEspecialAsistenciaYHotel() {

        Viaje viaje = new Viaje("Vacaciones en alemán");
        Hotel hotel = new Hotel("ElAleman", "MUN", 1500);
        Ciudad ciudad1 = new Ciudad("BER", "Berlín", "Alemania", 52.52, 13.40);
        Ciudad ciudad2 = new Ciudad("MUN", "Munich", "Alemania", 48.13, 11.58);

        VueloDomestico vueloIda = new VueloDomestico(ciudad1, ciudad2);
        VueloDomestico vueloVuelta = new VueloDomestico(ciudad2, ciudad1);
        viaje.agregarVuelo(vueloIda, "2018-09-10");
        viaje.agregarVuelo(vueloVuelta, "2018-09-18");
        viaje.agregarHotel(hotel.nombreHotel, hotel);
        viaje.agregarEstadiaHotel(hotel.nombreHotel, "2018-09-10", "2018-09-18");
        viaje.agregarAsist();
        viaje.agregarComidaEspecial();

        Double costoEsperado = 504.91 * 2 * 1.1 + 200 + 1500 * 8 + 8 * 30;
        Integer diasEsperados = 9;
        assertEquals(costoEsperado, viaje.obtenerCostoViaje(), DELTA);
        assertEquals(diasEsperados, viaje.obtenerDuracionViaje(), DELTA);
    }

    // VIAJES INTERNACIONALES IDA Y VUELTA
    @Test
    public void test17ViajeConVueloInternacionalIdaYVuelta() {

        Viaje viaje = new Viaje("Vacacione en frío");
        Ciudad ciudad1 = new Ciudad("EST", "Estocolmo", "Suecia", 59.32, 18.06);
        Ciudad ciudad2 = new Ciudad("REI", "Reikiavik", "Islandia", 64.12, -21.81);

        VueloInternacional vueloIda = new VueloInternacional(ciudad1, ciudad2);
        VueloInternacional vueloVuelta = new VueloInternacional(ciudad2, ciudad1);
        viaje.agregarVuelo(vueloIda, "2018-09-10");
        viaje.agregarVuelo(vueloVuelta, "2018-09-18");

        Double costoEsperado = 2128.43 * 1.5 * 1.05 * 2;
        Integer diasEsperados = 9;
        assertEquals(costoEsperado, viaje.obtenerCostoViaje(), DELTA);
        assertEquals(diasEsperados, viaje.obtenerDuracionViaje(), DELTA);
    }

    @Test
    public void test18ViajeConVueloInternacionalIdaYVueltaYComidaEspecial() {

        Viaje viaje = new Viaje("Vacacione en frío");
        Ciudad ciudad1 = new Ciudad("EST", "Estocolmo", "Suecia", 59.32, 18.06);
        Ciudad ciudad2 = new Ciudad("REI", "Reikiavik", "Islandia", 64.12, -21.81);

        VueloInternacional vueloIda = new VueloInternacional(ciudad1, ciudad2);
        VueloInternacional vueloVuelta = new VueloInternacional(ciudad2, ciudad1);
        viaje.agregarVuelo(vueloIda, "2018-09-10");
        viaje.agregarVuelo(vueloVuelta, "2018-09-18");
        viaje.agregarComidaEspecial();

        Double costoEsperado = 2128.43 * 1.5 * 1.05 * 2 + 200;
        Integer diasEsperados = 9;
        assertEquals(costoEsperado, viaje.obtenerCostoViaje(), DELTA);
        assertEquals(diasEsperados, viaje.obtenerDuracionViaje(), DELTA);
    }

    @Test
    public void test19ViajeConVueloInternacionalIdaYVueltaYAsistencia() {

        Viaje viaje = new Viaje("Vacacione en frío");
        Ciudad ciudad1 = new Ciudad("EST", "Estocolmo", "Suecia", 59.32, 18.06);
        Ciudad ciudad2 = new Ciudad("REI", "Reikiavik", "Islandia", 64.12, -21.81);

        VueloInternacional vueloIda = new VueloInternacional(ciudad1, ciudad2);
        VueloInternacional vueloVuelta = new VueloInternacional(ciudad2, ciudad1);
        viaje.agregarVuelo(vueloIda, "2018-09-10");
        viaje.agregarVuelo(vueloVuelta, "2018-09-18");
        viaje.agregarAsist();

        Double costoEsperado = 2128.43 * 1.5 * 1.05 * 2 * 1.1;
        Integer diasEsperados = 9;
        assertEquals(costoEsperado, viaje.obtenerCostoViaje(), DELTA);
        assertEquals(diasEsperados, viaje.obtenerDuracionViaje(), DELTA);
    }

    @Test
    public void test20ViajeConVueloInternacionalIdaYVueltaYHotel() {

        Viaje viaje = new Viaje("Vacacione en frío");
        Hotel hotel = new Hotel("RIKI", "EST", 2000);
        Ciudad ciudad1 = new Ciudad("EST", "Estocolmo", "Suecia", 59.32, 18.06);
        Ciudad ciudad2 = new Ciudad("REI", "Reikiavik", "Islandia", 64.12, -21.81);

        VueloInternacional vueloIda = new VueloInternacional(ciudad1, ciudad2);
        VueloInternacional vueloVuelta = new VueloInternacional(ciudad2, ciudad1);
        viaje.agregarVuelo(vueloIda, "2018-09-10");
        viaje.agregarVuelo(vueloVuelta, "2018-09-18");
        viaje.agregarHotel("RIKI", hotel);
        viaje.agregarEstadiaHotel("RIKI", "2018-09-10", "2018-09-18");

        Double costoEsperado = 2128.43 * 1.5 * 1.05 * 2 + 8 * 2000;
        Integer diasEsperados = 9;
        assertEquals(costoEsperado, viaje.obtenerCostoViaje(), DELTA);
        assertEquals(diasEsperados, viaje.obtenerDuracionViaje(), DELTA);
    }

    @Test
    public void test21ViajeConVueloInternacionalIdaYVueltaComidaEspecialAsistenciaYHotel() {

        Viaje viaje = new Viaje("Vacacione en frío");
        Hotel hotel = new Hotel("RIKI", "EST", 2000);
        Ciudad ciudad1 = new Ciudad("EST", "Estocolmo", "Suecia", 59.32, 18.06);
        Ciudad ciudad2 = new Ciudad("REI", "Reikiavik", "Islandia", 64.12, -21.81);

        VueloInternacional vueloIda = new VueloInternacional(ciudad1, ciudad2);
        VueloInternacional vueloVuelta = new VueloInternacional(ciudad2, ciudad1);
        viaje.agregarVuelo(vueloIda, "2018-09-10");
        viaje.agregarVuelo(vueloVuelta, "2018-09-18");
        viaje.agregarHotel(hotel.nombreHotel, hotel);
        viaje.agregarEstadiaHotel(hotel.nombreHotel, "2018-09-10", "2018-09-18");
        viaje.agregarAsist();
        viaje.agregarComidaEspecial();

        Double costoEsperado = 2128.43 * 1.5 * 1.05 * 2 * 1.1 + 200 + 8 * 2000 + 8 * 30;
        Integer diasEsperados = 9;
        assertEquals(costoEsperado, viaje.obtenerCostoViaje(), DELTA);
        assertEquals(diasEsperados, viaje.obtenerDuracionViaje(), DELTA);
    }

    // PRUEBAS DE VIAJE CON HOTEL
    @Test
    public void test22ViajeConHotel() {

        Viaje viaje = new Viaje("Vacacione en frío");
        Hotel hotel = new Hotel("RIKI", "EST", 2000);
        viaje.agregarHotel("RIKI", hotel);
        viaje.agregarEstadiaHotel("RIKI", "2018-09-10", "2018-09-18");

        int costoEsperado = 8 * 2000;
        Integer diasEsperados = 9;
        assertEquals(costoEsperado, viaje.obtenerCostoViaje(), DELTA);
        assertEquals(diasEsperados, viaje.obtenerDuracionViaje(), DELTA);
    }

    @Test
    public void test23ViajeConHotelYAsistenia() {

        Viaje viaje = new Viaje("Vacacione en frío");
        Hotel hotel = new Hotel("RIKI", "EST", 2000);

        viaje.agregarHotel(hotel.nombreHotel, hotel);
        viaje.agregarEstadiaHotel(hotel.nombreHotel, "2018-09-10", "2018-09-18");
        viaje.agregarAsist();

        int costoEsperado = 8 * 30 + 8 * 2000;
        Integer diasEsperados = 9;
        assertEquals(costoEsperado, viaje.obtenerCostoViaje(), DELTA);
        assertEquals(diasEsperados, viaje.obtenerDuracionViaje(), DELTA);
    }

    // PRUEBAS VIAJE CON PAQUETE
    @Test
    public void test24ViajeConPaquete(){

        Viaje viaje = new Viaje("Alemania 2019");
        Paquete paquete = new Paquete("Berlinchesco");
        Hotel hotel = new Hotel("ElAleman", "Mun", 1500);
        Ciudad ciudad1 = new Ciudad("BER", "Berlín", "Alemania", 52.52, 13.40);
        Ciudad ciudad2 = new Ciudad("MUN", "Munich", "Alemania", 48.13, 11.58);
        VueloDomestico vueloIda = new VueloDomestico(ciudad1, ciudad2);
        VueloDomestico vueloVueta = new VueloDomestico(ciudad2, ciudad1);

        paquete.agregarHotel("ElAleman", hotel);
        paquete.agregarEstadiaHotel("ElAleman", "2018-09-10", "2018-09-19");
        paquete.agregarVuelo(vueloIda, "2018-09-09");
        paquete.agregarVuelo(vueloVueta, "2018-09-19");
        viaje.agregarPaquete(paquete, "Berlinchesco");

        double costoEsperado = 1500 * 9 * 0.8 + 504.91 * 2 * 0.9;
        int diasEsperados = 10;

        assertEquals(costoEsperado, viaje.obtenerCostoViaje(), DELTA);
        assertEquals(diasEsperados, viaje.obtenerDuracionViaje(), DELTA);
    }

    @Test
    public void test25ViajeConPaqueteYHotelAparte() {

        Viaje viaje = new Viaje("Alemania 2019");
        Paquete paquete = new Paquete("Berlinchesco");
        Hotel hotel = new Hotel("ElAleman", "Mun", 1500);
        Ciudad ciudad1 = new Ciudad("BER", "Berlín", "Alemania", 52.52, 13.40);
        Ciudad ciudad2 = new Ciudad("MUN", "Munich", "Alemania", 48.13, 11.58);
        VueloDomestico vueloIda = new VueloDomestico(ciudad1, ciudad2);
        VueloDomestico vueloVueta = new VueloDomestico(ciudad2, ciudad1);

        paquete.agregarHotel("ElAleman", hotel);
        paquete.agregarVuelo(vueloIda, "2018-09-09");
        paquete.agregarVuelo(vueloVueta, "2018-09-19");
        paquete.agregarEstadiaHotel("ElAleman", "2018-09-10", "2018-09-19");

        viaje.agregarPaquete(paquete, "Berlinchesco");

        double costoEsperado = 1500 * 9 * 0.8 + 504.91 * 2 * 0.9;
        assertEquals(costoEsperado, viaje.obtenerCostoViaje(), DELTA);
    }

    @Test
    public void test26ViajeConPaqueteHotelAparteYAsistencia() {

        Viaje viaje = new Viaje("Alemania 2019");
        Paquete paquete = new Paquete("Berlinchesco");
        Hotel hotel = new Hotel("ElAleman", "Mun", 1500);
        Ciudad ciudad1 = new Ciudad("BER", "Berlín", "Alemania", 52.52, 13.40);
        Ciudad ciudad2 = new Ciudad("MUN", "Munich", "Alemania", 48.13, 11.58);
        VueloDomestico vueloIda = new VueloDomestico(ciudad1, ciudad2);
        VueloDomestico vueloVueta = new VueloDomestico(ciudad2, ciudad1);

        paquete.agregarHotel("ElAleman", hotel);
        paquete.agregarEstadiaHotel(hotel.nombreHotel, "2018-09-10", "2018-09-19");
        paquete.agregarVuelo(vueloIda, "2018-09-10");
        paquete.agregarVuelo(vueloVueta, "2018-09-19");
        viaje.agregarPaquete(paquete, "Berlinchesco");
        viaje.agregarAsist();

        double costoEsperado = 1500 * 9 * 0.8 + 504.91 * 2 * 0.9;
        assertEquals(costoEsperado, viaje.obtenerCostoViaje(), DELTA);
    }

    @Test
    public void test27ViajeConPaqueteVueloAparteYAsistencia() {

        Viaje viaje = new Viaje("Alemania 2019");
        Paquete paquete = new Paquete("Berlinchesco");
        Hotel hotel = new Hotel("ElAleman", "Mun", 1500);
        Ciudad ciudad1 = new Ciudad("BER", "Berlín", "Alemania", 52.52, 13.40);
        Ciudad ciudad2 = new Ciudad("MUN", "Munich", "Alemania", 48.13, 11.58);
        Ciudad ciudad0 = new Ciudad("BUE", "Buenos Aires", "Argentina", -34.60, -58.38);
        VueloInternacional vueloParaLLegarDestino = new VueloInternacional(ciudad0, ciudad1);
        VueloDomestico vueloIda = new VueloDomestico(ciudad1, ciudad2);
        VueloDomestico vueloVueta = new VueloDomestico(ciudad2, ciudad1);

        viaje.agregarVuelo(vueloParaLLegarDestino, "2018-09-10");
        paquete.agregarVuelo(vueloIda, "2018-09-10");
        paquete.agregarVuelo(vueloVueta, "2018-09-19");
        paquete.agregarHotel("ElAleman", hotel);
        paquete.agregarEstadiaHotel(hotel.nombreHotel, "2018-09-09", "2018-09-19");
        viaje.agregarPaquete(paquete, "Berlinchesco");
        viaje.agregarAsist();

        double costoEsperado = 1500 * 10 * 0.8 + 504.91 * 2 * 0.9 + 11908.82 * 1.1 * 1.05 * 1.5;
        assertEquals(costoEsperado, viaje.obtenerCostoViaje(), DELTA);
    }

    @Test
    public void test28ViajeConPaqueteVueloAparteAsistenciaYComidaEspecial() {

        Viaje viaje = new Viaje("Alemania 2019");
        Paquete paquete = new Paquete("Berlinchesco");
        Hotel hotel = new Hotel("ElAleman", "Mun", 1500);
        Ciudad ciudad1 = new Ciudad("BER", "Berlín", "Alemania", 52.52, 13.40);
        Ciudad ciudad2 = new Ciudad("MUN", "Munich", "Alemania", 48.13, 11.58);
        Ciudad ciudad0 = new Ciudad("BUE", "Buenos Aires", "Argentina", -34.60, -58.38);
        VueloInternacional vueloParaLLegarDestino = new VueloInternacional(ciudad0, ciudad1);
        VueloDomestico vueloIda = new VueloDomestico(ciudad1, ciudad2);
        VueloDomestico vueloVueta = new VueloDomestico(ciudad2, ciudad1);

        viaje.agregarVuelo(vueloParaLLegarDestino, "2018-09-09");
        paquete.agregarHotel("ElAleman", hotel);
        paquete.agregarEstadiaHotel(hotel.nombreHotel, "2018-09-10", "2018-09-19");
        paquete.agregarVuelo(vueloIda, "2018-09-10");
        paquete.agregarVuelo(vueloVueta, "2018-09-19");
        viaje.agregarPaquete(paquete, "Berlinchesco");
        viaje.agregarAsist();
        viaje.agregarComidaEspecial();

        double costoEsperado = 1500 * 9 * 0.8 + 504.91 * 2 * 0.9 + 100 + 11908.82 * 1.1 * 1.05 *1.5;
        assertEquals(costoEsperado, viaje.obtenerCostoViaje(), DELTA);
    }
}
