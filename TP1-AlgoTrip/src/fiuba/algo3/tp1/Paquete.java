package fiuba.algo3.tp1;

import java.util.HashMap;
import java.util.Map;

public class Paquete {

    private String nombrePaquete;
    private CalculadoraDeNoches diasTotales;
    private Map <String, Hotel> hoteles;
    private Map <String, Vuelo> vuelos;

    private Double costoVuelo, costoHotel;

    public Paquete(String nombre) {

        this.nombrePaquete = nombre;
        this.diasTotales = new CalculadoraDeNoches();
        this.vuelos = new HashMap <String, Vuelo> ();
        this.hoteles = new HashMap <String, Hotel>();
    }

    public void agregarVuelo(Vuelo unVuelo, String fecha) {

        this.vuelos.put(fecha, unVuelo);
        this.diasTotales.agregarFecha(fecha);
    }

    public void agregarHotel(String nombre, Hotel unHotel) {

        this.hoteles.put(nombre, unHotel);
    }

    public void agregarEstadiaHotel(String nombreHotel, String checkIn, String checkOut){

        Hotel hotel = this.hoteles.get(nombreHotel);
        Estadia estadia = new Estadia(checkIn, checkOut);
        hotel.agregarEstadia(estadia);
        this.diasTotales.agregarFecha(checkIn);
        this.diasTotales.agregarFecha(checkOut);
    }

    public void obtenerCostoItems() {

        costoHotel = 0.0;
        costoVuelo = 0.0;
        for (Hotel hotel: hoteles.values()){
            costoHotel += hotel.precioHotelTotal();
        }
        for (Vuelo vuelo: vuelos.values()){
            costoVuelo += vuelo.calcularCostoVuelo();
        }
    }

    public double obtenerCostoPaquete() {

        this.obtenerCostoItems();
        return costoHotel * 0.8 + costoVuelo * 0.9;
    }

    public int obtenerDiasPaquete() {

        try {
            return this.diasTotales.nochesViaje();
        } catch (ValorNegativoError diasNegativos) {
            System.out.println(diasNegativos.getMessage());
            return 0;
        }
    }

}

