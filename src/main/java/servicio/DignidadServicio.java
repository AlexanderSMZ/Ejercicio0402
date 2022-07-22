/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import modelo.Dignidad;

/**
 *
 * @author ASUS
 */
public class DignidadServicio implements IDignidadServicio{
   private static List<Dignidad> dignidadList = new ArrayList<>(); 

    @Override
    public Dignidad crear(Dignidad dignidad) {
        
        var dignidadBuscado=this.buscarPorCodigo(dignidad.getCodigo());
        if(dignidadBuscado==null){
            this.dignidadList.add(dignidad);
        try{
            this.almacenarEnArchivo(dignidad,"C:/Carpeta11/dignidad.obj");            
        }catch(Exception ex){
            throw new RuntimeException("El barco no se pudo almacenar en el "
                    + "archivo de objetos"+ex.getMessage());
        }            
        }else{
            throw new RuntimeException("El código ingresado ya se encuentra "
                    + "asignado al Dignidad: "+dignidadBuscado.getParroquia());    
        }
        return dignidad;
    }     

    
    @Override
    public List<Dignidad> listar() {
        return this.dignidadList;
    }

    @Override
    public Dignidad modificar(int codigoDignidad, Dignidad dignidadNueva) {
        var posicion=this.buscarPosicion(this.buscarPorCodigo(codigoDignidad));
        this.listar().get(posicion).setCargo(dignidadNueva.getCargo());
        this.listar().get(posicion).setParroquia(dignidadNueva.getParroquia());
        this.listar().get(posicion).setCanton(dignidadNueva.getCanton());
        this.listar().get(posicion).setProvincia(dignidadNueva.getProvincia());
        this.listar().get(posicion).setEleccion(dignidadNueva.getEleccion());
        return dignidadNueva;
    }

    @Override
    public Dignidad eliminar(int codigoDignidad) {
        Dignidad dignidad=this.buscarPorCodigo(codigoDignidad);
        var posicion=this.buscarPosicion(dignidad);
        this.listar().remove(posicion);
        return dignidad;
    }

    @Override
    public Dignidad buscarPorCodigo(int codigoDignidad) {
        Dignidad dignidad=null;
        for(var b:this.dignidadList){
            if(codigoDignidad==b.getCodigo()){
                dignidad=b;
                break;
            }
        }
        return dignidad;
    }

    @Override
    public int buscarPosicion(Dignidad dignidad) {
        int posicion=-1;
        for(var b:this.dignidadList){
            posicion++;
            if(b.getCodigo()==dignidad.getCodigo()){
                break;
            }
        }
        return posicion;
    }

    @Override
    public boolean almacenarEnArchivo(Dignidad dignidad, String rutaArchivo) throws Exception{
        ObjectOutputStream salida=null;
        var retorno=false;
        try{
            salida = new ObjectOutputStream(new FileOutputStream(new File(rutaArchivo),true));
            salida.writeObject(dignidad);
        }catch(Exception el){
            salida.close(); 
        }
        
        return retorno;
    }

    @Override
    public List<Dignidad> recuperarDeArchivo(String rutaArchivo) throws Exception {
        return new ArrayList<Dignidad>();
    }

    
}
