package com.company;

public class Curso {
    private String nombre;
    private Integer codigoDeCurso;

    public Curso(String nombre, Integer codigoDeCurso) {
        this.nombre = nombre;
        this.codigoDeCurso = codigoDeCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getCodigoDeCurso() {
        return codigoDeCurso;
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
