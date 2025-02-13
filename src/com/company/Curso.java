package com.company;

import java.util.*;

public class Curso {
    private String nombre;
    private Integer codigoDeCurso;
    private ProfesorTitular profesorTitular;
    private ProfesorAdjunto profesorAdjunto;
    private Integer cupoMaximoDeAlumnos;
    private List<Alumno> listaDeAlumnos;

    public Curso(String nombre, Integer codigoDeCurso, Integer cupoMaximoDeAlumnos) {
        this.nombre = nombre;
        this.codigoDeCurso = codigoDeCurso;
        this.profesorTitular = null;
        this.profesorAdjunto = null;
        this.cupoMaximoDeAlumnos = cupoMaximoDeAlumnos;
        this.listaDeAlumnos = new ArrayList<Alumno>();
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getCodigoDeCurso() {
        return codigoDeCurso;
    }

    public List<Alumno> getListaDeAlumnos() {
        return listaDeAlumnos;
    }


    public ProfesorTitular getProfesorTitular(){
        return profesorTitular;
    }

    public ProfesorAdjunto getProfesorAdjunto() {
        return profesorAdjunto;
    }

    public void setProfesorTitular(ProfesorTitular profesorTitular) {
        this.profesorTitular = profesorTitular;
    }

    public void setProfesorAdjunto(ProfesorAdjunto profesorAdjunto) {
        this.profesorAdjunto = profesorAdjunto;
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

    public Boolean hayCupo() {
        return this.cupoMaximoDeAlumnos > this.listaDeAlumnos.size();
    }

    public Boolean agregarUnAlumno(Alumno unAlumno){
        if (hayCupo()){
            this.listaDeAlumnos.add(unAlumno);
            System.out.println("Alumno agregado.");
            return true;
        }
        else {
            System.out.println("No hay cupo.");
            return false;
        }
    }

    public void eliminarAlumno(Alumno unAlumno){
        this.listaDeAlumnos.remove(unAlumno);
        System.out.println("Alumno eliminado.");
    }

}
