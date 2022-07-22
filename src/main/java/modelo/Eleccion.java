/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;

/**
 *
 * @author ASUS
 */
public class Eleccion {
    private String descripcion;
    private String tipo;
    private LocalDate fecha;
    private int numParticipantes;
    private String forma;
    private int codigo;

    public Eleccion(String descripcion, String tipo, LocalDate fecha, int numParticipantes, String forma, int codigo) {
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.fecha = fecha;
        this.numParticipantes = numParticipantes;
        this.forma = forma;
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getNumParticipantes() {
        return numParticipantes;
    }

    public void setNumParticipantes(int numParticipantes) {
        this.numParticipantes = numParticipantes;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Eleccion{" + "descripcion=" + descripcion + ", tipo=" + tipo +
               ", fecha=" + fecha + ", numParticipantes=" + numParticipantes + 
               ", forma=" + forma + ", codigo=" + codigo + '}';
    }
    
    
    
}
