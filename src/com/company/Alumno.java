package com.company;

public class Alumno {

    private String nombre;
    private String apellido;
    private String codigoDeAlumno;

    public Alumno(String nombre, String apellido, String codigoDeAlumno) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigoDeAlumno = codigoDeAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCodigoDeAlumno() {
        return codigoDeAlumno;
    }

    public boolean equals (Object o){
        if (this == o){
            return true;
        }
        if (o == null){
            return false;
        }
        if (!(o instanceof Alumno)){
            return false;
        }
        Alumno alumnoAComparar = (Alumno) o;
        return  (alumnoAComparar.getCodigoDeAlumno().equals(this.codigoDeAlumno));
    }
}
