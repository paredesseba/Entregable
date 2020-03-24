package com.company;

public class ProfesorAdjunto extends Profesor {

    private Integer cantidadDeHoras;


    public ProfesorAdjunto(String nombre, String apellido, Integer codigoDeProfesor, Integer cantidadHorasConsulta) {
        super(nombre, apellido, codigoDeProfesor);
        this.cantidadDeHoras = cantidadHorasConsulta;
    }

    public Integer getCantidadDeHoras() {
        return cantidadDeHoras;
    }
}
