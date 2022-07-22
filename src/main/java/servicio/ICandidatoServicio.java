/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package servicio;

import java.util.List;
import modelo.Candidato;

/**
 *
 * @author ASUS
 */
public interface ICandidatoServicio {
    public Candidato crear(Candidato candidato);
    public Candidato modificar(int codigoCandidato, Candidato candidatoNuevo);
    public Candidato eliminar(int codigoCandidato);
    public Candidato buscarPorCodigo(int codigoCandidato);
    public int buscarPosicion(Candidato candidato);
    public List<Candidato> listar();
    
}
