
package Conexion;

public class Inscripcion {
    private int idInscripto;
    private double nota;
    private Alumno alumno;
    private Materia materia;
    private int añoCursada;

    public Inscripcion(Alumno alumno, Materia materia, int añoCursada) {
        this.alumno = alumno;
        this.materia = materia;
        this.añoCursada = añoCursada;
    }

    public int getIdInscripto() {
        return idInscripto;
    }

    public void setIdInscripto(int idInscripto) {
        this.idInscripto = idInscripto;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public int getAñoCursada() {
        return añoCursada;
    }

    public void setAñoCursada(int añoCursada) {
        this.añoCursada = añoCursada;
    }
    
    
}

