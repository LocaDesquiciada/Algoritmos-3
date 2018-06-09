package fiuba.algo3.tp1;

public abstract class Vuelo {

    public Ciudad ciudadPartida;
    public Ciudad ciudadLlegada;

    public Vuelo(Ciudad ciudad1, Ciudad ciudad2) {

        this.ciudadPartida = ciudad1;
        this.ciudadLlegada = ciudad2;
    }

    public Double obtenerCostoDistancia(Double precioxkm, Double imp) {

        Double distancia = this.ciudadPartida.calcularDistancia(this.ciudadLlegada);
        return distancia * precioxkm * imp;
    }

    public abstract double calcularCostoVuelo();
}
