package com.company;

public class Main {

    public static void main(String[] args) {

        DigitalHouseManager manager = new DigitalHouseManager();

        manager.altaProfesorTitular("Edu","Parra",1,"Java");
        manager.altaProfesorTitular("Lopi","Fernandez",0,"Android");
        manager.altaProfesorAdjunto("Adjunto","Uno",10,24);
        manager.altaProfesorAdjunto("Adjunto","Dos",20,48);

        manager.altaCurso("Full Stack",20001,3);
        manager.altaCurso("Android",20002,2);

        manager.asignarProfesores(20001,1,10);
        manager.asignarProfesores(20002,0,20);

        manager.altaAlumno("Sebastian","Paredes",100);
        manager.altaAlumno("Belen","Barreto",101);
        manager.altaAlumno("Patricia","Belen",102);

        manager.inscribirAlumno(100,20001);
        manager.inscribirAlumno(101,20001);
        manager.inscribirAlumno(102,20002);
        manager.inscribirAlumno(101,20002);
        manager.inscribirAlumno(100,20002);

        manager.bajaProfesor(20);

        manager.bajaCurso(20001);



    }
}
