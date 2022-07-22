/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import modelo.Eleccion;

/**
 *
 * @author ASUS
 */
public class EleccionServicio implements IEleccionServicio{
    
    private static List<Eleccion> eleccionList = new ArrayList<>();

    @Override
    public Eleccion crear(Eleccion eleccion) {
        var eleccionBuscado=this.buscarPorCodigo(eleccion.getCodigo());
        if(eleccionBuscado==null){
           this.eleccionList.add(eleccion); 
           
        }else{
            throw new RuntimeException("El código ingresado ya se encuentra "
                    + "asignado al Servicio: "+eleccionBuscado.getDescripcion());            
        }
           
        try{
            this.almacenarEnArchivo(eleccion,"C:/carpeta1/archivoEleccion.dat");
        }catch(Exception ex){    
            throw new RuntimeException("No se puede almacenar en archivo"+ex.getMessage());               
        }
        return eleccion;
    }    
    
    
    @Override
    public List<Eleccion> listar() {
        
        return this.eleccionList;
    }

    @Override
    public Eleccion buscarPorCodigo(int codigoEleccion) {
        Eleccion eleccion=null;
        for(var c:this.eleccionList){
            if(codigoEleccion==c.getCodigo()){
                eleccion=c;
                break;
            }
        }
        return eleccion;
    }

    @Override
    public boolean almacenarEnArchivo(Eleccion eleccion,String rutaArchivo) throws Exception {
        var retorno=false;
        DataOutputStream salida = null;        
        try{
            salida = new DataOutputStream(new FileOutputStream(rutaArchivo,true));
            salida.writeInt(eleccion.getCodigo());
            salida.writeUTF(eleccion.getDescripcion());
            salida.writeInt(eleccion.getNumParticipantes());
            salida.writeUTF(eleccion.getForma());
            salida.writeUTF(eleccion.getTipo());
            salida.close();
            retorno=true;
        }catch(IOException e){
            salida.close();
        }
        return retorno;
    }

//    @Override
//    public List<Eleccion> recuperarDeArchivo(String rutaArchivo) throws Exception {
//        var eleccionList = new ArrayList<Eleccion>();
//        DataInputStream entrada=null;
//        try{
//            entrada = new DataInputStream(new FileInputStream(rutaArchivo));
//            
//        }
//        return new ArrayList<Eleccion>();
//    }
 

//    @Override
//    public List<Capitan> recuperarDeArchivo(String rutaArchivo) throws Exception {
//        var capitanList = new ArrayList<Capitan>();
//        DataInputStream entrada=null;
//        try{
//            entrada = new DataInputStream(new FileInputStream(rutaArchivo));
//            while(true){
//                var codigo=entrada.readInt();
//                var nombre=entrada.readUTF();
//                var pais=entrada.readUTF();
//                var capitan = new Capitan(codigo,nombre,pais);
//                capitanList.add(capitan);
//            }
//        }catch(IOException e){
//            entrada.close();
//        }
//        
//        return capitanList;
//    }    
    
}
