package fiuba.algo3.tp1;

public class Coordenada {

    public double latitud, longitud;
    //public Harversine formula;

    public Coordenada(Double latitude, Double longitude) {

        this.latitud = latitude;
        this.longitud = longitude;
       // this.formula = new Harversine();
    }

    public double calcularDistancia(Coordenada otraCiudad) {

        double distancia = Formulas.harvensine(this.latitud, this.longitud, otraCiudad.latitud, otraCiudad.longitud);
        distancia = (double) Math.round(distancia * 100.0 ) / 100.0;
        return distancia;
    }


}
