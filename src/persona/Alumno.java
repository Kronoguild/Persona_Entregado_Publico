/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persona;

public class Alumno extends Persona {

    public Alumno() {
        cantMatAprob = 0;
        promedio = 0;
        try {
            fechaIngr = new MiCalendar(1, 1, 1900);
        } catch (FechaInvalidaException ex) {
        }
    }

    public Alumno(int cantMatAprob, double promedio, MiCalendar fechaIngr, int dni, String apyn, MiCalendar fechaNac, char sexo) throws PersonaInvalidaException {
        super(dni, apyn, fechaNac, sexo);
        this.cantMatAprob = cantMatAprob;
        setPromedio(promedio);
        this.fechaIngr = fechaIngr;
    }

    public int getCantMatAprob() {
        return cantMatAprob;
    }

    public void setCantMatAprob(int cantMatAprob) {
        this.cantMatAprob = cantMatAprob;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) throws AlumnoInvalidoException {
        if (promedio < 0) {
            throw new AlumnoInvalidoException("El promedio es erroneo.");
        }

        this.promedio = promedio;
    }

    public MiCalendar getFechaIngr() {
        return fechaIngr;
    }

    public void setFechaIngr(MiCalendar fechaIngr) {
        this.fechaIngr = fechaIngr;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return super.toString() + DELIM + String.format("%02d", cantMatAprob) + DELIM + String.format(" %.2f", promedio) + DELIM + fechaIngr; //To change body of generated methods, choose Tools | Templates.
    }

    private int cantMatAprob;
    private double promedio;
    private MiCalendar fechaIngr;
    private char estado;
}
