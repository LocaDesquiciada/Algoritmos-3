package fiuba.algo3.tp1;

public class ConAsistencia implements Asistencia {

    public Integer nochesHotel;
    public Double precioVuelo;

    public ConAsistencia(Integer valorHotel, Double valorVuelo) {

        this.nochesHotel = valorHotel;
        this.precioVuelo = valorVuelo;
    }

    public double calcularAsistenciaVuelo() {

        return this.precioVuelo * 1.1;
    }

    public double calcularAsistenciaHotel() {

        return  this.nochesHotel * 30;
    }

    public double costoViajeConAsistencia() {

        return this.calcularAsistenciaHotel() + this.calcularAsistenciaVuelo();

    }
}
