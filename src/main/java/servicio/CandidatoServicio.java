/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import java.util.ArrayList;
import java.util.List;
import modelo.Candidato;

/**
 *
 * @author ASUS
 */
public class CandidatoServicio implements ICandidatoServicio{
    
    private static List<Candidato> candidatoList = new ArrayList<>();

    @Override
    public Candidato crear(Candidato candidato){
        var candidatoBuscado=this.buscarPorCodigo(candidato.getCodigo());
        if(candidatoBuscado==null){
            this.candidatoList.add(candidato);
        }
        else{
            throw new RuntimeException("El código ingresado ya se encuentra "
                    + "asignado al Capitán: "+candidatoBuscado.getNombre());            
        }
        return candidato;
    }

//    @Override
//    public Capitan crear(Capitan capitan) {
//        var capitanBuscado=this.buscarPorCodigo(capitan.getCodigo());
//        if(capitanBuscado==null){
//            this.capitanList.add(capitan);
//        }else{
//            throw new RuntimeException("El código ingresado ya se encuentra "
//                    + "asignado al Capitán: "+capitanBuscado.getNombre());
//        }
//        return capitan;
//    }    
    
    
    @Override
    public List<Candidato> listar() {
      return this.candidatoList;
    }

    @Override
    public Candidato modificar(int codigoCandidato, Candidato candidatoNuevo) {
        var posicion=this.buscarPosicion(this.buscarPorCodigo(codigoCandidato));
        this.listar().get(posicion).setNombre(candidatoNuevo.getNombre());
        this.listar().get(posicion).setCedula(candidatoNuevo.getCedula());
        this.listar().get(posicion).setFechaNacimiento(candidatoNuevo.getFechaNacimiento());
        this.listar().get(posicion).setPartidoPolitico(candidatoNuevo.getPartidoPolitico());
        this.listar().get(posicion).setDignidad(candidatoNuevo.getDignidad());
        return candidatoNuevo;
    }

    @Override
    public Candidato eliminar(int codigoCandidato) {
        Candidato candidato=this.buscarPorCodigo(codigoCandidato);
        var posicion=this.buscarPosicion(candidato);
        this.listar().remove(posicion);
        return candidato;
    }

    @Override
    public Candidato buscarPorCodigo(int codigoCandidato) {
        Candidato candidato=null;
        for(var e:this.candidatoList){
            if(codigoCandidato==e.getCodigo()){
                candidato=e;
                break;
            }
        }
        return candidato;
    }

    @Override
    public int buscarPosicion(Candidato candidato) {
        int posicion=-1;
        for(var e:this.candidatoList){
            posicion++;
            if(e.getCodigo()==candidato.getCodigo()){
                break;
            }
        }
        return posicion;
    }
    
    
}
