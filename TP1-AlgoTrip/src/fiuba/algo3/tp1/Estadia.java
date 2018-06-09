package fiuba.algo3.tp1;

public class Estadia {

    private String checkIn, checkOut;
    private CalculadoraDeNoches cantNoches;

    public Estadia(String fechaInicial, String fechaFinal){

        this.checkIn = fechaInicial;
        this.checkOut = fechaFinal;
        this.cantNoches = new CalculadoraDeNoches();
    }

    public Integer calcularDias() {

        this.cantNoches.agregarFecha(this.checkIn);
        this.cantNoches.agregarFecha(this.checkOut);
        try {
            return this.cantNoches.nochesViaje();
        } catch (ValorNegativoError diasNegativos) {
            System.out.println(diasNegativos.getMessage());
            return 0;
        }
    }

    public Integer precioEstadia(Integer precio) {

        return this.calcularDias() * precio;
    }
}
