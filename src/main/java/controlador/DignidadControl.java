/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.List;
import modelo.Dignidad;
import modelo.Eleccion;
import servicio.DignidadServicio;
import servicio.EleccionServicio;

/**
 *
 * @author ASUS
 */
public class DignidadControl {
    
    private final DignidadServicio dignidadServicio = new DignidadServicio();
    private final EleccionServicio eleccionServicio = new EleccionServicio();
    
    public Dignidad crear(String[] args)throws RuntimeException{
        Eleccion eleccion =this.eleccionServicio.buscarPorCodigo(Integer.valueOf(args[5]));
        Dignidad dignidad = new Dignidad(args[0],args[1],args[2],args[3],Integer.valueOf(args[4]),eleccion);
        this.dignidadServicio.crear(dignidad);
        return dignidad;
    }
    
    private int convertirEntero(String numero){
        try
        {
            return Integer.valueOf(numero);
        }catch(NumberFormatException e){
            throw new RuntimeException("El campo ingresaso solamente recibe "
                    + "números");
        }catch(Exception e){
            throw new RuntimeException("Error inesperado");
        }
    }  
    
    public Dignidad buscarDignidad(String arg){
        return this.dignidadServicio.buscarPorCodigo(Integer.valueOf(arg));
    }
    
    public Dignidad eliminar(String arg)
    {
        return this.dignidadServicio.eliminar(Integer.valueOf(arg));
    }
    
    public Dignidad modificar(String [] args){
        Eleccion eleccion =this.eleccionServicio.buscarPorCodigo(Integer.valueOf(args[5]));
        Dignidad dignidadNueva = new Dignidad(args[0],args[1],args[2],args[3],Integer.valueOf(args[4]),eleccion);
        this.dignidadServicio.modificar(Integer.valueOf(args[4]), dignidadNueva);
        return dignidadNueva;
    }
    
    public List<Dignidad> listar(){
        return this.dignidadServicio.listar();
    }
}
