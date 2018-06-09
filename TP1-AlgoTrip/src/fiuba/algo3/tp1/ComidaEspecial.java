package fiuba.algo3.tp1;

public class ComidaEspecial {

    public Double plusComida;

    public ComidaEspecial() {

        this.plusComida = 0.0;
    }

    public Double pedidoComidaEspecial(int cantVuelos) {

        for (int i = 0; i < cantVuelos; i++) {
            this.plusComida += 100;
        }
        return plusComida;
    }
}