/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author ASUS
 */
public class Candidato {
    private String nombre;
    private int cedula;
    private LocalDate fechaNacimiento;
    private String partidoPolitico;
    private int codigo;
    private Dignidad dignidad;

    public Candidato(String nombre, int cedula, LocalDate fechaNacimiento, String partidoPolitico, int codigo, Dignidad dignidad) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.fechaNacimiento = fechaNacimiento;
        this.partidoPolitico = partidoPolitico;
        this.codigo = codigo;
        this.dignidad = dignidad;
    }

    public Candidato(String nombre, int cedula, LocalDate fechaNacimiento, String partidoPolitico, int codigo) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.fechaNacimiento = fechaNacimiento;
        this.partidoPolitico = partidoPolitico;
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPartidoPolitico() {
        return partidoPolitico;
    }

    public void setPartidoPolitico(String partidoPolitico) {
        this.partidoPolitico = partidoPolitico;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Dignidad getDignidad() {
        return dignidad;
    }

    public void setDignidad(Dignidad dignidad) {
        this.dignidad = dignidad;
    }

    @Override
    public String toString() {
        return "Candidato{" + "nombre=" + nombre + ", cedula=" + cedula +
               ", fechaNacimiento=" + fechaNacimiento + ", partidoPolitico=" +
               partidoPolitico + ", codigo=" + codigo +
               ", dignidad=" + dignidad.toString() + '}';
    }
    
    
    
}
