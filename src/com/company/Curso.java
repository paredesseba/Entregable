package com.company;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String nombre;
    private Integer codigoDeCurso;
    private ProfesorTitular profesorTitular;
    private ProfesorAdjunto profesorAdjunto;
    private Integer cupoMaximoDeAlumnos;
    private List<Alumno> listaDeAlumnos;

    public Curso(String nombre, Integer codigoDeCurso, ProfesorTitular profesorTitular, ProfesorAdjunto profesorAdjunto, Integer cupoMaximoDeAlumnos) {
        this.nombre = nombre;
        this.codigoDeCurso = codigoDeCurso;
        this.profesorTitular = profesorTitular;
        this.profesorAdjunto = profesorAdjunto;
        this.cupoMaximoDeAlumnos = cupoMaximoDeAlumnos;
        this.listaDeAlumnos = new ArrayList<Alumno>();
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getCodigoDeCurso() {
        return codigoDeCurso;
    }

    public ProfesorTitular getProfesorTitular(){
        return profesorTitular;
    }

    public ProfesorAdjunto getProfesorAdjunto() {
        return profesorAdjunto;
    }

    public Integer getCupoMaximoDeAlumnos() {
        return cupoMaximoDeAlumnos;
    }

    public boolean equals (Object o){
        if (this == o){
            return true;
        }
        if (o == null){
            return false;
        }
        if (!(o instanceof Curso)){
            return false;
        }
        Curso cursoAComparar = (Curso) o;
        return  (cursoAComparar.getCodigoDeCurso().equals(this.codigoDeCurso));
    }
}
