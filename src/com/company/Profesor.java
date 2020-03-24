package com.company;

public abstract class Profesor {

    private static final Integer ANTIGUEDAD = 0;

    private String nombre;
    private String apellido;
    private Integer codigoDeProfesor;

    public Profesor(String nombre, String apellido, Integer codigoDeProfesor) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigoDeProfesor = codigoDeProfesor;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Integer getCodigoDeProfesor() {
        return codigoDeProfesor;
    }

    public boolean equals (Object o){
        if (this == o){
            return true;
        }
        if (o == null){
            return false;
        }
        if (!(o instanceof Profesor)){
            return false;
        }
        Profesor profesorAComparar = (Profesor) o;
        return  (profesorAComparar.getCodigoDeProfesor().equals(this.codigoDeProfesor));
    }
}
