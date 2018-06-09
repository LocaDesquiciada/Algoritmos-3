package fiuba.algo3.tp1;

import java.util.*;

public class Viaje {

    private String nombreViaje;
    private CalculadoraDeNoches duracionViaje;
    private Asistencia asistencia;
    private ComidaEspecial plusComida;
    private HashMap <String, Vuelo> vuelos;
    private HashMap <String, Hotel> hoteles;
    private HashMap <String, Paquete> paquetes;

    private Integer diasTotales = 0;
    private Double costoPlusComida = 0.0;
    private Integer nochesHotel = 0;
    private Double costoTotal = 0.0;

    public Double costoVuelo, costoPaquete, costoHotel;

    public Viaje (String nameViaje) {

        this.nombreViaje = nameViaje;
        this.duracionViaje = new CalculadoraDeNoches();
        this.plusComida = new ComidaEspecial();
        this.asistencia = new SinAsistencia();
        this.vuelos = new HashMap <String, Vuelo>();
        this.hoteles = new HashMap <String, Hotel>();
        this.paquetes = new HashMap <String, Paquete>();
    }

    public void agregarVuelo(Vuelo unVuelo, String fecha) {

        this.vuelos.put(fecha, unVuelo);
        this.duracionViaje.agregarFecha(fecha);
        diasTotales = 1;
    }

    public void agregarHotel(String nombreHotel, Hotel unHotel) {

        this.hoteles.put(nombreHotel, unHotel);
    }

    public void agregarAsist() {

        this.obtenerCostoHoteles();
        this.obtenerCostoVuelos();
        this.asistencia = new ConAsistencia(nochesHotel, costoVuelo);
        costoTotal = costoHotel + this.asistencia.costoViajeConAsistencia();
    }

    public void agregarComidaEspecial() {

        costoPlusComida = this.plusComida.pedidoComidaEspecial(vuelos.size());
    }

    public void agregarEstadiaHotel(String nombreHotel, String checkIn, String checkOut){

        Hotel hotel = this.hoteles.get(nombreHotel);
        Estadia estadia = new Estadia(checkIn, checkOut);
        hotel.agregarEstadia(estadia);
        this.duracionViaje.agregarFecha(checkIn);
        this.duracionViaje.agregarFecha(checkOut);
        diasTotales = 1;
        nochesHotel = estadia.calcularDias();
    }

    public void agregarPaquete(Paquete unPaquete, String nombrePaquete){

        this.paquetes.put(nombrePaquete, unPaquete);
    }

    // CALCULADORES DE COSTO - VER PONER CLASE
    public Double obtenerCostoVuelos() {

        costoVuelo = 0.0;
        for (Vuelo vuelo: vuelos.values()) {
            costoVuelo += vuelo.calcularCostoVuelo();
        }
        return costoVuelo;
    }

    public Double obtenerCostoHoteles() {

        costoHotel = 0.0;
        for (Hotel hotel: hoteles.values()) {
            costoHotel += hotel.precioHotelTotal();
        }
        return costoHotel;
    }

    public Double obtenerCostoYDiasPaquetes() {

        costoPaquete = 0.0;
        for (Paquete paquete: paquetes.values()) {
            costoPaquete += paquete.obtenerCostoPaquete();
            diasTotales += paquete.obtenerDiasPaquete();
        }
        return costoPaquete;
    }

    public Double obtenerCostoViaje() {

        this.obtenerCostoVuelos();
        this.obtenerCostoHoteles();
        this.obtenerCostoYDiasPaquetes();

        if (costoTotal == 0.0)
            return costoVuelo + costoHotel + costoPaquete + costoPlusComida;
        return costoTotal + costoPlusComida + costoPaquete;

    }

    public Integer obtenerDuracionViaje() {

        try {
            diasTotales += this.duracionViaje.nochesViaje();
            return diasTotales;
        } catch (ValorNegativoError diasNegativos){
           System.out.println(diasNegativos.getMessage());
           return 0;
        }

    }
}
