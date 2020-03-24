package com.company;

public class ProfesorAdjunto extends Profesor {

    private Integer cantidadHorasConsulta;


    public ProfesorAdjunto(String nombre, String apellido, Integer antiguedad, Integer codigoDeProfesor, Integer cantidadHorasConsulta) {
        super(nombre, apellido, antiguedad, codigoDeProfesor);
        this.cantidadHorasConsulta = cantidadHorasConsulta;
    }

    public Integer getCantidadHorasConsulta() {
        return cantidadHorasConsulta;
    }
}
