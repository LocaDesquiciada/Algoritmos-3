package fiuba.algo3.tp1;

import javax.lang.model.type.ErrorType;
import java.util.*;

public class AlgoTrip {

   private Map <String, Viaje> viajes;
   private Map <String, Ciudad> ciudades;
   private Map <String, Hotel> hoteles;
   private Map <String, Paquete> paquetes;
   private Vuelo vuelo;

   // METODOS PEDIDOS DE ALGOTRIP

   public AlgoTrip(){

       this.viajes = new HashMap <String, Viaje>();
       this.hoteles = new HashMap <String, Hotel>();
       this.ciudades = new HashMap <String, Ciudad>();
       this.paquetes = new HashMap <String, Paquete>();
   }

   // VIAJE

   public void crearViaje(String nombreViaje) {

		Viaje nuevoViaje = new Viaje(nombreViaje);
		this.viajes.put(nombreViaje, nuevoViaje);
   }

   public void agregarCiudad(String unCodigo, String unaCiudad, String unPais, Double latitud, Double longitud) {

       if ( this.ciudades.containsKey(unCodigo) ){
           Ciudad ciudadExistente = this.ciudades.get(unCodigo);
           ciudadExistente.actualizarDatosCoordenadas(latitud, longitud);
       } else {
           Ciudad ciudad = new Ciudad(unCodigo, unaCiudad, unPais, latitud, longitud);
           this.ciudades.put(unCodigo, ciudad);
       }
   }

   public void agregarHotel(String nombreHotel, String unCodigo, Integer unPrecio){

       if (unPrecio < 0) throw new ValorNegativoError("El precio del hotel no puede ser negativo.");
       Hotel hotel = new Hotel(nombreHotel, unCodigo, unPrecio);
       this.hoteles.put(nombreHotel, hotel);

   }

   public void agregarVueloEnViaje(String unViaje, String ciudad1, String ciudad2, String unaFecha){

       this.crearVuelo(ciudad1, ciudad2);
       Viaje viaje = this.viajes.get(unViaje);
       if (viaje == null) throw new ViajeInexistenteError();
       viaje.agregarVuelo(vuelo, unaFecha);
   }

   public void agregarEstadiaEnViaje(String nombreViaje, String nombreHotel, String checkIn, String checkOut) {

      Viaje viaje = this.viajes.get(nombreViaje);
      if (viaje == null) throw new ViajeInexistenteError();
      Hotel hotel = this.hoteles.get(nombreHotel);
      if (hotel == null) throw new HotelInexistenteError();
      viaje.agregarHotel(nombreHotel, hotel);
      viaje.agregarEstadiaHotel(nombreHotel, checkIn, checkOut);
   }

   public void agregarAsistenciaAlViajeroAlViaje(String unViaje) {

       if (this.viajes.get(unViaje) == null) throw new ViajeInexistenteError();
       this.viajes.get(unViaje).agregarAsist();
   }

   public void solicitarComidaEspecialAbordoPara(String nombreViaje) {

       Viaje viaje = this.viajes.get(nombreViaje);
       if (viaje == null) throw new ViajeInexistenteError();
       viaje.agregarComidaEspecial();
   }

   // PAQUETE

   public void agregarPaquete(String nombrePaquete) {

       Paquete paquete = new Paquete(nombrePaquete);
       this.paquetes.put(nombrePaquete, paquete);
   }

   public void agregarVueloEnPaquete(String unPaquete, String ciudad1, String ciudad2, String unaFecha) {

       this.crearVuelo(ciudad1, ciudad2);
       Paquete paquete = this.paquetes.get(unPaquete);
       if (paquete == null) throw new PaqueteInexistenteError();
       paquete.agregarVuelo(vuelo, unaFecha);
   }

   public void agregarEstadiaEnPaquete(String unPaquete, String nombreHotel, String checkIn, String checkOut) {

        Paquete paquete = this.paquetes.get(unPaquete);
        if (paquete == null) throw new PaqueteInexistenteError();
        Hotel hotel = this.hoteles.get(nombreHotel);
        if (hotel == null) throw new HotelInexistenteError();
        paquete.agregarHotel(nombreHotel, hotel);
        paquete.agregarEstadiaHotel(nombreHotel, checkIn, checkOut);
   }

   public void agregarPaqueteEnViaje(String unViaje, String unPaquete) {

       Viaje viaje = this.viajes.get(unViaje);
       if (viaje == null) throw new ViajeInexistenteError();
       viaje.agregarPaquete(this.paquetes.get(unPaquete), unPaquete);
   }

   // Totales
   public Double obtenerCostoDelViaje(String nombreViaje) {

       if (this.viajes.get(nombreViaje) == null) throw new ViajeInexistenteError();
       return this.viajes.get(nombreViaje).obtenerCostoViaje();
   }

   public Integer obtenerDuracionEnDiasDelViaje(String nombreViaje) {

       if (this.viajes.get(nombreViaje) == null) throw new ViajeInexistenteError();
       return this.viajes.get(nombreViaje).obtenerDuracionViaje();
   }

   // AUXILIARES
   public void crearVuelo(String ciudad1, String ciudad2){

       if (this.ciudades.get(ciudad1) == null)throw new CiudadInexistenteError();
       if (this.ciudades.get(ciudad2) == null)throw new CiudadInexistenteError();
       Ciudad city1 = this.ciudades.get(ciudad1);
       Ciudad city2 = this.ciudades.get(ciudad2);

       if ( city1.mismoPais(city2) ) {
           vuelo = new VueloDomestico(city1, city2);
       } else {
           vuelo = new VueloInternacional(city1, city2);
       }
   }
}
