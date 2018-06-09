package fiuba.algo3.tp1;

public class VueloInternacional extends Vuelo {

    private Double COSTO_X_KILOMETRO = 1.5;
    private Double IMPUESTO = 1.05;

    public VueloInternacional(Ciudad inicio, Ciudad fin){

        super(inicio, fin);
    }

    public double calcularCostoVuelo() {

        return super.obtenerCostoDistancia(COSTO_X_KILOMETRO, IMPUESTO);
    }
}
