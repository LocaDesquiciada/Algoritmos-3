package fiuba.algo3.tp1;

public class Ciudad {

    private String nombreCiudad;
    private String codigoCiudad;
    public String paisCiudad;
    public double latitud, longitud;
    public Coordenada coordenadas;

    public Ciudad(String unCodigo, String unaCiudad, String unPais, double lat, double longitud) {

        this.nombreCiudad = unaCiudad;
        this.codigoCiudad = unCodigo;
        this.paisCiudad = unPais;
        this.latitud = lat;
        this.longitud = longitud;
        this.coordenadas = new Coordenada(this.latitud, this.longitud);
    }

    public void actualizarDatosCoordenadas(double lat, double longitud) {

        this.coordenadas = new Coordenada(lat, longitud);
    }

    public Boolean mismoPais(Ciudad nueva) {

        return this.paisCiudad.equals(nueva.paisCiudad);
    }

    public double calcularDistancia(Ciudad otraCiudad) {

        return this.coordenadas.calcularDistancia(otraCiudad.coordenadas);
    }

}
