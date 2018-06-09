package fiuba.algo3.tp1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Hotel {

    public String nombreHotel;
    private String codigoCiudad;
    private Estadia estadia;
    public Integer precio;

    public Hotel(String nombre, String codigo, Integer valor) {

        this.nombreHotel = nombre;
        this.codigoCiudad = codigo;
        this.precio = valor;
    }

    public void agregarEstadia(Estadia estadiaNueva){

        this.estadia = estadiaNueva;
    }

    public int cantidadNoches() {

        return this.estadia.calcularDias();
    }

    public double precioHotelTotal() {

        return this.estadia.precioEstadia(this.precio);
    }
}
