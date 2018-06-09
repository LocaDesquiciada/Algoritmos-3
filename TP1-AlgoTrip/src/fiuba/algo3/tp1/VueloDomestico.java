package fiuba.algo3.tp1;

public class VueloDomestico extends Vuelo {

    private Double COSTO_X_KILOMETRO = 1.0;
    private Double IMPUESTO = 1.0; // CREADO PARA LA FUNCION (ya que recibe de vuelo internacional un impuesto)

    public VueloDomestico(Ciudad inicio, Ciudad fin){

        super(inicio, fin);
    }

    public double calcularCostoVuelo() {

        return super.obtenerCostoDistancia(COSTO_X_KILOMETRO, IMPUESTO);
    }
}
