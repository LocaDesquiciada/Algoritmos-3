package fiuba.algo3.tp1;

public class SinAsistencia implements Asistencia {

    public double calcularAsistenciaVuelo() {

        return 0.0;
    }

    public double calcularAsistenciaHotel() {

        return 0.0;
    }

    public double costoViajeConAsistencia() {

        return this.calcularAsistenciaHotel() + this.calcularAsistenciaVuelo();

    }
}
