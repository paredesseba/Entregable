package com.company;

import java.util.ArrayList;
import java.util.List;

public class DigitalHouseManager {

    private List<Alumno> listaDeAlumnos;
    private List<Profesor> listaDeProfesores;
    private List<Curso> listaDeCursos;
    private List<Inscripcion> listaDeInscripciones;
    private LectorDeArchivosCSV lectorDeArchivosCSV;

    public DigitalHouseManager() {
        this.listaDeInscripciones = new ArrayList<>();
        this.listaDeAlumnos = new ArrayList<>();
        this.listaDeProfesores = new ArrayList<>();
        this.listaDeCursos = new ArrayList<>();
        this.lectorDeArchivosCSV = new LectorDeArchivosCSV();
    }

    public void altaCurso(String nombre, Integer codigoCurso, Integer cupoMaximoDealumnos){
        Curso unCurso = new Curso(nombre,codigoCurso,cupoMaximoDealumnos);
        listaDeCursos.add(unCurso);
        System.out.println("Curso dado de alta.");
    }

    public Curso buscarCurso(Integer codigoCurso){
        Curso cursoABuscar = null;
        for (Curso curso : this.listaDeCursos) {
            if (curso.getCodigoDeCurso().equals(codigoCurso)){
                cursoABuscar = curso;
                break;
            }
        }
        return cursoABuscar;
    }

    public void bajaCurso(Integer codigoCurso){
        Curso cursoAEliminar = buscarCurso(codigoCurso);
        listaDeCursos.remove(cursoAEliminar);
        System.out.println("Curso dado de baja.");
    }

    public void altaProfesorAdjunto(String nombre, String apellido, Integer codigoProfesor, Integer cantidadDeHoras){
        ProfesorAdjunto unProfesorAdjunto = new ProfesorAdjunto(nombre,apellido,codigoProfesor,cantidadDeHoras);
        listaDeProfesores.add(unProfesorAdjunto);
        System.out.println("Profesor Adjunto dado de alta.");
    }

    public void altaProfesorTitular(String nombre, String apellido, Integer codigoProfesor, String especialidad){
        ProfesorTitular unProfesorTitular = new ProfesorTitular(nombre,apellido,codigoProfesor,especialidad);
        listaDeProfesores.add(unProfesorTitular);
        System.out.println("Profesor Titular dado de alta");
    }

    public Profesor buscarProfesor (Integer codigoProfesor){
        Profesor profesorABuscar = null;
        for (Profesor profesor : this.listaDeProfesores) {
            if (profesor.getCodigoDeProfesor().equals(codigoProfesor)){
                profesorABuscar = profesor;
                break;
            }
        }
        return profesorABuscar;
    }

    public void bajaProfesor(Integer codigoProfesor){
        Profesor profesorAEliminar = buscarProfesor(codigoProfesor);
        listaDeProfesores.remove(profesorAEliminar);
        System.out.println("Profesor dado de baja.");
    }

    public void altaAlumno(String nombre, String apellido, Integer codigoAlumno){
        Alumno unAlumno = new Alumno(nombre,apellido,codigoAlumno);
        listaDeAlumnos.add(unAlumno);
        System.out.println("Alumno dado de alta.");
    }

    public Alumno buscarAlumno (Integer codigoAlumno){
        Alumno alumnoABuscar = null;
        for (Alumno alumno : this.listaDeAlumnos) {
            if (alumno.getCodigoDeAlumno().equals(codigoAlumno)){
                alumnoABuscar = alumno;
                break;
            }
        }
        return alumnoABuscar;
    }

    public void inscribirAlumno(Integer codigoAlumno, Integer codigoCurso){
        Alumno alumnoABuscar = buscarAlumno(codigoAlumno);
        Curso cursoABuscar = buscarCurso(codigoCurso);
        if (cursoABuscar.hayCupo()){
            cursoABuscar.agregarUnAlumno(alumnoABuscar);
            Inscripcion unaInscripcion = new Inscripcion(alumnoABuscar,cursoABuscar);
            listaDeInscripciones.add(unaInscripcion);
            System.out.println("Inscripcion exitosa.");
        }
        else {
            System.out.println("No hay cupo. No se pudo realizar la inscripcion.");
        }
    }

    public void asignarProfesores(Integer codigoCurso, Integer codigoProfesorTitular, Integer codigoProfesorAdjunto){
        ProfesorTitular titularABuscar = (ProfesorTitular) buscarProfesor(codigoProfesorTitular);
        ProfesorAdjunto adjuntoABuscar = (ProfesorAdjunto) buscarProfesor(codigoProfesorAdjunto);
        Curso cursoABuscar = buscarCurso(codigoCurso);
        cursoABuscar.setProfesorTitular(titularABuscar);
        cursoABuscar.setProfesorAdjunto(adjuntoABuscar);
    }

    public void inscribirAlumnosEnAndroid (){
        final Integer NUMERO_CURSO_ANDROID = 20002;
        List<Alumno> alumnosAInscribir = lectorDeArchivosCSV.leerCSV();
        for (int i = 0; i < alumnosAInscribir.size(); i++) {
            Alumno unAlumno = alumnosAInscribir.get(i);
            altaAlumno(unAlumno.getNombre(),unAlumno.getApellido(),unAlumno.getCodigoDeAlumno());
            inscribirAlumno(unAlumno.getCodigoDeAlumno(),NUMERO_CURSO_ANDROID);
        }
    }

}
