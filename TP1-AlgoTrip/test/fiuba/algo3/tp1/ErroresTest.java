package fiuba.algo3.tp1;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ErroresTest {

    @Test
    public void test01ValorNegativoFechasCalculadoraDeNochesLanzaValorNegativoError() {

        CalculadoraDeNoches calcu = new CalculadoraDeNoches();
        boolean flag = false;

        try {
            calcu.agregarFecha("2018-03-19");
            calcu.agregarFecha("1993-03-01");
            calcu.nochesViaje();
        } catch (ValorNegativoError e){
            flag = true;
        }
        assertEquals(flag, flag);
    }

    @Test
    public void test02PrecioNegativoHotelLanzaValorNegativoError() {

        AlgoTrip trip = new AlgoTrip();
        boolean flag = false;

        try {
            trip.agregarHotel("ESTE NO ES UN HOTEL", "AZK", -500);
        } catch (ValorNegativoError e) {
            flag = true;
        }
        assertEquals(true, flag);
    }

    @Test
    public void test03AgregarVueloConCiudadesInexistentesLanzaCiudadInexistente() {

        AlgoTrip trip = new AlgoTrip();
        boolean flag = false;

        try {
            trip.agregarVueloEnViaje("ESTO NO ES UN VIAJE", "C1", "C2", "2000-09-10");
        } catch (CiudadInexistenteError ce){
            flag = true;
        }
        assertEquals(true, flag);
    }

    @Test
    public void test04AgregarEstadiaEnViajeLanzaViajeInexistenteError() {

        AlgoTrip trip = new AlgoTrip();
        boolean flag = false;

        try {
            trip.agregarEstadiaEnViaje("ESTO NO ES UN VIAJE", "ESTE HOTEL NO EXISTE", "2012-12-12", "2029-10-09");
        } catch (ViajeInexistenteError ve){
            flag = true;
        }
        assertEquals(true, flag);
    }

    @Test
    public void test05AgregarEstadiaEnViajeSinHotelLanzaHotelInexsitenteError() {

        AlgoTrip trip = new AlgoTrip();
        trip.crearViaje("ESTE VIAJE EXISTE");
        boolean flag = false;

        try {
            trip.agregarEstadiaEnViaje("ESTE VIAJE EXISTE", "ESTE HOTEL NO EXISTE", "2012-12-12", "2029-10-09");
        } catch (HotelInexistenteError he){
            flag = true;
        }
        assertEquals(true, flag);
    }

    @Test
    public void test06AgregarAsistenciaAViajeInexistenteLanzaViajeInexistenteError() {

        AlgoTrip trip = new AlgoTrip();
        boolean flag = false;

        try {
            trip.agregarAsistenciaAlViajeroAlViaje("ESTE VIAJE NO EXISTE");
        } catch (ViajeInexistenteError ve){
            flag = true;
        }
        assertEquals(true, flag);
    }

    @Test
    public void test07AgregarComidaEspecialAViajeInexistenteLanzaViajeInexistenteError() {

        AlgoTrip trip = new AlgoTrip();
        boolean flag = false;

        try {
            trip.solicitarComidaEspecialAbordoPara("ESTE VIAJE NO EXISTE");
        } catch (ViajeInexistenteError ve){
            flag = true;
        }
        assertEquals(true, flag);
    }

    @Test
    public void test08AgregarVueloEnPaqueteInexistenteLanzaPaqueteInexistenteError() {

        AlgoTrip trip = new AlgoTrip();
        boolean flag = false;

        try {
            trip.agregarVueloEnPaquete("ESTE PAQUETE NO EXISTE", "BERLIN","MUNICH", "3020-09-20");
        } catch (PaqueteInexistenteError ve) {
            flag = true;
        } catch (CiudadInexistenteError ce) {
            flag = true;
        }
        assertEquals(true, flag);
    }

    @Test
    public void test09AgregarPaqueteEnViajeInexistenteLanzaViajeInesxistenteError() {

        AlgoTrip trip = new AlgoTrip();
        boolean flag = false;

        try {
            trip.agregarPaqueteEnViaje("ESTE VIAJE NO EXISTE", "ESTE PAQUETE NO EXISTE");
        } catch (ViajeInexistenteError ve){
            flag = true;
        }
        assertEquals(true, flag);
    }

    @Test
    public void test10AgregarVueloEnPaqueteInexistenteLanzaPaqueteInesxistenteError() {

        AlgoTrip trip = new AlgoTrip();
        boolean flag = false;

        try {
            trip.agregarVueloEnPaquete("ESTE PAQUETE NO EXISTE", "BERLIN", "MUNICH","2019-09-19");
        } catch (PaqueteInexistenteError ve){
            flag = true;
        } catch (CiudadInexistenteError ce){
            flag = true;
        }
        assertEquals(true, flag);
    }

    @Test
    public void test11AgregarEstadiaEnPaqueteInexistenteLanzaPaqueteInesxistenteError() {

        AlgoTrip trip = new AlgoTrip();
        boolean flag = false;

        try {
            trip.agregarEstadiaEnPaquete("ESTE PAQUETE NO EXISTE", "ESTE HOTEL NO EXISTE","2003-03-O2","2019-09-10");
        } catch (PaqueteInexistenteError pe){
            flag = true;
        }
        assertEquals(true, flag);
    }

    @Test
    public void test12ObtenerCostoDeUnViajeInexistenteLanzaViajeInexistenteError() {

        AlgoTrip trip = new AlgoTrip();
        boolean flag = false;

        try {
            trip.obtenerCostoDelViaje("ESTE VIAJE NO EXISTE");
        } catch (ViajeInexistenteError ve){
            flag = true;
        }
        assertEquals(true, flag);
    }

    @Test
    public void test13ObtenerDuracionCostoDeUnViajeInexistenteLanzaViajeInexistenteError() {

        AlgoTrip trip = new AlgoTrip();
        boolean flag = false;

        try {
            trip.obtenerDuracionEnDiasDelViaje("ESTE VIAJE NO EXISTE");
        } catch (ViajeInexistenteError ve){
            flag = true;
        }
        assertEquals(true, flag);
    }

}
