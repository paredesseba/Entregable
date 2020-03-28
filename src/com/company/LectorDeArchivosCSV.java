package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LectorDeArchivosCSV {

    private List<Alumno> alumnos;

    private List<ArrayList<String>> datosAlumnos;


    public LectorDeArchivosCSV() {
        this.alumnos = new ArrayList<Alumno>();
        this.datosAlumnos = new ArrayList<ArrayList<String>>();
    }

    public List<Alumno> leerCSV (){

        Path filePath = Paths.get("C:\\Users\\pared\\Desktop\\Material_EntregableJava\\listadoDeAlumnos.csv");

        try{
            //creo el BR que me permite leer el csv
            BufferedReader br = Files.newBufferedReader(filePath);
            String linea;


            while ((linea = br.readLine()) != null) {
                String [] datosDeLinea = linea.split(",");

                //estos datos los guardo en un ArrayList temporal, que representa una linea, osea un alumno
                ArrayList<String> datosAlumno = new ArrayList<>();
                for (String dato : datosDeLinea) {
                    datosAlumno.add(dato);
                }

                //agrego el alumno al arraylist de arraylist string
                datosAlumnos.add(datosAlumno);
            }
            crearListaDeAlumnos();
        }
        catch (IOException e){
            e.printStackTrace();
        }

        return alumnos;
    }

    public void crearListaDeAlumnos(){
        List<String> alumnoTemporal;
        for (int i = 1; i < datosAlumnos.size(); i++) {
            alumnoTemporal = datosAlumnos.get(i);
            Alumno unAlumno = new Alumno(alumnoTemporal.get(1),alumnoTemporal.get(2),Integer.parseInt(alumnoTemporal.get(0)));
            alumnos.add(unAlumno);
        }
    }
}
